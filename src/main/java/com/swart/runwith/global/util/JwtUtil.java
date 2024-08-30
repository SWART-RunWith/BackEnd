package com.swart.runwith.global.util;

import com.swart.runwith.domain.user.entity.Auth;
import com.swart.runwith.domain.user.repository.AuthRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import javax.crypto.SecretKey;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
@Slf4j(topic = "JWT 로그")
public class JwtUtil {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";
    // 토큰 유효 기간 (밀리초로 계산 / 1주일 = 604800초)
    private static final long ACCESS_TOKEN_VALIDITY_TIME = 60 * 60 * 1000L;
    private static final long REFRESH_TOKEN_VALIDITY_TIME = 60 * 60 * 3 * 1000L;
    private final AuthRepository authRepository;
    @Value("${jwt.secret.key}")
    private String secretKey;
    private SecretKey key;

    @PostConstruct
    protected void init() {
        byte[] bytes = Base64.getDecoder().decode(secretKey);
        key = Keys.hmacShaKeyFor(bytes);
    }

    public String createToken(String username) {
        Date date = new Date();

        return BEARER_PREFIX +
            Jwts.builder()
                .claims()
                .subject(username)
                .expiration(new Date(date.getTime() + ACCESS_TOKEN_VALIDITY_TIME))
                .issuedAt(date).and()
                .signWith(key)
                .compact();
    }

    public String createRefreshToken() {
        Date date = new Date();

        return BEARER_PREFIX +
            Jwts.builder()
                .claims()
                .expiration(new Date(date.getTime() + REFRESH_TOKEN_VALIDITY_TIME))
                .issuedAt(new Date(System.currentTimeMillis())).and()
                .signWith(key)
                .compact();
    }

    public String getTokenFromRequest(HttpServletRequest httpServletRequest)
        throws IOException, ServletException {
        return httpServletRequest.getHeader(AUTHORIZATION_HEADER);
    }

    public String substringToken(String tokenValue) {
        if (StringUtils.hasText(tokenValue)) {
            if (tokenValue.startsWith(BEARER_PREFIX)) {
                return tokenValue.substring(7);
            } else {
                throw new IllegalArgumentException("token 형식을 맞춰주세요. [Bearer + token]");
            }
        } else {
            throw new NullPointerException("token이 없습니다.");
        }
    }

    public Boolean isExpired(String token) {
        long expireTime = Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getExpiration()
            .getTime();

        long now = new Date().getTime();

        return !(((expireTime - now) % 1000) + 1 >= 0);
    }

    public boolean validateToken(String token) {
        try {
            Claims info = getUserInfoFromToken(token);
            log.info(info.toString());
            Auth auth = authRepository.findByEmail(info.getSubject()).orElse(null);

            if (auth != null && auth.getRefreshToken() != null) {
                // access token 유효/만료 확인
                return !isExpired(token);
            }
        } catch (SecurityException | MalformedJwtException | SignatureException e) {
            log.error("Invalid JWT signature : 잘못된 JWT 서명");
        } catch (ExpiredJwtException e) {
            log.error("Expired JWT token : 만료된 JWT token");
        } catch (UnsupportedJwtException e) {
            log.error("Unsupported Jwt token : 지원하지 않는 JWT token");
        } catch (IllegalArgumentException e) {
            log.error("Jwt claims is empty : 잘못된 JWT token");
        }
        return false;
    }

    public Claims getUserInfoFromToken(String token) {
        return Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }
}

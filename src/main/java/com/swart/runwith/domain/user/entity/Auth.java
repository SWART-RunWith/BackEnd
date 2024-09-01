package com.swart.runwith.domain.user.entity;

import com.swart.runwith.enums.UserRole;
import com.swart.runwith.global.converter.UserRoleConverter;
import com.swart.runwith.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Auth extends BaseEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true)
    String email;
    @Column(nullable = false)
    String password;
    @Convert(converter = UserRoleConverter.class)
    @Column(nullable = false)
    UserRole userRole;
    @Column
    String refreshToken;
    @OneToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    UserInfo userInfo;

    @Builder
    public Auth(
        final String email,
        final String password,
        final UserInfo userInfo
    ) {
        this.email = email;
        this.password = password;
        this.userInfo = userInfo;
        this.userRole = UserRole.ROLE_USER;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority(userRole.name()));

        return grantedAuthorityList;
    }

    @Override
    public String getUsername() {
        return email;
    }
}

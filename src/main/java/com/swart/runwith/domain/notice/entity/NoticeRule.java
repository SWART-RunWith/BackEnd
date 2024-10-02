package com.swart.runwith.domain.notice_rule.entity;

import com.swart.runwith.domain.crew_user.entity.CrewUser;
import com.swart.runwith.domain.notice.entity.Notice;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoticeRule extends Notice {

    @Builder
    public NoticeRule(
        final String title,
        final String content,
        final String imageUrl,
        final CrewUser crewUser
    ) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.crewUser = crewUser;
    }
}

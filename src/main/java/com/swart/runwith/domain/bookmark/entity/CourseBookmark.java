package com.swart.runwith.domain.bookmark.entity;

import com.swart.runwith.domain.folder.entity.Folder;
import com.swart.runwith.domain.running_data.entity.RunningData;
import com.swart.runwith.domain.user.entity.UserInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Table
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CourseBookmark extends Bookmark {

    @JoinColumn(nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private RunningData runningData;

    @Builder
    public CourseBookmark(
        final UserInfo userInfo,
        final Folder folder,
        final String title,
        final RunningData runningData
    ) {
        this.userInfo = userInfo;
        this.folder = folder;
        this.title = title;
        this.runningData = runningData;
    }
}

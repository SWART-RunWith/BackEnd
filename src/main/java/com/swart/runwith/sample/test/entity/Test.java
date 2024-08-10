package com.swart.runwith.sample.test.entity;

import com.swart.runwith.sample.test.dto.service.request.TestUpdateServiceRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "TEST")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false)
    @Size(min = 2, max = 10)
    private String field;
    @Column
    private String title;
    @Column
    private String introduction;

    @Builder
    public Test(
        String field,
        String title,
        String introduction
    ) {
        this.field = field;
        this.title = title;
        this.introduction = introduction;
    }

    public void updateTest(TestUpdateServiceRequestDto requestDto) {
        if (requestDto.title() != null) {
            updateTitle(requestDto.title());
        }

        if (requestDto.field() != null) {
            updateField(requestDto.field());
        }

        if (requestDto.introduction() != null) {
            updateIntroduction(requestDto.introduction());
        }
    }

    private void updateTitle(String title) {
        this.title = title;
    }

    private void updateField(String field) {
        this.field = field;
    }

    private void updateIntroduction(String introduction) {
        this.introduction = introduction;
    }

}

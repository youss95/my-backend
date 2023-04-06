package com.myp.project.dto;


import com.myp.project.domain.ProjectStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter

public class ProjectStatusNumber {

    private Long complete;
    private Long inquiry;
    private Long ongoing;

    public ProjectStatusNumber() {
        this.complete = 0L;
        this.inquiry = 0L;
        this.ongoing = 0L;
    }

    public ProjectStatusNumber(Long complete, Long inquiry, Long ongoing) {
        this.complete = complete;
        this.inquiry = inquiry;
        this.ongoing = ongoing;
    }

    public void setCount(ProjectStatus status, Long count) {
        switch (status) {
            case COMPLETE:
                this.complete = count;
                break;
            case INQUIRY:
                this.inquiry = count;
                break;
            case ONGOING:
                this.ongoing = count;
                break;
            default:
                new ProjectStatusNumber();
                break;
        }

    }
}

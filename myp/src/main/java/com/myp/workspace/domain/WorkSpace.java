package com.myp.workspace.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.myp.core.domain.BaseDate;
import com.myp.project.domain.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "ya_workspace")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class WorkSpace extends BaseDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workspace_id")
    private Long wkId;

    private String name;

    /**
     * 접근 권한
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "workspace_category_tp")
    private CategoryType category;

    @OneToMany(mappedBy = "workSpace")
    private List<Project> projects = new ArrayList<>();

    // IMG

    // 참여자
    @OneToMany(mappedBy = "workSpace")
    private List<CoWorker> participants = new ArrayList<>();

    public void isAccessible(CategoryType category) {
      switch (category) {
          case PUBLIC:
              //TODO: make user accessible
              break;
          case PRIVATE:
              //TODO: make user accessible when permitted
              break;
          default:
              //TODO: make user not accessible
      }
    }


}

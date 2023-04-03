package com.myp.project.repository;

import static com.myp.project.domain.QProject.project;

import com.myp.project.domain.ProjectStatus;
import com.myp.project.dto.ProjectStatusNumber;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;


@RequiredArgsConstructor
public class ProjectRepositoryImpl implements ProjectRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    private final EntityManager em;

    @Override
    public void updateProject(String projectName, String description, Long projectId) {
        queryFactory
                .update(project)
                .set(project.projectName, projectName)
                .set(project.description, description)
                .where(project.id.eq(projectId))
                .execute();
        em.clear();
    }

    @Override
    public ProjectStatusNumber getCurrentStatusNumber(Long workSpaceId) {
        ProjectStatusNumber projectStatusNumber = new ProjectStatusNumber();

      List<Tuple> list = queryFactory.select(project.id.count(), project.projectStatus)
               .from(project)
               .groupBy(project.projectStatus)
               .fetch();

        for(Tuple tuple : list) {
            ProjectStatus name = tuple.get(project.projectStatus);
            Long num = tuple.get(project.id.count());
            projectStatusNumber.setCount(name, num);
        }
        return projectStatusNumber;
    }
}

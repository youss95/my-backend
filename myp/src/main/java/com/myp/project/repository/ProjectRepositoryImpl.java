package com.myp.project.repository;

import com.myp.project.domain.CategoryType;
import static com.myp.project.domain.QProject.project;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;


@RequiredArgsConstructor
public class ProjectRepositoryImpl implements ProjectRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    private final EntityManager em;
    @Override
    public void updateProject(String projectName, CategoryType category, Long projectId) {
        queryFactory
                .update(project)
                .set(project.projectName, projectName)
                .set(project.categoryType, category)
                .where(project.id.eq(projectId))
                .execute();
        em.clear();
    }
}

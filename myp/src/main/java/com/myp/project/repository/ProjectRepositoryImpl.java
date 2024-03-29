package com.myp.project.repository;

import static com.myp.project.domain.QProject.project;

import com.myp.core.common.GeneralConstant;
import com.myp.project.domain.ProjectStatus;
import com.myp.project.dto.ProjectResponse;
import com.myp.project.dto.ProjectStatusNumber;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.DateTemplate;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberTemplate;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    private BooleanExpression betweenRecentDate(LocalDateTime startDate ,LocalDateTime endDate) {
        if(startDate == null || endDate == null) {
            return null;
        }
        BooleanExpression isGoeStartDate = project.createdDateTime.goe(startDate);
        BooleanExpression isLoeEndDate = project.createdDateTime.loe(endDate);
        return Expressions.anyOf(isGoeStartDate,isLoeEndDate);
    }

    @Override
    public List<ProjectResponse> getRecentProjects(long wkId, LocalDateTime startDate, LocalDateTime endDate) {

        return queryFactory.select(Projections
                .constructor(ProjectResponse.class,
                        project.id,
                        project.description,
                        project.projectName,
                        project.projectStatus,
                        Expressions.as(Expressions.numberTemplate(Integer.class, "function('datediff',{0},{1})",
                                project.endDate,project.startDate),"leftDays")
                        ))
                .from(project)
                .where(project.workSpace().wkId.eq(wkId),betweenRecentDate(startDate,endDate)).fetch();
    }
}

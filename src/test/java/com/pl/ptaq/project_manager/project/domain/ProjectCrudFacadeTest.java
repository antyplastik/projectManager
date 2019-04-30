package com.pl.ptaq.project_manager.project.domain;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ProjectCrudFacadeTest {

    @Autowired
    ProjectRepository projectRepository;

    private ProjectCrudFacade projectService;
    private ProjectDto projectDto;

    @Before
    public void setUp() throws Exception {
        projectService = new ProjectCrudService(projectRepository);

        String projectCode = "test/project";
        String projectName = "New project for tests";
        String teamId = "Cyganie";
        String projectDescription = "Test created for tests";

        projectDto = new ProjectDto().builder()
                .projectCode(projectCode)
                .projectName(projectName)
                .teamId(teamId)
                .projectDescription(projectDescription)
                .adminLogin(null)
                .build();
    }

    @Test
    public void WHEN_new_project_does_not_exist_in_database_and_after_add_is_exist_THEN_true() {
        assertTrue(projectService.addProject(
                projectDto.getProjectCode(),
                projectDto.getProjectName(),
                projectDto.getTeamId(),
                projectDto.getProjectDescription(),
                projectDto.getAdminLogin()
                )
        );
    }

    @Test
    public void WHEN_add_new_project_that_already_exist_THEN_false(){
        projectRepository.save(ProjectMapper.map(projectDto));
        assertFalse(projectService.addProject(
                projectDto.getProjectCode(),
                projectDto.getProjectName(),
                projectDto.getTeamId(),
                projectDto.getProjectDescription(),
                projectDto.getAdminLogin()
                )
        );
    }

    @Test
    public void WHEN_found_exist_project_THEN_return_project() {
        projectRepository.save(ProjectMapper.map(projectDto));
        assertNotNull(projectService.findProject(projectDto.getProjectCode(), projectDto.getProjectName()));
    }

    @Test
    public void WHEN_cant_find_project_THEN_return_null(){
        assertNull(projectService.findProject(projectDto.getProjectCode(), projectDto.getProjectName()));
    }

    @Ignore
    @Test
    public void findProjects() {
    }

    @Test
    public void WHEN_found_exist_project_THEN_return_true() {
        projectRepository.save(ProjectMapper.map(projectDto));
        assertTrue(projectService.isProjectExist(projectDto.getProjectCode(), projectDto.getProjectName()));
    }

    @Test
    public void WHEN_project_does_not_exist_or_cant_find_THEN_return_false(){
        assertFalse(projectService.isProjectExist(projectDto.getProjectCode(), projectDto.getProjectName()));
    }

    @Test
    public void WHEN_update_project_found_and_modified_entities_are_not_the_same_THEN_return_true() {
        projectRepository.save(ProjectMapper.map(projectDto));
        assertTrue(projectService.updateProject(
                projectDto.getProjectCode(),
                "modified/test",
                "Eskimosi",
                "Modified test description",
                null
                )
        );
    }

    @Test
    public void WHEN_delete_exist_project_and_after_project_does_not_exist_THEN_retrun_true() {
        projectRepository.save(ProjectMapper.map(projectDto));
        assertTrue(projectService.deleteProject(projectDto.getProjectCode()));
    }
}
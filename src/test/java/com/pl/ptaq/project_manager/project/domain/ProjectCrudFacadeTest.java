package com.pl.ptaq.project_manager.project.domain;

import com.pl.ptaq.project_manager.user.domain.UserCrudInterface;
import com.pl.ptaq.project_manager.user.domain.UserCrudService;
import com.pl.ptaq.project_manager.user.domain.UserRepository;
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

    @Autowired
    UserRepository userRepository;
    UserCrudInterface userCrudFacade;

    private ProjectCrudInterface projectService;
    private ProjectDto projectDto;

    @Before
    public void setUp() throws Exception {
        projectService = new ProjectCrudService(projectRepository, userCrudFacade);
        userCrudFacade = new UserCrudService(userRepository);

        String projectCode = "test/project";
        String projectName = "New project for tests";
        String projectDescription = "Test created for tests";

        projectDto = new ProjectDto().builder()
                .projectCode(projectCode)
                .projectName(projectName)
                .team(null)
                .projectDescription(projectDescription)
                .projectManager(null)
                .build();
    }

    @Test
    public void WHEN_new_project_does_not_exist_in_database_and_after_add_is_exist_THEN_true() {
        assertTrue(projectService.addProject(projectDto, null));
    }

    @Test
    public void WHEN_add_new_project_that_already_exist_THEN_false() {
        boolean projectSaved = projectRepository.save(ProjectMapper.map(projectDto)) != null;

        assertTrue(projectSaved);
        assertFalse(projectService.addProject(projectDto, null));
    }

    @Test
    public void WHEN_found_exist_project_THEN_return_project() {
        boolean projectSaved = projectRepository.save(ProjectMapper.map(projectDto)) != null;

        assertTrue(projectSaved);
        assertNotNull(projectService.findProject(projectDto));
    }

    @Test
    public void WHEN_cant_find_project_THEN_return_null() {
        assertNull(projectService.findProject(projectDto));
    }

    @Ignore
    @Test
    public void findProjects() {
    }

    @Test
    public void WHEN_found_exist_project_THEN_return_true() {
        boolean projectSaved = projectRepository.save(ProjectMapper.map(projectDto)) != null;

        assertTrue(projectSaved);
        assertTrue(projectService.isProjectExist(projectDto));
    }

    @Test
    public void WHEN_project_does_not_exist_or_cant_find_THEN_return_false() {
        assertFalse(projectService.isProjectExist(projectDto));
    }

    @Test
    public void WHEN_update_project_found_and_modified_entities_are_not_the_same_THEN_return_true() {
        boolean projectSaved = projectRepository.save(ProjectMapper.map(projectDto)) != null;

        assertTrue(projectSaved);
        assertTrue(projectService.updateProject(new ProjectDto().builder()
                .projectCode("modified/test")
                .projectName("Modyfied project for tests")
                .projectDescription("Modified test description")
                .build(), projectDto, null));
    }

    @Test
    public void WHEN_delete_exist_project_and_after_project_does_not_exist_THEN_retrun_true() {
        boolean projectSaved = projectRepository.save(ProjectMapper.map(projectDto)) != null;

        assertTrue(projectSaved);
        assertTrue(projectService.deleteProject(projectDto));
    }
}
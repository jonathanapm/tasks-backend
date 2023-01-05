package br.ce.wcaquino.taskbackend.controller;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
public class TaskControllerTest {

    private TaskController controller;
    private Task task;

    @Mock
    private TaskRepo repo;

    @Before
    public void init() {
        this.task = new Task();
        this.controller = new TaskController();
    }

    @Test
    public void shouldNotSaveTaskWithoutDescription() {
        try {
            task.setDueDate(LocalDate.now());
            controller.save(task);
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the task description", e.getMessage());
        }
    }

    @Test
    public void shouldNotSaveTaskWithoutDate() {
        try {
            task.setTask("to study");
            controller.save(task);
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the due date", e.getMessage());
        }
    }

    @Test
    public void shouldNotSaveTaskWithPastDate() {
        try {
            task.setTask("to study");
            task.setDueDate(LocalDate.now().plusDays(-1));
            controller.save(task);
        } catch (ValidationException e) {
            Assert.assertEquals("Duee date must not be in past", e.getMessage());
        }
    }


}

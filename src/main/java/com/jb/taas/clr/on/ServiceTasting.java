package com.jb.taas.clr.on;


import com.jb.taas.beans.Task;
import com.jb.taas.dto.TaskDto;
import com.jb.taas.mapper.TaskMapper;
import com.jb.taas.services.TaskService;
import com.jb.taas.utils.Art;
import com.jb.taas.utils.Testing;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Order(2)
public class ServiceTasting implements CommandLineRunner {

    private final TaskService taskService;
    private final TaskMapper taskMapper;
    @Override
    public void run(String... args) throws Exception {
        System.out.println(Art.SERVICE_TESTING);
        Testing.printCaption("add tasks");
        Task toAdd1 = Task.builder()
                .group("Web")
                .title("HTML+CSS")
                .description("Online Kit with Amit")
                .when(Timestamp.valueOf(LocalDateTime.now().plusDays(6)))
                .build();

        TaskDto toAddDto1 = taskMapper.toDto(toAdd1);

        Task toAdd2 = Task.builder()
                .group("Web")
                .title("JS")
                .description("Online Kit with Idan")
                .when(Timestamp.valueOf(LocalDateTime.now().plusDays(19)))
                .build();

        TaskDto toAddDto2 = taskMapper.toDto(toAdd2);

        Task toAdd3 = Task.builder()
                .group("Web")
                .title("JS")
                .description("Online Kit with Idan")
                .when(Timestamp.valueOf(LocalDateTime.now().plusDays(19)))
                .build();

        TaskDto toAddDto3 = taskMapper.toDto(toAdd3);

        Task toAdd4 = Task.builder()
                .group("Web")
                .title("JS")
                .description("Online Kit with Idan")
                .when(Timestamp.valueOf(LocalDateTime.now().plusDays(19)))
                .build();

        TaskDto toAddDto4 = taskMapper.toDto(toAdd4);

        Task toAdd5 = Task.builder()
                .group("Web")
                .title("JS")
                .description("Online Kit with Idan")
                .when(Timestamp.valueOf(LocalDateTime.now().plusDays(19)))
                .build();

        TaskDto toAddDto5 = taskMapper.toDto(toAdd5);

        taskService.addTask(toAddDto1);
        taskService.addTask(toAddDto2);
        taskService.addTask(toAddDto3);
        taskService.addTask(toAddDto4);
        taskService.addTask(toAddDto5);
        taskService.getAllTasks().forEach(System.out::println);
        Testing.printCaption("update task");

        Task toUpdate = taskMapper.toDao(taskService.getOneTask(3));
        toUpdate.setGroup("Frontend");
        taskService.updateTask(3,taskMapper.toDto(toUpdate));
        taskService.getAllTasks().forEach(System.out::println);
        Testing.printCaption("get single task");
        try {
            System.out.println(taskService.getOneTask(8000));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(taskService.getOneTask(2));
        Testing.printCaption("count");
        System.out.println(taskService.count());
        Testing.printCaption("get all tasks");
        taskService.getAllTasks().forEach(System.out::println);
        Testing.printCaption("get all tasks by date asc");
        taskService.getAllTasksOrderByTimeAsc().forEach(System.out::println);
        Testing.printCaption("get all tasks by date desc");
        taskService.getAllTasksOrderByTimeDesc().forEach(System.out::println);
        Testing.printCaption("get all tasks between");
        Timestamp d1 = Timestamp.valueOf(LocalDateTime.now().minusDays(10));
        Timestamp d2 = Timestamp.valueOf(LocalDateTime.now().plusDays(10));
        try {
            taskService.getAllTasksBetween(d2, d1).forEach(System.out::println);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        taskService.getAllTasksBetween(d1,d2).forEach(System.out::println);
        Testing.printCaption("delete task");
        try {
            taskService.deleteTask(80000);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        taskService.deleteTask(1);
        taskService.getAllTasks().forEach(System.out::println);
    }
}

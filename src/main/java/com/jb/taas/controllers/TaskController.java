package com.jb.taas.controllers;

import com.jb.taas.dto.TaskDto;
import com.jb.taas.dto.TaskPayloadDto;
import com.jb.taas.exceptions.TaskSystemException;

import com.jb.taas.models.DatesBetweenReq;
import com.jb.taas.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/tasks")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TaskController {


    private final TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addTask(@Valid @RequestBody TaskPayloadDto taskDto) throws TaskSystemException {
        taskService.addTask(new TaskDto(taskDto));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTask(@PathVariable int id,@RequestBody TaskPayloadDto taskDto) throws TaskSystemException {
        taskService.updateTask(id,new TaskDto(taskDto));
    }

    @GetMapping
    public List<TaskDto> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskDto getOneTask(@PathVariable int id) throws TaskSystemException {
        return taskService.getOneTask(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable int id) throws TaskSystemException {
        taskService.deleteTask(id);
    }

    @GetMapping("count")
    public int count(){
        return taskService.count();
    }

    @GetMapping("sorted/time/asc")
    public List<TaskDto> getAllAsc(){
        return taskService.getAllTasksOrderByTimeAsc();
    }

    @GetMapping("sorted/time/desc")
    public List<TaskDto> getAllDesc(){
        return taskService.getAllTasksOrderByTimeDesc();
    }

    @GetMapping("btw/dates")
    public List<TaskDto> getAllTaskBetween(@RequestBody DatesBetweenReq datesBetween) throws TaskSystemException {
        return taskService.getAllTasksBetween(datesBetween.getStart(), datesBetween.getEnd());
    }


}
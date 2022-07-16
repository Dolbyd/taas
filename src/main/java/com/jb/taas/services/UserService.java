package com.jb.taas.services;

import com.jb.taas.dto.TaskDto;
import com.jb.taas.exceptions.TaskSystemException;

import java.util.List;

public interface UserService {

    List<TaskDto> getAllTasks(int userId);
    void addTask(int userId,TaskDto taskDto) throws TaskSystemException;
}
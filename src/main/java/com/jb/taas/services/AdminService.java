package com.jb.taas.services;

import com.jb.taas.dto.TaskDto;
import com.jb.taas.dto.UserDto;

import java.util.List;


public interface AdminService {

    int countUsers();
    int countTasks();
    List<TaskDto> getAllTasks();
    List<UserDto> getAllUsers();
}
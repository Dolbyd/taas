package com.jb.taas.controllers;

import com.jb.taas.dto.TaskDto;
import com.jb.taas.dto.UserDto;
import com.jb.taas.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AdminController {

    private final AdminService adminService;


    @GetMapping("tasks/count")
    public int countTasks(){
        return adminService.countTasks();
    }

    @GetMapping("users/count")
    public int countUsers(){
        return adminService.countUsers();
    }


    @GetMapping("tasks")
    public List<TaskDto> getAllTasks(){
        return adminService.getAllTasks();
    }

    @GetMapping("users")
    public List<UserDto> getAllUsers(){
        return adminService.getAllUsers();
    }
}
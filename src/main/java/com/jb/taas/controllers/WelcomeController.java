package com.jb.taas.controllers;

import com.jb.taas.dto.LoginReqDto;
import com.jb.taas.dto.LoginResDto;
import com.jb.taas.dto.RegisterReqDto;
import com.jb.taas.exceptions.TaskSecurityException;

import com.jb.taas.services.WelcomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;


@RestController
@RequestMapping("api/welcome")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class WelcomeController {

    private final WelcomeService welcomeService;

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody RegisterReqDto registerReqDto) throws TaskSecurityException {
        String email = registerReqDto.getEmail();
        String password = registerReqDto.getPassword();
        welcomeService.register(email, password);

    }

    @PostMapping("login")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResDto login(@Valid @RequestBody LoginReqDto loginReqDto) throws TaskSecurityException {
        String email = loginReqDto.getEmail();
        String password = loginReqDto.getPassword();
        UUID token = welcomeService.login(email, password);
        return new LoginResDto(token);
    }

}
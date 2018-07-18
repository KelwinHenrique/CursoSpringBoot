package com.neppo.cursospringboot.CursoSpringBoot.resources;


import com.neppo.cursospringboot.CursoSpringBoot.dto.EmailDTO;
import com.neppo.cursospringboot.CursoSpringBoot.security.JWTUtil;
import com.neppo.cursospringboot.CursoSpringBoot.security.UserSS;
import com.neppo.cursospringboot.CursoSpringBoot.services.AuthService;
import com.neppo.cursospringboot.CursoSpringBoot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(value="/auth")
public class AuthResource {


    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService authService;



    @RequestMapping(value="/refresh_token", method= RequestMethod.POST)
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        UserSS user = UserService.authenticated();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(value="/forgot", method= RequestMethod.POST)
    public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDto) {
        authService.sendNewPassword(objDto.getEmail());
        return ResponseEntity.noContent().build();
    }
}
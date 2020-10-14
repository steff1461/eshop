package be.technobel.eshop.controller;

import be.technobel.eshop.model.dto.UserDto;
import be.technobel.eshop.model.form.UserForm;
import be.technobel.eshop.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "/authenticate")
public class AuthenticationController  {

    private final UserServiceImpl userService;

    public AuthenticationController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UserDto> authenticateUser(@RequestBody UserForm userForm) {

       UserDto dto =  userService.authenticateUser(userForm);

        return ResponseEntity.ok(dto);
    }
}

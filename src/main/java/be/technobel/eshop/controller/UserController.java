package be.technobel.eshop.controller;

import be.technobel.eshop.model.dto.UserDto;
import be.technobel.eshop.model.form.UserForm;
import be.technobel.eshop.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController implements BaseController<UserForm, UserDto, Long> {

    private final UserServiceImpl service;

    public UserController(UserServiceImpl userService) {
        this.service = userService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/{id}")
    @Override
    public ResponseEntity<UserDto> findOne(@PathVariable("id") Long id) {

        return ResponseEntity.ok(service.findOne(id));
    }

    @PostMapping
    @Override
    public ResponseEntity<Boolean> create(@RequestBody UserForm form) throws Exception {


        return ResponseEntity.ok(service.save(form));
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {

        return ResponseEntity.ok(service.delete(id));
    }

    @PutMapping(path = "/{id}")
    @Override
    public ResponseEntity<UserDto> update(@RequestBody UserForm form, @PathVariable("id") Long id) {

        return ResponseEntity.ok(service.update(form, id));
    }
}

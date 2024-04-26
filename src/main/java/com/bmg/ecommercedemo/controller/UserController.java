package com.bmg.ecommercedemo.controller;

import com.bmg.ecommercedemo.business.abstracts.UserService;
import com.bmg.ecommercedemo.business.dtos.request.userRequests.CreateUserRequest;
import com.bmg.ecommercedemo.business.dtos.request.userRequests.UpdateUserRequest;
import com.bmg.ecommercedemo.business.dtos.response.userResponses.GetAllUserResponse;
import lombok.AllArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<GetAllUserResponse>> getAll() {

        return ResponseEntity.ok(this.userService.getAll());
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<List<GetAllUserResponse>> getById(@PathVariable long id) {

        return ResponseEntity.ok(this.userService.getUserById(id));
    }

    @PostMapping(value = "/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void add(@RequestBody CreateUserRequest request) {

        this.userService.addUser(request);
    }

    @PutMapping(value = "/update")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void update(@RequestBody UpdateUserRequest request) {

        this.userService.updateUser(request);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable long id) {

        try {
            this.userService.deleteUser(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

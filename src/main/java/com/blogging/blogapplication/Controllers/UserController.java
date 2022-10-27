package com.blogging.blogapplication.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blogging.blogapplication.Payloads.UserDto;
import com.blogging.blogapplication.Services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userdto) {

        UserDto createduser = userService.createUser(userdto);
        return new ResponseEntity<UserDto>(createduser, null, 200);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userdto, @PathVariable("id") Long id) {
        UserDto updatedUser = userService.updateUser(userdto, id);
        return new ResponseEntity<>(updatedUser, null, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getallusers() {
        List<UserDto> userlist = userService.getallUsers();
        return new ResponseEntity<>(userlist, null, 200);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto user = userService.getUserbyId(id);
        return new ResponseEntity<>(user, null, 200);
    }

}

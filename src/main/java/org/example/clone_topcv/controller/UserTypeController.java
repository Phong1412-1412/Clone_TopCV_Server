package org.example.clone_topcv.controller;

import org.example.clone_topcv.DTO.UserTypeRequest;
import org.example.clone_topcv.entities.UserManagement.UserType;
import org.example.clone_topcv.servives.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usertype")
public class UserTypeController {

    private final UserTypeService userTypeService;
    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserType>> getAllUserTypes() {
        return new ResponseEntity<>(userTypeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<UserType> saveUserType(@RequestBody UserTypeRequest userTypeRequest) {
        UserType saveUserType = userTypeService.saveUserType(userTypeRequest);
        return new ResponseEntity<>(userTypeService.save(saveUserType), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public String deleteUserType(@RequestParam Integer userTypeId) {
        userTypeService.delete(userTypeId);
        return "Deleted userType: " + userTypeId;
    }

}

package com.example.project3.Controller;

import com.example.project3.ApiResponse.ApiResponse;
import com.example.project3.Model.User;
import com.example.project3.Service.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;


    @GetMapping("/get")
    public ResponseEntity getAllUsers() {

        return ResponseEntity.status(200).body(userService.getAllUser());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUsers(user);
        return ResponseEntity.status(200).body(new ApiResponse("user added"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = userService.updateUser(id, user);
        return ResponseEntity.status(200).body(new ApiResponse("user is updated"));


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("user deleted"));

    }


    @PutMapping("buyproduct/{userId}/{pId}/{mId}")
    public ResponseEntity buyProduct(@PathVariable Integer userId, @PathVariable Integer pId, @PathVariable Integer mId) {
        boolean truepurchesed = userService.buyproduct(pId, mId, userId);
        if (truepurchesed) {
            return ResponseEntity.status(200).body(new ApiResponse("The product has been purchased"));
            }

        return ResponseEntity.status(400).body(new ApiResponse("The product can not be purchased"));
    }


    //return product to the merchant
    @PutMapping("returnProduct/{userId}/{pId}/{mId}")
    public ResponseEntity returnProduct(@PathVariable Integer userId, @PathVariable Integer pId, @PathVariable Integer mId) {
        boolean returnproduct = userService.returnProduct(pId, mId, userId);
        if (returnproduct) {
            return ResponseEntity.status(200).body(new ApiResponse("The product has been returned"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("The product can not be returned"));
    }






}

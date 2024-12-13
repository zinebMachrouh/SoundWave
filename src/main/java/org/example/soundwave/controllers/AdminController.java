package org.example.soundwave.controllers;

import lombok.AllArgsConstructor;
import org.example.soundwave.dto.RoleDTO;
import org.example.soundwave.dto.UserDTO;
import org.example.soundwave.entities.User;
import org.example.soundwave.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/admin")
@AllArgsConstructor
public class AdminController {
    private final UserService userService;

    // Users Management
    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        List<UserDTO> users = userService.findAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.badRequest().body("No users found");
        } else {
            return ResponseEntity.ok(users);
        }
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<?> findUserByUsername(String username) {
        Optional<User> user = userService.findByUsername(username);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }else {
            return ResponseEntity.badRequest().body("User not found");
        }
    }

    @PostMapping("/users/roles")
    public ResponseEntity<?> updateUserRole(@RequestBody String username, @RequestBody List<RoleDTO> roles) {
        User user = userService.updateUserRole(username, roles);
        return ResponseEntity.ok(user);
    }
}

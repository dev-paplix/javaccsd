// usersController.java

package com.example.ccsd.Users;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> usersList = usersService.getAllUsers();
        return ResponseEntity.ok(usersList);
    }

    // get user by id
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable String UserId) {
        return usersService.getUserById(UserId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addUser(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("address") String address,
            @RequestParam("role") String role,
            @RequestParam("username") String username,
            @RequestParam(value = "dob", required = false) String dob
    ) throws IOException {

        // Set Default Picture Path
        String imagePath = "src/main/resources/profpic.png";
        byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));

        Users users = new Users();
        users.setEmail(email);
        users.setPassword(password);
        users.setFirstName(firstName);
        users.setLastName(lastName);
        users.setPhoneNumber(phoneNumber);
        users.setAddress(address);
        users.setRole(role);
        users.setUsername(username);
        users.setDob(dob);
        users.setProfPic(imageBytes); // store image as byte array

        // Save the users in MongoDB
        Users savedusers = usersService.addUser(users);

        // Return a response
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("users", savedusers);

        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable String id, @RequestBody Users usersDetails) {
        Users updatedusers = usersService.updateUser(id, usersDetails);
        if (updatedusers != null) {
            return ResponseEntity.ok(updatedusers);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        usersService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody Users signInRequest) {
        // Use the service to fetch the user by email
        Users existingUser = usersService.getUserByEmail(signInRequest.getEmail());

        // Check if the user exists and passwords match
        if (existingUser != null && existingUser.getPassword().equals(signInRequest.getPassword())) {
            // If valid, prepare the redirection URL
            Map<String, String> response = new HashMap<>();
            response.put("redirectUrl", "http://localhost:3000/dashboard-admin");
            return ResponseEntity.ok(response);
        } else {
            // Return an error response for invalid credentials
            return ResponseEntity.status(401).body("Invalid email or password.");
        }
    }
}


    



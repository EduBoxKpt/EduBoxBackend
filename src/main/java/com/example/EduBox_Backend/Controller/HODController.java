package com.example.EduBox_Backend.Controller;

import com.example.EduBox_Backend.Model.HOD;
import com.example.EduBox_Backend.Service.HODService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/hod")
//@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class HODController {
    @Autowired
    private HODService hodService;

    @PostMapping("/register")
    public ResponseEntity<?> registerHOD(@RequestBody HOD hod) {
        try {
            HOD newHOD = hodService.createHOD(hod);
            return ResponseEntity.ok(newHOD);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginHOD(@RequestBody HOD loginRequest) {
        Optional<HOD> hod = hodService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        if (hod.isPresent()) {
            return ResponseEntity.ok(hod.get()); // If HOD is found, return the object.
        } else {
            return ResponseEntity.status(401).body("Invalid email or password."); // If not found, return error message.
        }
    }




}

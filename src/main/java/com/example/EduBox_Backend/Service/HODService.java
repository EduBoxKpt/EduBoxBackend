package com.example.EduBox_Backend.Service;

import com.example.EduBox_Backend.Model.HOD;
import com.example.EduBox_Backend.Repository.HODRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HODService {

    @Autowired
    private HODRepository hodRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // ✅ Create HOD (Ensure unique branch and email)
    public HOD createHOD(HOD hod) {
        if (hodRepository.findByBranch(hod.getBranch()).isPresent()) {
            throw new IllegalStateException("HOD already exists for branch: " + hod.getBranch());
        }

        if (hodRepository.findByEmail(hod.getEmail()).isPresent()) {
            throw new IllegalStateException("Email is already in use: " + hod.getEmail());
        }

        hod.setPassword(passwordEncoder.encode(hod.getPassword()));  // Encrypt password
        return hodRepository.save(hod);
    }

    // ✅ Authenticate HOD login
    public Optional<HOD> authenticate(String email, String password) {
        Optional<HOD> hod = hodRepository.findByEmail(email);
        if (hod.isPresent() && passwordEncoder.matches(password, hod.get().getPassword())) {
            return hod;
        }
        return Optional.empty();
    }
}

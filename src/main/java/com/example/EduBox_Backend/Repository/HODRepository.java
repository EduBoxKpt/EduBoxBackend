package com.example.EduBox_Backend.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.EduBox_Backend.Model.HOD;
import java.util.Optional;

public interface HODRepository extends MongoRepository<HOD, String> {
    Optional<HOD> findByEmail(String email);
  
        Optional<HOD> findByBranch(String branch);  // Find HOD by branch
  

}

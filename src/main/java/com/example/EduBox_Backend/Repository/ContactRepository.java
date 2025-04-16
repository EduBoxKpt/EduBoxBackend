package com.example.EduBox_Backend.Repository;

import com.example.EduBox_Backend.Model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {
}

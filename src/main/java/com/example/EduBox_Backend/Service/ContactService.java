package com.example.EduBox_Backend.Service;

import com.example.EduBox_Backend.Model.Contact;
import com.example.EduBox_Backend.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }
}

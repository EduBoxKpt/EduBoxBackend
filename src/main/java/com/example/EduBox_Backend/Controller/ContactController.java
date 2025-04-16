package com.example.EduBox_Backend.Controller;

import com.example.EduBox_Backend.Model.Contact;
import com.example.EduBox_Backend.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public String handleContact(@RequestBody Contact contact) {
        contactService.saveContact(contact);
        return "Thank you for contacting us!";
    }
}

package com.example.SimpleProject.controller;

import com.example.SimpleProject.dto.ApiResponse;
import com.example.SimpleProject.model.Contact;
import com.example.SimpleProject.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    to check the APIs in
    the browser
    - http://localhost:8090/api/contact/
    - then add the endpoints that you want
        - ex. /get
 */
@RestController
@RequestMapping("/api/contact") // for api custom mapping
public class ContactController {

    // dependency injection
    @Autowired
    private ContactService contactService;

    // response entity. this WRAPS AROUND your actual API requests
    // GET METHOD, gets all your data
    @GetMapping("/get")
    public ResponseEntity<ApiResponse<List<Contact>>> getAllContacts(){
        return ResponseEntity.ok(contactService.getAllContacts());
    }

    // POST METHOD, use @response body, for parameters
    @PostMapping("/post")
    public ResponseEntity<ApiResponse<Contact>> createContacts(@RequestBody Contact contact){
        return ResponseEntity.ok(contactService.addContact(contact));
    }

}

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
    /*
        this post request is only available in POSTMAN.
        1. connect folder or repo to post
        2. make a new request in PM
        3. select type
        4. put 'localhost:8090/api/contact/post' in field
        5. go to body tab, make sure raw and JSON are present
        6. fill out JSON according to Model structure
     */
    @PostMapping("/post")
    public ResponseEntity<ApiResponse<Contact>> createContacts(@RequestBody Contact contact){
        return ResponseEntity.ok(contactService.addContact(contact));
    }

    @DeleteMapping("/delete/{id}") // the {id} is a param that comes from @PathVariable
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable int id){
        return ResponseEntity.ok(contactService.deleteContact(id));
    }

    // updating, PUT api
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<Contact>> updateContact(@PathVariable int id, @RequestBody Contact contact) {
        return ResponseEntity.ok(contactService.updateContact(id, contact));
    }

}

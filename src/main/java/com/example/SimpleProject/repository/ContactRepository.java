package com.example.SimpleProject.repository;

// 3 BUILD THE REPOSITORY LAYER, THAT WOULD CONNECT TO A DATABASE

import com.example.SimpleProject.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository //this treats the file as a repo, where it connects to the database
public class ContactRepository {

    // MANUAL database, coming from a list of Model objects. temporary DB
    private final List<Contact> contactList = new ArrayList<Contact>();
    private int idCounter = 1;

    // gets the entire DB of Contact objects
    public List<Contact> findAll(){
        return new ArrayList<>(contactList);
    }

    // gets an individual Contact object out of the List via its unique ID
    public Optional<Contact> findById(int id){
        return contactList.stream()
                .filter(contact -> contact.getId() == id)
                .findFirst();
    }

    // saves a New Contact Object to the DB (just a list of Contact objects for now)
    public Contact save(Contact contact){
        if (contact.getId() == null || contact.getId() <= 0){
            contact.setId(idCounter++);
            contactList.add(contact);
        } else {
            deleteById(contact.getId());
            contactList.add(contact);
        }
        return contact;
    }

    public void deleteById(int id){
        contactList.removeIf(contact -> contact.getId() == id);
    }
}

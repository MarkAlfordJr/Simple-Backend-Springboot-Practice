package com.example.SimpleProject.service;

import com.example.SimpleProject.dto.ApiResponse;
import com.example.SimpleProject.model.Contact;
import com.example.SimpleProject.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

// 4 BUILD SERVICE LAYER, THAT CALLS THE REPOSITORY FILE, TO INTERACT WITH THE DB


@Service // tells spring boot that this is the service layer
public class ContactService {

//    private final ContactRepository contactRepository;
//    dependency injection. used for testing a Mock DB when needed
//    public ContactService(ContactRepository contactRepository){
//        this.contactRepository = contactRepository;
//    }

    // used for simpler way of dependency injection.
    @Autowired
    private ContactRepository contactRepository;

    // call to the DTO, for it to return the API response after EVERY request
    public ApiResponse<List<Contact>> getAllContacts(){
        List<Contact> contactList = contactRepository.findAll();
        return new ApiResponse<>(200,"All Contact Objects Retrieved", contactList);
    }

    public ApiResponse<Contact> addContact(Contact contact){
        Contact savedContact = contactRepository.save(contact);

        return new ApiResponse<>(201, "Contact Object Saved.", savedContact);
    }

    public ApiResponse<?> deleteContact(int id){
        if(contactRepository.findById(id).isPresent()) {
            contactRepository.deleteById(id);
            return new ApiResponse<>(204, "Contact Object Deleted Successfully", null);
        }
        return new ApiResponse<>(404, "Contact Object Not Found", null);
    }

    public ApiResponse<Contact> updateContact(int id, Contact updatedData){
        return contactRepository.findById(id)
                .map(exisingContact -> {
                   exisingContact.setName(updatedData.getName());
                   exisingContact.setPhoneNumber(updatedData.getPhoneNumber());
                   contactRepository.save(exisingContact);
                   return new ApiResponse<>(200, "Contact updated Successfully", exisingContact);
                })
                .orElse(new ApiResponse<>(404, "Contact Not Found", null));
    }
}

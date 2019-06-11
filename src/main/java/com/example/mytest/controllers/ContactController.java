package com.example.mytest.controllers;

import com.example.mytest.dao.ContactRepository;
import com.example.mytest.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public List<Contact> getContacts(){
        return  contactRepository.findAll();
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
    public Contact getCcontact(@PathVariable Integer id){
        return contactRepository.findOne(id);
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    public Contact save(@RequestBody Contact c){
        return contactRepository.save(c);
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE)
    public boolean supprimer(@PathVariable Integer id){
        contactRepository.delete(id);
        return true;
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.PUT)
    public Contact save(@PathVariable Integer id, @RequestBody Contact c){
        c.setId(id);
        return contactRepository.save(c);
    }

    @RequestMapping(value = "/chercherContacts", method = RequestMethod.GET)
    public Page<Contact> chercher(@RequestParam(name = "mc", defaultValue = "") String mc,
                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "size", defaultValue = "5") int size){
            return contactRepository.chercher("%"+mc+"%", new PageRequest(page, size));
    }
}

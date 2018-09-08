package ua.com.androlekss.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ua.com.androlekss.entity.Contact;
import ua.com.androlekss.repository.ContactRepository;
import ua.com.androlekss.service.ContactService;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitialDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {
 
    boolean alreadySetup = false;
 
    @Autowired
    private ContactService contactService;

  
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Contact contact1 = new Contact();
        contact1.setId(1L);
        contact1.setName("Jonathan");

        Contact contact2 = new Contact();
        contact2.setId(2L);
        contact2.setName("Elisabet");

        Contact contact3 = new Contact();
        contact3.setId(3L);
        contact3.setName("Andriy");


        contactService.saveContact(contact1);
        contactService.saveContact(contact2);
        contactService.saveContact(contact3);

 
        alreadySetup = true;
    }
 

}
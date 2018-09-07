package ua.com.androlekss.service;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import ua.com.androlekss.entity.Contact;

import java.util.List;

public interface ContactService {

    @Cacheable("contactsCache")
    List<Contact> getAllContact();

    @CacheEvict("contactsCache")
    Contact saveContact(Contact contact);

}

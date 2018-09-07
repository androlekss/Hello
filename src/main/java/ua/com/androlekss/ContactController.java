package ua.com.androlekss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.androlekss.entity.Contact;
import ua.com.androlekss.repository.ContactRepository;
import ua.com.androlekss.service.ContactService;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RequestMapping("/hello")
@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public ResponseEntity<List<Contact>> contacts(@RequestParam("nameFilter") String nameFilter) {

        Predicate<Contact> predicate = contact -> !(contact.getName().matches(nameFilter));

        List<Contact> contacts = contactService.getAllContact();

        contacts = contacts
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());

        return new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);
    }
}
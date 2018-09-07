package ua.com.androlekss;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ua.com.androlekss.entity.Contact;
import ua.com.androlekss.service.ContactService;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactController.class)
public class ContactControllerTest {

    @Autowired
	private MockMvc mvc;

	@MockBean
	private ContactService contactService;


    @Test
    public void contacts() throws Exception{

        Contact contact1 = new Contact();
        contact1.setId(1L);
        contact1.setName("Jonathan");

        Contact contact2 = new Contact();
        contact2.setId(2L);
        contact2.setName("Elisabet");

        Contact contact3 = new Contact();
        contact3.setId(3L);
        contact3.setName("Andriy");

        List<Contact> contactList = new ArrayList<>();

        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);

        given(contactService.getAllContact()).willReturn(contactList);
        mvc.perform(get("/hello/contacts?nameFilter=^A.*$")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is(contact1.getName())));


    }
}
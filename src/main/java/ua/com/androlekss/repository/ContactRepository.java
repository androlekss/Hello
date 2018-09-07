package ua.com.androlekss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.androlekss.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}

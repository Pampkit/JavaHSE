package test.java;
import Models.Contact;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Test
    void testConstructorAndGetters() {
        Contact contact = new Contact(1, "Bob", "Smith", "123", "+123456789", "Friend");

        assertEquals(1, contact.getId());
        assertEquals("Bob", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("123", contact.getAddress());
        assertEquals("+123456789", contact.getPhone());
        assertEquals("Friend", contact.getNote());
    }

}

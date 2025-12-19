package Contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	@Test
	void testAddContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("00001", "Sasuke", "Uchiha", "1234567890", "Hidden Leaf Village");
		
		service.addContact(contact);
		
		// confirm contact was added
		assertEquals("Sasuke", service.getContact("00001").getFirstName());
	}
	
	@Test
	void testAddDuplicateIDThrowsException() {
		ContactService service = new ContactService();
		
		Contact c1 = new Contact("00001", "Sasuke", "Uchiha", "1234567890", "Hidden Leaf Village");
		Contact c2 = new Contact("00001", "Sasuke", "Uchiha", "1234567890", "Hidden Leaf Village");
		
		service.addContact(c1);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(c2); // same ID, should fail
		});
	}
	
	@Test
	void testDeleteContact() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("00001", "Sasuke", "Uchiha", "1234567890", "Hidden Leaf Village");
		
		service.addContact(contact);
		service.deleteContact("00001");
		
		assertNull(service.getContact("00001"));
	}
	
	@Test
	void testDeleteNonexistentContactThrowsException() {
		ContactService service = new ContactService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("DoesNotExist");
		});
	}
	
	@Test
	void testUpdateFirstName() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("00001", "Sasuke", "Uchiha", "1234567890", "Hidden Leaf Village");
		service.addContact(contact);
		
		service.updateFirstName("00001", "Itachi"); //brother
		
		assertEquals("Itachi", service.getContact("00001").getFirstName());
	}
	
	@Test
	void testUpdateLastName() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("00001", "Sasuke", "Uchiha", "1234567890", "Hidden Leaf Village");
		service.addContact(contact);
		
		service.updateLastName("00001", "Hatake");
		
		assertEquals("Hatake", service.getContact("00001").getLastName());
	}
	
	@Test
	void testUpdatePhone() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("00001", "Sasuke", "Uchiha", "1234567890", "Hidden Leaf Village");
		service.addContact(contact);
		
		service.updatePhone("00001", "5555551234");
		
		assertEquals("5555551234", service.getContact("00001").getPhone());
	}
	
	@Test
	void testUpdateAddress() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("00001", "Sasuke", "Uchiha", "1234567890", "Hidden Leaf Village");
		service.addContact(contact);
		
		service.updateAddress("00001", "Uchiha Compound");
		
		assertEquals("Uchiha Compound", service.getContact("00001").getAddress());
	}
	
	@Test
	void testUpdateOnMissingIDThrowsExeption() {
		ContactService service = new ContactService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateFirstName("MissingID", "Itachi");
		});
	}
}

package Contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {
	// Test valid contact
	@Test
	void testValidContactCreation() {
		Contact contact = new Contact("00001", "Sasuke", "Uchiha", "1234567890", "Hidden Leaf Village");
		assertEquals("00001", contact.getContactID());
		assertEquals("Sasuke", contact.getFirstName());
		assertEquals("Uchiha", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("Hidden Leaf Village", contact.getAddress());
	}
	
	// Test invalid ID
	@Test
	void testInvalidContactIDTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "Sasuke", "Uchiha", "1234567890", "Hidden Leaf Village");
		});
	}
	
	// Test null ID
	@Test
	void testInvalidContactIDNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Sasuke", "Uchiha", "1234567890", "Hidden Leaf Village");
		});
	}
	
	// Test invalid long first name
	@Test
	void testInvalidFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("00002", "SasukeTheAvenger", "Uchiha", "1234567890", "Hidden Leaf Village");
		});
	}
	
	// Test invalid long last name
	@Test
	void testInvalidLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("00003", "Sasuke", "UchihaClanLeaderLongName", "1234567890", "Hidden Leaf Village");
		});
	}
	
	// Test invalid phone number
	@Test
	void testInvalidPhoneLength() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("00004", "Sasuke", "Uchiha", "12345", "Hidden Leaf Village");
		});
	}
	
	// Test invalid phone number with letters
	@Test
	void testInvalidPhoneLetters() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("00005", "Sasuke", "Uchiha", "A234567890", "Hidden Leaf Village");
		});
	}
	
	// Test invalid address
	@Test
	void testInvalidAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("00006", "Sasuke", "Uchiha", "1234567890", "ThisAddressIsWayTooLongToFitInsideTheThirtyCharacterLimitOfThisAssignment");
		});
	}
	
	// Test updating first name
	@Test
	void testUpdateFirstName() {
		Contact contact = new Contact("00007", "Sasuke", "Uchiha", "1234567890", "Hidden Leaf Village");
		contact.setFirstName("Itachi");
		assertEquals("Itachi", contact.getFirstName());
	}
	
	// Test updating phone number with invalid input
	@Test
	void testUpdatePhoneInvalid() {
		Contact contact = new Contact("00008", "Sasuke", "Uchiha", "1234567890", "Hidden Leaf Village");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("NotANumber");
		});
	}
	
	// Test contact ID immutability
	@Test
	void testContactIDIsNotUpdatable() {
		Contact contact = new Contact("00009", "Sasuke", "Uchiha", "1234567890", "Hidden Leaf Village");
		assertEquals("00009", contact.getContactID());
		
		// Confirm no setter exists
		assertThrows(NoSuchMethodException.class, () -> {
			contact.getClass().getDeclaredMethod("setContactID", String.class);
		});
	}
}
package Contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	//store contacts using their unique ID as the key
	private final Map<String, Contact> contacts = new HashMap<>();
	
	// add a new contact (must have a unique ID)
	public void addContact(Contact contact) {
		if (contact == null) {
			throw new IllegalArgumentException("Contact cannot be null");
		}
		
		if (contacts.containsKey(contact.getContactID())) {
			throw new IllegalArgumentException("Contact ID already exists");
		}
		contacts.put(contact.getContactID(), contact);
	}
	
	// Delete a contact by ID
	public void deleteContact(String contactID) {
		if (contactID == null || !contacts.containsKey(contactID)) {
			throw new IllegalArgumentException("Contact ID not found");
		}
		contacts.remove(contactID);
	}
	
	// Update first name
	public void updateFirstName(String contactID, String newFirstName) {
		Contact contact = getContactByID(contactID);
		contact.setFirstName(newFirstName);
	}
	
	// Update last name
	public void updateLastName(String contactID, String newLastName) {
		Contact contact = getContactByID(contactID);
		contact.setLastName(newLastName);
	}
	
	// update phone number
	public void updatePhone(String contactID, String newPhone) {
		Contact contact = getContactByID(contactID);
		contact.setPhone(newPhone);
	}
	
	// update address
	public void updateAddress(String contactID, String newAddress) {
		Contact contact = getContactByID(contactID);
		contact.setAddress(newAddress);
	}
	
	// Helper method to find a contact by ID safely
	private Contact getContactByID(String contactID) {
		Contact contact = contacts.get(contactID);
		if (contact == null) {
			throw new IllegalArgumentException("Contact ID not found");
		}
		return contact;
	}
	
	// Helper used by test
	public Contact getContact(String contactID) {
		return contacts.get(contactID);
	}
}

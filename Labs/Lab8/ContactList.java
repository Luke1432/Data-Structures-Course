import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class representing a contact list that allows for multiple contact methods (e.g., phone numbers) per name.
 */
public class ContactList {
    private final Map<String, List<ContactMethod>> contacts;

    /*
     *  BELOW ARE THE METHODS FOR PART 1
     *
     */

    /**
     * Constructor to initialize the contact list.
     */
    public ContactList() {
        contacts = new HashMap<>();
    }

    /**
     * Adds a contact method (e.g., phone number) to the contact list for the given name.
     *
     * @param name   The name of the contact.
     * @param method The type of contact method (e.g., "phone", "email").
     * @param value  The value of the contact method (e.g., the actual phone number or email address).
     */
    public void addContactMethod(String name, String method, String value) {
        // TODO: Implement this method
        ContactMethod newContactMethod=new ContactMethod(method, value);
        List<ContactMethod> methods=new ArrayList<>();
        
        if(contacts.containsKey(name)){
            contacts.computeIfAbsent(name, k -> new ArrayList<>()).add(newContactMethod);
            methods.add(newContactMethod);
        }else{
            methods.add(newContactMethod);
            contacts.put(name,methods);
        }

    }

    /**
     * Gets the number of contacts in the contact list.
     *
     * @return The number of contacts.
     */
    public int getSize() {
        return contacts.size();
    }

    /**
     * Prints the contact list in the following format, where X is the total number of contacts:
     *
     * All Contacts: (X)
     *
     * Contact name:
     *     contact method: value
     *     ...
     *
     * ...
     */
    public void printContacts() {
        // TODO: Implement this method
        System.out.println("All Contacts: ("+getSize()+")");
        for(String name:contacts.keySet()){
            System.out.println(name+":");
            for(ContactMethod method:contacts.get(name)){
                System.out.println("    "+method);
            }
        }
        System.out.println("All contact info for Bob: \n"+getContactMethods("Bob"));

    }

    /**
     * Retrieves the list of contact methods for the given name.
     *
     * @param name The name of the contact.
     * @return The list of contact methods, or null if the contact does not exist.
     */
    public List<ContactMethod> getContactMethods(String name) {
        return contacts.get(name);
    }

    /*
     *  BELOW ARE THE METHODS FOR PART 2
     *
     */


    /**
     * Checks if the contact list contains a contact with the given name.
     *
     * @param name The name to check.
     * @return True if the contact list contains the name, false otherwise.
     */
    public boolean containsContact(String name) {
        // TODO: Implement this method
        return contacts.containsKey(name);
    }

    /**
     * Removes a specific contact method (e.g., phone number) from the contact list for the given name.
     *
     * @param name   The name of the contact.
     * @param method The type of contact method to remove.
     * @param value  The value of the contact method to remove.
     */
    public void removeContactMethod(String name, String method, String value) {
            List<ContactMethod> methods = contacts.get(name);

    // Check if the user exists and has contact methods
    if (methods != null) {
        List<ContactMethod> toRemove = new ArrayList<>();
        
        // Find the contact methods to remove
        for (int i = 0; i < methods.size(); i++) {
            ContactMethod contactMethod = methods.get(i);
            if (contactMethod.getMethod().equals(method) && contactMethod.getValue().equals(value)) {
                toRemove.add(contactMethod);
            }
            if(i==methods.size()-1 && !contactMethod.getMethod().equals(method) && !contactMethod.getValue().equals(value)){
                System.out.println("No "+method+" was found to remove for "+name);
            }
        }

        // Remove the marked contact methods from the original list
        methods.removeAll(toRemove);

        // Remove the name entry if the list is now empty
        if (methods.isEmpty()) {
            contacts.remove(name);
        }
    } else {
        System.out.println("No contact methods found for " + name);
    }
    }

    /**
     * A class representing a single contact method.
     */
    public static class ContactMethod {
        private final String method;
        private final String value;

        /**
         * Constructs a contact method with the specified method and value.
         *
         * @param method The type of contact method (e.g., "phone", "email").
         * @param value  The value of the contact method (e.g., the actual phone number or email address).
         */
        public ContactMethod(String method, String value) {
            this.method = method;
            this.value = value;
        }

        /**
         * Gets the contact method.
         *
         * @return The contact method.
         */
        public String getMethod() {
            return method;
        }

        /**
         * Gets the contact value.
         *
         * @return The contact value.
         */
        public String getValue() {
            return value;
        }

        /**
         * Returns a string representation of the contact method.
         *
         * @return The string representation of the contact method.
         */
        @Override
        public String toString() {
            return method + ": " + value;
        }
    }

    /**
     * Main method to test the ContactList class.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        // TODO: Implement this method to test your ContactList
    }
}

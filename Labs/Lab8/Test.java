public class Test{
    public static void main(String[] args) {
        ContactList cList=new ContactList();
        cList.addContactMethod("Bob", "Phone", "987-654-3210");
        cList.addContactMethod("Bob", "Work Phone", "1-888-234-8797 ext 667");
        cList.addContactMethod("Alice", "Email", "alice@example.com");
        cList.addContactMethod("Alice", "Phone", "123-456-7890");
        cList.addContactMethod("Alice", "instagram", "@AlicesAdventures");
        cList.addContactMethod("Charlie", "Phone", "555-555-5555");
        cList.printContacts();
        System.out.println(cList.containsContact("Charles"));
        cList.removeContactMethod("Alice","Phone","123-456-7890");
        cList.printContacts();
        System.out.println("Do we have contact info for Bob? "+(cList.containsContact("Bob")?"Yes":"No"));
        System.out.println("Do we have contact info for Charlie? "+(cList.containsContact("Charlie")?"Yes":"No"));
        System.out.println("Remove Bob's Instagram: ");
        cList.removeContactMethod("Bob", "instagram", "@Bobs");
        cList.removeContactMethod("Charlie", "Phone", "555-555-5555");
        cList.printContacts();

    }
}
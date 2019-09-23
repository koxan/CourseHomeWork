
import java.util.Arrays;

/**
 * Created by Вит on 13.02.2017.
 */
public class AddressBook {
    private Contact[] contacts;
    private int currentBookIndex;

    public AddressBook(int initSize) {
        if (initSize < 1) {
            throw new RuntimeException("Initial size can't be less than 1");
        }
        contacts = new Contact[initSize];
        currentBookIndex = -1;
    }

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new RuntimeException("Error:: contact can't be null");
        }
        currentBookIndex = currentBookIndex + 1;
        if (contacts.length <= currentBookIndex) {
            int newLength = contacts.length * 2;
            contacts = Arrays.copyOf(this.contacts, newLength);
            contacts[currentBookIndex] = contact;
            return;
        }
        contacts[currentBookIndex] = contact;
    }

    public boolean removeContact(Contact contact) {
        if (contact == null) {
            return false;
        }
        for (int i = 0; i < contacts.length; i++) {
            if (contact.equals(contacts[i])) {
                contacts[i] = null;
                currentBookIndex = currentBookIndex - 1;
                return true;
            }
        }
        return false;
    }

}


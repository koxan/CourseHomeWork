/**
 * Created by Вит on 13.02.2017.
 */
public class Contact {
    private String name;
    private String phoneNumber;
    private String email;



    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;

        Contact contact = (Contact) o;

        if (!name.equals(contact.name)) return false;
        if (!phoneNumber.equals(contact.phoneNumber)) return false;
        return email != null ? email.equals(contact.email) : contact.email == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
    public static void main(String[] args) {
        Contact contact = new Contact("Vit", "0638235823","mono9007@mail.ru");
        Contact contact1 = new Contact("Vit", "sdewfef");
        Contact contact3 = new Contact("Сергей","0665467789");
        AddressBook book = new AddressBook(50);
        book.addContact(contact);
        book.addContact(contact1);
        book.addContact(contact3);
        book.removeContact(contact);
        book.removeContact(contact1);
        System.out.println("Имя контакта: "+contact.name+"\nНомер телефона: "+contact.phoneNumber+"\nEmail: "+contact.email);
        System.out.println("Имя контакта: "+contact3.name+"\nНомер телефона: "+contact3.phoneNumber+"\nEmail: "+contact3.email);

    }
}




package Example2;

/**
 * Created by Вит on 03.04.2017.
 */
public class Passenger implements Comparable<Passenger>{
    private String name;
    private String documentNumber;

    public Passenger(String name, String documentNumber) {
        this.name = name;
        this.documentNumber = documentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                '}';
    }

    @Override
    public int compareTo(Passenger o) {
        return this.name.compareTo(o.getName());
    }
}

package beans;

import java.io.Serializable;
import java.util.Arrays;

public class CompatitorsList extends Human implements Serializable {
    private Person[] person = null;

    public Person[] getPerson() {
        return person;
    }

    public void setPerson(Person[] person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "{" +
                "Istirakclar=" + Arrays.toString(person) +
                '}';
    }
}

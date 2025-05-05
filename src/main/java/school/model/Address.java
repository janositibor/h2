package school.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String postalCode;
    private String city;
    private String street;
    private int houseNumber;

}

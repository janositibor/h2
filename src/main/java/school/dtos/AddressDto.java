package school.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddressDto {
    private String postalCode;
    private String city;
    private String street;
    private int houseNumber;
}

package school.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CreateAddressCommand {
    private String postalCode;
    private String city;
    private String street;
    private int houseNumber;
}

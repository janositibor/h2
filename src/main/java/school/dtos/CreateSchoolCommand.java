package school.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CreateSchoolCommand {
    @NotBlank(message = "Schoolname cannot be blank!")
    private String schoolName;
    private String postalCode;
    private String city;
    private String street;
    private int houseNumber;
}

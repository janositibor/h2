package school.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import school.model.SchoolAgeStatus;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class StudentDto {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private SchoolAgeStatus schoolAgeStatus;
}

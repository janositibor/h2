package school.dtos;

import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import school.model.Address;
import school.model.Student;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class SchoolDto {
    private Long id;
    private String schoolName;
    private AddressDto address;
    private List<StudentDto> students;
}

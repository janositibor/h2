package school.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name="schools")
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String schoolName;
    @Embedded
    private Address address;
}

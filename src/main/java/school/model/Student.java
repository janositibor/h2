package school.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name="students")
@NoArgsConstructor
@Getter
@Setter
public class Student {
    public static final int ageLimitForSchoolAgeStatus=16;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="name_of_student")
    private String name;
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private SchoolAgeStatus schoolAgeStatus;
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    public Student(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        adjustSchoolAgeStatus();
    }

    public void adjustSchoolAgeStatus() {
        if(ChronoUnit.YEARS.between(LocalDate.now(), dateOfBirth)>ageLimitForSchoolAgeStatus){
            schoolAgeStatus=SchoolAgeStatus.NOT_SCHOOL_AGED;
        }
        else{
            schoolAgeStatus=SchoolAgeStatus.SCHOOL_AGED;
        }
    }
}

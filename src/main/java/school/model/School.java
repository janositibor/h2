package school.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import school.exceptions.StudentNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="schools")
@NoArgsConstructor
@Getter
@Setter
public class School {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="school_id")
    private Long id;
    @Column(name="school_name")
    private String schoolName;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "school")
    private List<Student> students=new ArrayList<>();

    public School(String schoolName, Address address) {
        this.schoolName = schoolName;
        this.address = address;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(Student student){
        if(!students.contains(student)){
            throw new StudentNotFoundException(student.getId());
        }
        students.remove(student);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(id, school.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

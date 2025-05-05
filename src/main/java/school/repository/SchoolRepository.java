package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import school.dtos.SchoolDto;
import school.model.School;

import java.util.List;
import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Long> {
    @Query("SELECT DISTINCT s FROM School s LEFT JOIN FETCH s.students WHERE s.id=:id")
    Optional<School> findSchoolWithStudentsById(Long id);

    @Query("SELECT s FROM School s WHERE LOWER(s.address.city) LIKE LOWER(:city)")
    List<School> findSchoolsInCity(String city);
}

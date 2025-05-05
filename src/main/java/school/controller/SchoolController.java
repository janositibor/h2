package school.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import school.dtos.CreateSchoolCommand;
import school.dtos.CreateStudentCommand;
import school.dtos.SchoolDto;
import school.service.SchoolService;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {
    private SchoolService service;

    public SchoolController(SchoolService service) {
        this.service = service;
    }

    @GetMapping()
    public List<SchoolDto> findSchools(@RequestParam Optional<String> city){
        return service.findSchools(city);
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public SchoolDto addSchool(@Valid @RequestBody CreateSchoolCommand command){
        return service.addSchool(command);
    }

    @PostMapping("/{id}/students")
    @ResponseStatus(HttpStatus.CREATED)
    public SchoolDto addStudent(@PathVariable("id") Long schoolId, @Valid @RequestBody CreateStudentCommand command){
        return service.addStudent(schoolId, command);
    }

    @PutMapping("/{id}/students/{stdId}")
    public SchoolDto fireStudent(@PathVariable("id") Long schoolId,@PathVariable("stdId") Long studentId){
        return service.fireStudent(schoolId,studentId);
    }
}

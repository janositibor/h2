package school.service;

import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.dtos.AddressDto;
import school.dtos.CreateSchoolCommand;
import school.dtos.CreateStudentCommand;
import school.dtos.SchoolDto;
import school.exceptions.SchoolNotFoundException;
import school.exceptions.StudentNotFoundException;
import school.model.Address;
import school.model.School;
import school.model.Student;
import school.repository.SchoolRepository;
import school.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    private SchoolRepository schoolRepository;
    private StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;

    public SchoolService(SchoolRepository schoolRepository, StudentRepository studentRepository) {
        this.schoolRepository = schoolRepository;
        this.studentRepository = studentRepository;
    }

    private Student getStudentById(Long id){
        Optional<Student> optionalStudent= studentRepository.findById(id);
        if(optionalStudent.isEmpty()){
            throw new StudentNotFoundException(id);
        }

        return optionalStudent.get();
    }
    private School getSchoolById(Long id){
        Optional<School> optionalSchool= schoolRepository.findSchoolWithStudentsById(id);
        if(optionalSchool.isEmpty()){
            throw new SchoolNotFoundException(id);
        }

        return optionalSchool.get();
    }

    public SchoolDto addSchool(CreateSchoolCommand command) {
        Address address=new Address(command.getPostalCode(),command.getCity(),command.getStreet(),command.getHouseNumber());
        School school=new School(command.getSchoolName(),address);
        schoolRepository.save(school);
        SchoolDto schoolDto =modelMapper.map(school, SchoolDto.class);
        AddressDto addressDto=modelMapper.map(school.getAddress(), AddressDto.class);
        schoolDto.setAddress(addressDto);
        return schoolDto;
    }

    @Transactional
    public SchoolDto addStudent(Long schoolId, CreateStudentCommand command) {
        School school=getSchoolById(schoolId);
        Student student=modelMapper.map(command, Student.class);
        student.adjustSchoolAgeStatus();
        student.setSchool(school);
        studentRepository.save(student);
        school.addStudent(student);
        return modelMapper.map(school,SchoolDto.class);
    }

    public List<SchoolDto> findSchools(Optional<String> optionalCity) {
        if(optionalCity.isEmpty()){
            return schoolRepository.findAll().stream().map(s->modelMapper.map(s,SchoolDto.class)).toList();
        }
        else{
            return schoolRepository.findSchoolsInCity(optionalCity.get()).stream().map(s->modelMapper.map(s,SchoolDto.class)).toList();
        }
    }
    @Transactional
    public SchoolDto fireStudent(Long schoolId, Long studentId) {
        Student student=getStudentById(studentId);
        School school=getSchoolById(schoolId);
        school.removeStudent(student);
        student.setSchool(null);
        return modelMapper.map(school,SchoolDto.class);
    }
}

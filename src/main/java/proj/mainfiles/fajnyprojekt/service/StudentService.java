package proj.mainfiles.fajnyprojekt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import proj.mainfiles.fajnyprojekt.data.Student;
import proj.mainfiles.fajnyprojekt.data.StudentRepository;
import proj.mainfiles.fajnyprojekt.data.StudentUnit;

import java.util.UUID;

@Service
@RequiredArgsConstructor

public class StudentService {

    private final StudentRepository studentRepository;

    public Student saveStudent(Student student){
        var index = createIndex(student.unit());
        var newStudent = new Student(student.id(), student.name(), student.unit(), index);
        studentRepository.saveStudent(newStudent);
        return newStudent;
    }

    public Student getStudentById(UUID id) {
        return studentRepository.getStudentById(id);
    }

    private Long createIndex(StudentUnit unit){

        if(StudentUnit.GDANSK.equals(unit)){
            return 5 * studentRepository.getMaxIndex();
        } else {
            return 10 * studentRepository.getMaxIndex();
        }
    }
}

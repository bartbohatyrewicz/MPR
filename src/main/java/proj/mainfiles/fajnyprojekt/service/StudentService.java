package proj.mainfiles.fajnyprojekt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import proj.mainfiles.fajnyprojekt.data.Student;
import proj.mainfiles.fajnyprojekt.data.StudentRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor

public class StudentService {

    private final StudentRepository studentRepository;

    public void saveStudent(Student student){
        studentRepository.saveStudent(student);
    }

    public Student getStudentById(UUID id) {
        return studentRepository.getStudentById(id);
    }

}

package proj.mainfiles.fajnyprojekt;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proj.mainfiles.fajnyprojekt.data.Student;
import proj.mainfiles.fajnyprojekt.service.StudentService;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/students")

public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudents(@RequestBody Student student){
        studentService.saveStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(UUID id){
        return studentService.getStudentById(id);
    }
}

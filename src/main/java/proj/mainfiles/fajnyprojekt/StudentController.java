package proj.mainfiles.fajnyprojekt;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Student> getStudentById(@PathVariable UUID id){
        var student = studentService.getStudentById(id);
        if(student != null){
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

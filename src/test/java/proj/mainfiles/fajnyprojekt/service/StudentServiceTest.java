package proj.mainfiles.fajnyprojekt.service;

import lombok.extern.java.Log;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import proj.mainfiles.fajnyprojekt.data.Student;
import proj.mainfiles.fajnyprojekt.data.StudentRepository;
import proj.mainfiles.fajnyprojekt.data.StudentUnit;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Log
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        log.info("BiforIcz");
    }

    @BeforeAll
    static void setUpAll(){
        log.info("Bifor oll");
    }

    @AfterEach
    void cleanUp(){
        log.info("AfterIcz");
    }

    @AfterAll
    static void cleanUpAll(){
        log.info("AfterOll");
    }

    @Test
    void givenGdanskUnitWhenSaveStudentThenGetValidIndex(){
        //given
        var student = new Student(UUID.fromString("e24b4066-2a7d-48e9-a610-58aa5e0d7b67"), "Bartosz", StudentUnit.GDANSK, null);
        when(studentRepository.getMaxIndex()).thenReturn(5L);

        //when
        var savedStudent = studentService.saveStudent(student);

        //then
        assertEquals(student.id(), savedStudent.id());
        assertEquals(student.name(), savedStudent.name());
        assertEquals(student.unit(), savedStudent.unit());
        assertEquals(25, savedStudent.index());
        verify(studentRepository, times(1)).saveStudent(any());
    }
}

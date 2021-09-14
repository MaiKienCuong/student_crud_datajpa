package maikiencuong.datajpa.student;

import maikiencuong.datajpa.student.entity.Student;
import maikiencuong.datajpa.student.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class StudentDataJpaApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

//    @Test
    void insertStudent() {
        studentRepository.save(Student.builder()
                .firstName("Mai Kiên")
                .lastName("Cường")
                .dateOfBirth(LocalDate.now())
                .malop("DHKTPM14")
                .build());

        studentRepository.save(Student.builder()
                .firstName("Mai Kiên")
                .lastName("Huy")
                .dateOfBirth(LocalDate.now())
                .malop("DHKTPM14")
                .build());

        studentRepository.save(Student.builder()
                .firstName("Mai Kiên")
                .lastName("Dương")
                .dateOfBirth(LocalDate.now())
                .malop("DHKTPM14")
                .build());

        studentRepository.save(Student.builder()
                .firstName("Mai Kiên")
                .lastName("Hoàng")
                .dateOfBirth(LocalDate.now())
                .malop("DHKTPM14")
                .build());
    }

    @Test
    void findAll() {
        System.out.println("-------------find all");
        for (Student s : studentRepository.findAll()) {
            System.out.println("student = " + s);
            System.out.println("-------------");
        }
    }

    @Test
    void findAllByMalop() {
        System.out.println("-------------find all by malop");
        for (Student s : studentRepository.findAllByMalopContainingIgnoreCase("dhktpm14")) {
            System.out.println("student = " + s);
            System.out.println("-------------");
        }
    }

    @Test
    void findAllByLastName() {
        System.out.println("-------------find all by lastName");
        for (Student s : studentRepository.findAllByLastNameContainingIgnoreCase("cường")) {
            System.out.println("student = " + s);
            System.out.println("-------------");
        }
    }

    @Test
    void update() {
        List<Student> dhktpm14 = studentRepository.findAllByMalopContainingIgnoreCase("dhktpm14");
        for (Student s : dhktpm14) {
            studentRepository.updateNewMalop(s.getId(), "DHKTPM15");
        }
    }

    @Test
    void delete() {
        List<Student> dhktpm14 = studentRepository.findAllByMalopContainingIgnoreCase("dhktpm15");
        for (Student s : dhktpm14) {
            studentRepository.deleteByIdd(s.getId());
        }
    }

}

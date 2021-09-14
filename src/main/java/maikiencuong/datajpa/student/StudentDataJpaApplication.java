package maikiencuong.datajpa.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "maikiencuong.datajpa.student.entity")
public class StudentDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentDataJpaApplication.class, args);
    }

}

package maikiencuong.datajpa.student.repository;

import maikiencuong.datajpa.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "select s from Student s where s.lastName like %:lastName%")
    List<Student> findAllByLastNameContainingIgnoreCase(String lastName);

    @Query(value = "select s from Student s where s.malop like %:malop%")
    List<Student> findAllByMalopContainingIgnoreCase(String malop);

    @Query(value = "from Student")
    List<Student> findAll();

    @Transactional
    @Modifying
    @Query(value = "update Student s set s.malop=:malop where s.id=:id")
    void updateNewMalop(Long id, String malop);

    @Transactional
    @Modifying
    @Query(value = "delete from Student where id=:id")
    void deleteByIdd(Long id);

}

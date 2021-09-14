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

    @Query(value = "select * from students where last_name like %:lastName%", nativeQuery = true)
    List<Student> findAllByLastNameContainingIgnoreCase(String lastName);

    @Query(value = "select * from students where malop like %:malop%", nativeQuery = true)
    List<Student> findAllByMalopContainingIgnoreCase(String malop);

    @Query(value = "select * from students", nativeQuery = true)
    List<Student> findAll();

    @Transactional
    @Modifying
    @Query(value = "update students set malop=:malop where id=:id", nativeQuery = true)
    void updateNewMalop(Long id, String malop);

    @Transactional
    @Modifying
    @Query(value = "delete students where id=:id", nativeQuery = true)
    void deleteByIdd(Long id);

}

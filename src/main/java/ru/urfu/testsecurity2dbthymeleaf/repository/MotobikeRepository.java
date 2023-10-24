package ru.urfu.testsecurity2dbthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.urfu.testsecurity2dbthymeleaf.entity.Motobike;

@Repository
public interface MotobikeRepository extends JpaRepository<Motobike, Long> {
}

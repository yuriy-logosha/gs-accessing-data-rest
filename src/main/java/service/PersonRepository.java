package service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import service.domain.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Page<Person> findAll(Pageable pageable);

    @Override
    @PostAuthorize("returnObject.username == principal.username or hasRole('ROLE_ADMIN')")
    Person findOne(Long aLong);

    Person findBySsn(@Param("ssn")String ssn);

}

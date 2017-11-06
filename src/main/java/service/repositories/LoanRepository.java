package service.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import service.domain.Loan;

import java.util.List;

@CrossOrigin
@RepositoryRestResource
public interface LoanRepository extends CrudRepository<Loan, Long> {

    List<Loan> findBySsn(@Param("ssn") String ssn);

    List<Loan> findByIp(@Param("ip") String ip);

    Loan findById(@Param("id") long id);



    @Override
    @RestResource(exported = false)
    public void delete(Loan t);

    @Override
    @RestResource(exported = false)
    public void delete(Long id);

}

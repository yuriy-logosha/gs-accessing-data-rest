package service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "loan", path = "loan")
public interface LoanRepository extends CrudRepository<Loan, Long> {

	List<Loan> findByPerson(@Param("person") Person person);

}

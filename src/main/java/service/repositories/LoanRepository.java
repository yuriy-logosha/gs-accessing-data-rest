package service.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import service.domain.Loan;
import service.domain.LoanExcerpt;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(excerptProjection = LoanExcerpt.class)
public interface LoanRepository extends CrudRepository<Loan, Long> {

    @RestResource(exported = false)
    List<Loan> findByIp(@Param("ip") String ip);

    @Override
    @PostAuthorize("returnObject!=null?returnObject.ssn == principal.username:true")
    Loan findOne(@Param("id") Long id);

    @Override
    @PostFilter("filterObject.ssn == principal.username")
    List<Loan> findAll();

    @Override
    @PostAuthorize("returnObject!=null?returnObject.ssn == principal.username:true")
    Loan save(Loan loan);

    @Override
    @RestResource(exported = false)
    public void delete(Loan t);

    @Override
    @RestResource(exported = false)
    public void delete(Long id);

    @Override
    @RestResource(exported = false)
    public void deleteAll();

}

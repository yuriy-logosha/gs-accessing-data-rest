package service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import service.domain.Extension;
import service.domain.Loan;

@RepositoryRestResource
public interface ExtensionRepository extends CrudRepository<Extension, Long> {

    @Override
    @RestResource(exported = false)
    public void delete(Extension t);

    @Override
    @RestResource(exported = false)
    public void delete(Long id);

    @Override
    @RestResource(exported = false)
    public void deleteAll();

}

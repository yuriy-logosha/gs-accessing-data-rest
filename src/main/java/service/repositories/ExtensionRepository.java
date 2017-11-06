package service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import service.domain.Extension;

@RepositoryRestResource
public interface ExtensionRepository extends CrudRepository<Extension, Long> {

}

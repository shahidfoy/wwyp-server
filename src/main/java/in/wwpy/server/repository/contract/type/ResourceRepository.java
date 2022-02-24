package in.wwpy.server.repository.contract.type;

import in.wwpy.server.model.contract.type.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "resource-resource")
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}

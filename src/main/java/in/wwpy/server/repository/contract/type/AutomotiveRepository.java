package in.wwpy.server.repository.contract.type;

import in.wwpy.server.model.contract.type.Automotive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "automotive-resource")
public interface AutomotiveRepository extends JpaRepository<Automotive, Long> {
}

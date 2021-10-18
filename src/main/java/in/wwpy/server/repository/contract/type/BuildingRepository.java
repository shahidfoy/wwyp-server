package in.wwpy.server.repository.contract.type;

import in.wwpy.server.model.contract.type.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "building-resource")
public interface BuildingRepository extends JpaRepository<Building, Long> {
}

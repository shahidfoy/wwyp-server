package in.wwpy.server.repository.contract.type;

import in.wwpy.server.model.contract.type.Realm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "realm-resource")
public interface RealmRepository extends JpaRepository<Realm, Long> {
}

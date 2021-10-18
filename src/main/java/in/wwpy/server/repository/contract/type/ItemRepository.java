package in.wwpy.server.repository.contract.type;

import in.wwpy.server.model.contract.type.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "item-resource")
public interface ItemRepository extends JpaRepository<Item, Long> {
}

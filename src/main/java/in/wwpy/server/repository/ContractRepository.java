package in.wwpy.server.repository;

import in.wwpy.server.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "contract-resource")
public interface ContractRepository extends JpaRepository<Contract, Long> {
    List<Contract> findAllByOrderByLastUpdatedDateDesc();
    List<Contract> findContractByStatus(String status);
    List<Contract> findContractByType(String type);
    List<Contract> findContractByContracteeId(Long contracteeId);
    List<Contract> findContractByContracteeIdOrderByLastUpdatedDateDesc(Long contracteeId);
    List<Contract> findContractByContractorId(Long contractorId);
}

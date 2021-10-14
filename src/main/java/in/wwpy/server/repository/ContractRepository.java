package in.wwpy.server.repository;

import in.wwpy.server.model.Contract;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "contract-resource")
public interface ContractRepository extends JpaRepository<Contract, Long> {
    Long countContractByContracteeId(Long contracteeId);
    Long countContractByContractorId(Long contractorId);
    Long countContractByType(String type);

    List<Contract> findAllByOrderByLastUpdatedDateDesc();
    List<Contract> findContractByStatus(String status);

    List<Contract> findContractByType(String type, Pageable pageable);
    List<Contract> findContractByTypeOrderByLastUpdatedDateDesc(String type, Pageable pageable);

    List<Contract> findContractByContracteeId(Long contracteeId, Pageable pageable);
    List<Contract> findContractByContracteeIdOrderByLastUpdatedDateDesc(Long contracteeId, Pageable pageable);

    List<Contract> findContractByContractorId(Long contractorId, Pageable pageable);
    List<Contract> findContractByContractorIdOrderByLastUpdatedDateDesc(Long contractorId, Pageable pageable);
}

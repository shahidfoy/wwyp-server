package in.wwpy.server.repository;

import in.wwpy.server.model.Contract;
import in.wwpy.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path = "contract-resource")
public interface ContractRepository extends JpaRepository<Contract, Long> {
    List<Contract> findContractByStatus(String status);
    List<Contract> findContractByType(String type);
    List<Contract> findContractByContracteeId(Long contracteeId);
    List<Contract> findContractByContractorId(Long contractorId);
}

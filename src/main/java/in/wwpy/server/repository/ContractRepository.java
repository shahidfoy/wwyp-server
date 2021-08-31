package in.wwpy.server.repository;

import in.wwpy.server.model.Contract;
import in.wwpy.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    List<Contract> findContractByStatus(String status);
    List<Contract> findContractByType(String type);
    List<Contract> findContractByContractee(User contractee);
    List<Contract> findContractByContractor(User contractor);
}

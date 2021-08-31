package in.wwpy.server.service.impl;

import in.wwpy.server.exception.type.ContractNotFoundException;
import in.wwpy.server.model.Contract;
import in.wwpy.server.model.Offer;
import in.wwpy.server.model.User;
import in.wwpy.server.repository.ContractRepository;
import in.wwpy.server.service.ContractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static in.wwpy.server.constant.ContractConstant.THIS_CONTRACT_DOES_NOT_EXIST;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final ContractRepository contractRepository;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Contract addNewContract(User contractee, String status, String type, String subject, String body, String[] contractImageUrls, String legalAgreement) {
        Contract contract = new Contract();
        contract.setContractee(contractee);
        contract.setStatus(status);
        contract.setType(type);
        contract.setSubject(subject);
        contract.setBody(body);
        contract.setContractImageUrls(contractImageUrls);
        contract.setLegalAgreement(legalAgreement);
        contractRepository.save(contract);
        return contract;
    }

    @Override
    public Contract assignContractor(Long contractId, User contractor, Offer acceptedOffer) throws ContractNotFoundException {
        Contract contract = findContractById(contractId);
        contract.setContractor(contractor);
        contract.setAcceptedOffer(acceptedOffer);
        contractRepository.save(contract);
        return contract;
    }

    @Override
    public void deleteContract(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Contract editContract(Long id, User contractee, String status, String type, String subject, String body, String[] contractImageUrls, String legalAgreement) throws ContractNotFoundException {
        Contract updatedContract = findContractById(id);
        updatedContract.setContractee(contractee);
        updatedContract.setStatus(status);
        updatedContract.setType(type);
        updatedContract.setSubject(subject);
        updatedContract.setBody(body);
        updatedContract.setContractImageUrls(contractImageUrls);
        updatedContract.setLegalAgreement(legalAgreement);
        contractRepository.save(updatedContract);
        return updatedContract;
    }

    @Override
    public Contract findContractById(Long id) throws ContractNotFoundException {
        Optional<Contract> optionalContract = this.contractRepository.findById(id);
        if (!optionalContract.isPresent()) {
            LOGGER.error(THIS_CONTRACT_DOES_NOT_EXIST);
            throw new ContractNotFoundException(THIS_CONTRACT_DOES_NOT_EXIST);
        }
        return optionalContract.get();
    }

    @Override
    public List<Contract> findContractByStatus(String status) {
        return contractRepository.findContractByStatus(status);
    }

    @Override
    public List<Contract> findContractByType(String type) {
        return contractRepository.findContractByType(type);
    }

    @Override
    public List<Contract> findContractByContractee(User contractee) {
        return contractRepository.findContractByContractee(contractee);
    }

    @Override
    public List<Contract> findContractByContractor(User contractor) {
        return contractRepository.findContractByContractor(contractor);
    }

    @Override
    public List<Contract> getContracts() {
        return contractRepository.findAll();
    }
}

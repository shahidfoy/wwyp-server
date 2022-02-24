package in.wwpy.server.service.impl;

import in.wwpy.server.exception.type.ContractNotFoundException;
import in.wwpy.server.model.Contract;
import in.wwpy.server.model.Offer;
import in.wwpy.server.repository.ContractRepository;
import in.wwpy.server.service.ContractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static in.wwpy.server.constant.ContractConstant.THIS_CONTRACT_DOES_NOT_EXIST;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final int DEFAULT_PAGE_SIZE = 20;

    @Autowired
    private ContractRepository contractRepository;


    @Override
    public Contract addNewContract(Long contracteeId, String status, String type, String subject, String body, boolean seekingLowestOffer, String[] contractImageUrls, String legalAgreement) {
        Contract contract = new Contract();
        contract.setContracteeId(contracteeId);
        contract.setStatus(status);
        contract.setType(type);
        contract.setSubject(subject);
        contract.setBody(body);
        contract.setSeekingLowestOffer(seekingLowestOffer);
        contract.setContractImageUrls(contractImageUrls);
        contract.setLegalAgreement(legalAgreement);
        contractRepository.save(contract);
        return contract;
    }

    @Override
    public Contract assignContractor(Long contractId, Long contractorId, Offer acceptedOffer) throws ContractNotFoundException {
        Contract contract = findContractById(contractId);
        contract.setContractorId(contractorId);
        contract.setAcceptedOffer(acceptedOffer);
        contractRepository.save(contract);
        return contract;
    }

    @Override
    public Long countContractByContracteeId(Long contracteeId) {
        return contractRepository.countContractByContracteeId(contracteeId);
    }

    @Override
    public Long countContractByContractorId(Long contractorId) {
        return contractRepository.countContractByContractorId(contractorId);
    }

    @Override
    public Long countContractByType(String type) {
        return contractRepository.countContractByType(type);
    }

    @Override
    public void deleteContract(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Contract editContract(Long id, Long contracteeId, String status, String type, String subject, String body, boolean seekingLowestOffer, String[] contractImageUrls, String legalAgreement) throws ContractNotFoundException {
        Contract updatedContract = findContractById(id);
        updatedContract.setContracteeId(contracteeId);
        updatedContract.setStatus(status);
        updatedContract.setType(type);
        updatedContract.setSubject(subject);
        updatedContract.setBody(body);
        updatedContract.setSeekingLowestOffer(seekingLowestOffer);
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
    public List<Contract> findContractByType(String type, int page) {
        Pageable pageable = PageRequest.of(page, DEFAULT_PAGE_SIZE);
        return contractRepository.findContractByTypeOrderByLastUpdatedDateDesc(type, pageable);
    }

    @Override
    public List<Contract> findContractByContracteeId(Long contracteeId, int page) {
        Pageable pageable = PageRequest.of(page, DEFAULT_PAGE_SIZE);
        return contractRepository.findContractByContracteeIdOrderByLastUpdatedDateDesc(contracteeId, pageable);
    }

    @Override
    public List<Contract> findContractByContractorId(Long contractorId, int page) {
        Pageable pageable = PageRequest.of(page, DEFAULT_PAGE_SIZE);
        return contractRepository.findContractByContractorIdOrderByLastUpdatedDateDesc(contractorId, pageable);
    }

    @Override
    public List<Contract> getContracts() {
        return contractRepository.findAllByOrderByLastUpdatedDateDesc();
    }
}

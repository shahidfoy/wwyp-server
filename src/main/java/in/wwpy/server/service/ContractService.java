package in.wwpy.server.service;

import in.wwpy.server.exception.type.ContractNotFoundException;
import in.wwpy.server.model.Contract;
import in.wwpy.server.model.Offer;

import java.util.List;

public interface ContractService {

    Contract addNewContract(Long contracteeId, String status, String type, String subject, String body, boolean seekingLowestOffer, String[] contractImageUrls, String legalAgreement);

    Contract assignContractor(Long contractId, Long contractorId, Offer acceptedOffer) throws ContractNotFoundException;

    Long countContractByContracteeId(Long contracteeId);

    void deleteContract(Long id);

    Contract editContract(Long id, Long contracteeId, String status, String type, String subject, String body, boolean seekingLowestOffer, String[] contractImageUrls, String legalAgreement) throws ContractNotFoundException;

    Contract findContractById(Long id) throws ContractNotFoundException;

    List<Contract> findContractByStatus(String status);

    List<Contract> findContractByType(String type);

    List<Contract> findContractByContracteeId(Long contracteeId, int page);

    List<Contract> findContractByContractorId(Long contractorId);

    List<Contract> getContracts();
}

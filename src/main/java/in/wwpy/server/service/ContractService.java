package in.wwpy.server.service;

import in.wwpy.server.exception.type.ContractNotFoundException;
import in.wwpy.server.model.Contract;
import in.wwpy.server.model.Offer;
import in.wwpy.server.model.User;

import java.util.List;

public interface ContractService {

    Contract addNewContract(Long contracteeId, String status, String type, String subject, String body, String[] contractImageUrls, String legalAgreement);

    Contract assignContractor(Long contractId, Long contractorId, Offer acceptedOffer) throws ContractNotFoundException;

    void deleteContract(Long id);

    Contract editContract(Long id, Long contracteeId, String status, String type, String subject, String body, String[] contractImageUrls, String legalAgreement) throws ContractNotFoundException;

    Contract findContractById(Long id) throws ContractNotFoundException;

    List<Contract> findContractByStatus(String status);

    List<Contract> findContractByType(String type);

    List<Contract> findContractByContracteeId(Long contracteeId);

    List<Contract> findContractByContractorId(Long contractorId);

    List<Contract> getContracts();
}

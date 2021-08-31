package in.wwpy.server.service;

import in.wwpy.server.exception.type.ContractNotFoundException;
import in.wwpy.server.model.Contract;
import in.wwpy.server.model.Offer;
import in.wwpy.server.model.User;

import java.util.List;

public interface ContractService {

    Contract addNewContract(User contractee, String status, String type, String subject, String body, String[] contractImageUrls, String legalAgreement);

    Contract assignContractor(Long contractId, User contractor, Offer acceptedOffer) throws ContractNotFoundException;

    void deleteContract(Long id);

    Contract editContract(Long id, User contractee, String status, String type, String subject, String body, String[] contractImageUrls, String legalAgreement) throws ContractNotFoundException;

    Contract findContractById(Long id) throws ContractNotFoundException;

    List<Contract> findContractByStatus(String status);

    List<Contract> findContractByType(String type);

    List<Contract> findContractByContractee(User contractee);

    List<Contract> findContractByContractor(User contractor);

    List<Contract> getContracts();
}

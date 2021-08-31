package in.wwpy.server.controller;

import in.wwpy.server.exception.type.ContractNotFoundException;
import in.wwpy.server.model.Contract;
import in.wwpy.server.model.HttpResponse;
import in.wwpy.server.model.Offer;
import in.wwpy.server.model.User;
import in.wwpy.server.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static in.wwpy.server.constant.ContractConstant.CONTRACT_DELETED_SUCCESSFULLY;
import static in.wwpy.server.constant.OfferConstant.OFFER_DELETED_SUCCESSFULLY;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = {"/contract"})
public class ContractController {

    private ContractService contractService;

    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping("/add")
    public ResponseEntity<Contract> addNewContract(@RequestBody Contract contract) {
        Contract newContract = this.contractService.addNewContract(
                contract.getContractee(),
                contract.getStatus(),
                contract.getType(),
                contract.getSubject(),
                contract.getBody(),
                contract.getContractImageUrls(),
                contract.getLegalAgreement()
        );
        return new ResponseEntity<>(newContract, OK);
    }

    @PostMapping("/assign/{id}")
    public ResponseEntity<Contract> assignContractor(@PathVariable("id") Long id,
                                                     @RequestParam("contractor") User contractor,
                                                     @RequestParam("offer") Offer offer) throws ContractNotFoundException {
        Contract assignedContract = this.contractService.assignContractor(id, contractor, offer);
        return new ResponseEntity<>(assignedContract, OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpResponse> deleteContract(@PathVariable("id") Long id) {
        contractService.deleteContract(id);
        return response(NO_CONTENT, CONTRACT_DELETED_SUCCESSFULLY);
    }

    @PostMapping("/edit")
    public ResponseEntity<Contract> editContract(@RequestBody Contract contract) throws ContractNotFoundException {
        Contract updatedContract = this.contractService.editContract(
                contract.getId(),
                contract.getContractee(),
                contract.getStatus(),
                contract.getType(),
                contract.getSubject(),
                contract.getBody(),
                contract.getContractImageUrls(),
                contract.getLegalAgreement()
        );
        return new ResponseEntity<>(updatedContract, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> findContractById(@PathVariable("id") Long id) throws ContractNotFoundException {
        Contract contract = this.contractService.findContractById(id);
        return new ResponseEntity<>(contract, OK);
    }

    @GetMapping("/find/status/{status}")
    public ResponseEntity<List<Contract>> findContractByStatus(@PathVariable("status") String status) {
        List<Contract> contracts = this.contractService.findContractByStatus(status);
        return new ResponseEntity<>(contracts, OK);
    }

    @GetMapping("/find/type/{type}")
    public ResponseEntity<List<Contract>> findContractByType(@PathVariable("type") String type) {
        List<Contract> contracts = this.contractService.findContractByType(type);
        return new ResponseEntity<>(contracts, OK);
    }

    @PostMapping("/find/contractee")
    public ResponseEntity<List<Contract>> findContractByContractee(@RequestBody User contractee) {
        List<Contract> contracts = this.contractService.findContractByContractee(contractee);
        return new ResponseEntity<>(contracts, OK);
    }

    @PostMapping("/find/contractor")
    public ResponseEntity<List<Contract>> findContractByContractor(@RequestBody User contractor) {
        List<Contract> contracts = this.contractService.findContractByContractor(contractor);
        return new ResponseEntity<>(contracts, OK);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Contract>> getContracts() {
        List<Contract> contracts = this.contractService.getContracts();
        return new ResponseEntity<>(contracts, OK);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        HttpResponse body = new HttpResponse(
                httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message.toUpperCase());
        return new ResponseEntity<>(body, httpStatus);
    }
}

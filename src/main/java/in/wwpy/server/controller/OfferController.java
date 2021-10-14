package in.wwpy.server.controller;

import in.wwpy.server.exception.type.OfferNotFoundException;
import in.wwpy.server.model.HttpResponse;
import in.wwpy.server.model.Offer;
import in.wwpy.server.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static in.wwpy.server.constant.OfferConstant.OFFER_DELETED_SUCCESSFULLY;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = {"/offer"})
public class OfferController {

    private OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping("/add")
    public ResponseEntity<Offer> addNewOffer(@RequestBody Offer offer) {
        Offer newOffer = this.offerService.addNewOffer(
                offer.getContract(),
                offer.getUserId(),
                offer.getComment(),
                offer.getAmount(),
                offer.getAmountType());
        return new ResponseEntity<>(newOffer, OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpResponse> deleteOffer(@PathVariable("id") Long id) {
        offerService.deleteOffer(id);
        return response(NO_CONTENT, OFFER_DELETED_SUCCESSFULLY);
    }

    @PostMapping("/edit")
    public ResponseEntity<Offer> editOffer(@RequestBody Offer offer) throws OfferNotFoundException {
        Offer updatedOffer = this.offerService.editOffer(
                offer.getId(),
                offer.getUserId(),
                offer.getComment(),
                offer.getAmount(),
                offer.getAmountType()
        );
        return new ResponseEntity<>(updatedOffer, OK);
    }

    @PostMapping("/approve/{id}/{approved}")
    public ResponseEntity<Offer> approveOffer(
            @PathVariable("id") Long id,
            @PathVariable("approved") boolean approved
    ) throws OfferNotFoundException {
        Offer offer = this.offerService.approveOffer(id, approved);
        return new ResponseEntity<>(offer, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offer> findOfferById(
            @PathVariable("id") Long id
    ) throws OfferNotFoundException {
        Offer offer = this.offerService.findOfferById(id);
        return new ResponseEntity<>(offer, OK);
    }

    @GetMapping("/find/contract/{id}")
    public ResponseEntity<List<Offer>> findOfferByContractId(
            @PathVariable("id") Long id
    ) {
        List<Offer> offers = this.offerService.findOfferByContractId(id);
        return new ResponseEntity<>(offers, OK);
    }

    @GetMapping("/find/contract/{id}/lowest")
    public ResponseEntity<List<Offer>> findOfferByContractIdOrderByAmountAsc(
            @PathVariable("id") Long id
    ) {
        List<Offer> offers = this.offerService.findOfferByContractIdOrderByAmountAsc(id);
        return new ResponseEntity<>(offers, OK);
    }

    @GetMapping("/find/contract/{contractId}/user/{userId}")
    public ResponseEntity<Offer> findOfferByContractIdAndByUserId(
            @PathVariable("contractId") Long contractId,
            @PathVariable("userId") Long userId
    ) {
        Offer offer = this.offerService.findOfferByContractIdAndUserId(contractId, userId);
        return new ResponseEntity<>(offer, OK);
    }

    @GetMapping("/find/user/{id}")
    public ResponseEntity<List<Offer>> findOfferByUserId(
            @PathVariable("id") Long id
    ) {
        List<Offer> offers = this.offerService.findOfferByUserId(id);
        return new ResponseEntity<>(offers, OK);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Offer>> getOffers() {
        List<Offer> offers = this.offerService.getOffers();
        return new ResponseEntity<>(offers, OK);
    }

    @GetMapping("/contract/highest-offer/{contractId}")
    public ResponseEntity<Offer> highestOfferByContractId(
            @PathVariable("contractId") Long contractId
    ) {
        Offer highestOffer = this.offerService.highestOfferByContractId(contractId);
        return new ResponseEntity<>(highestOffer, OK);
    }

    @GetMapping("/contract/lowest-offer/{contractId}")
    public ResponseEntity<Offer> lowestOfferByContractId(
            @PathVariable("contractId") Long contractId
    ) {
        Offer lowestOffer = this.offerService.lowestOfferByContractId(contractId);
        return new ResponseEntity<>(lowestOffer, OK);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        HttpResponse body = new HttpResponse(
                httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message.toUpperCase());
        return new ResponseEntity<>(body, httpStatus);
    }
}

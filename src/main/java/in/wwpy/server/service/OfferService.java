package in.wwpy.server.service;

import in.wwpy.server.exception.type.OfferNotFoundException;
import in.wwpy.server.model.Contract;
import in.wwpy.server.model.Offer;

import java.math.BigDecimal;
import java.util.List;

public interface OfferService {

    Offer addNewOffer(Contract contract, Long userId, String comment, BigDecimal amount, String amountType);

    Long countOfferByContractId(Long contractId);

    Long countOfferByUserId(Long userId);

    void deleteOffer(Long id);

    Offer editOffer(Long id, Long userId, String comment, BigDecimal amount, String amountType) throws OfferNotFoundException;

    Offer approveOffer(Long id, boolean approved) throws OfferNotFoundException;

    Offer findOfferById(Long id) throws OfferNotFoundException;

    List<Offer> findOfferByContractId(Long contractId, int page);

    List<Offer> findOfferByContractIdOrderByAmountAsc(Long contractId, int page);

    Offer findOfferByContractIdAndUserId(Long contractId, Long userId);

    List<Offer> findOfferByUserId(Long userId, int page);

    List<Offer> getOffers();

    Offer highestOfferByContractId(Long contractId);

    Offer lowestOfferByContractId(Long contractId);
}

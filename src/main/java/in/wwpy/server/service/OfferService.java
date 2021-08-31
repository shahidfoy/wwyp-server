package in.wwpy.server.service;

import in.wwpy.server.exception.type.OfferNotFoundException;
import in.wwpy.server.model.Offer;

import java.math.BigDecimal;
import java.util.List;

public interface OfferService {

    Offer addNewOffer(Long contractId, Long userId, String username, String comment, BigDecimal amount, String amountType);

    void deleteOffer(Long id);

    Offer editOffer(Long id, String username, String comment, BigDecimal amount, String amountType) throws OfferNotFoundException;

    Offer approveOffer(Long id, boolean approved) throws OfferNotFoundException;

    Offer findOfferById(Long id) throws OfferNotFoundException;

    List<Offer> findOfferByContractId(Long contractId);

    List<Offer> findOfferByUserId(Long userId);

    List<Offer> findOfferByUsername(String username);

    List<Offer> getOffers();
}

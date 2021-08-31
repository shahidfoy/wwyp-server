package in.wwpy.server.service.impl;

import in.wwpy.server.exception.type.OfferNotFoundException;
import in.wwpy.server.model.Offer;
import in.wwpy.server.repository.OfferRepository;
import in.wwpy.server.service.OfferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static in.wwpy.server.constant.OfferConstant.THIS_OFFER_DOES_NOT_EXIST;

@Service
@Transactional
public class OfferServiceImpl implements OfferService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final OfferRepository offerRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public Offer addNewOffer(Long contractId, Long userId, String username, String comment, BigDecimal amount, String amountType) {
        Offer offer = new Offer();
        offer.setContractId(contractId);
        offer.setUserId(userId);
        offer.setUsername(username);
        offer.setComment(comment);
        offer.setAmount(amount);
        offer.setAmountType(amountType);
        offer.setApproved(false);
        offerRepository.save(offer);
        return offer;
    }

    @Override
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }

    @Override
    public Offer editOffer(Long id, String username, String comment, BigDecimal amount, String amountType) throws OfferNotFoundException {
        Offer updatedOffer = findOfferById(id);
        updatedOffer.setUsername(username);
        updatedOffer.setComment(comment);
        updatedOffer.setAmount(amount);
        updatedOffer.setAmountType(amountType);
        offerRepository.save(updatedOffer);
        return updatedOffer;
    }

    @Override
    public Offer approveOffer(Long id, boolean approved) throws OfferNotFoundException {
        Offer approvedOffer = findOfferById(id);
        approvedOffer.setApproved(approved);
        offerRepository.save(approvedOffer);
        return approvedOffer;
    }

    @Override
    public Offer findOfferById(Long id) throws OfferNotFoundException {
        Optional<Offer> optionalOffer = this.offerRepository.findById(id);
        if (!optionalOffer.isPresent()) {
            LOGGER.error(THIS_OFFER_DOES_NOT_EXIST);
            throw new OfferNotFoundException(THIS_OFFER_DOES_NOT_EXIST);
        }
        return optionalOffer.get();
    }

    @Override
    public List<Offer> findOfferByContractId(Long contractId) {
        return offerRepository.findOfferByContractId(contractId);
    }

    @Override
    public List<Offer> findOfferByUserId(Long userId) {
        return offerRepository.findOfferByUserId(userId);
    }

    @Override
    public List<Offer> findOfferByUsername(String username) {
        return offerRepository.findOfferByUsername(username);
    }

    @Override
    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }
}

package in.wwpy.server.service.impl;

import in.wwpy.server.exception.type.OfferNotFoundException;
import in.wwpy.server.model.Contract;
import in.wwpy.server.model.Offer;
import in.wwpy.server.repository.OfferRepository;
import in.wwpy.server.service.NotificationService;
import in.wwpy.server.service.OfferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private final int DEFAULT_PAGE_SIZE = 20;

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private NotificationService notificationService;


    @Override
    public Offer addNewOffer(Contract contract, Long userId, String comment, BigDecimal amount, String amountType) {
        Offer offer = new Offer();
        offer.setContract(contract);
        offer.setUserId(userId);
        offer.setComment(comment);
        offer.setAmount(amount);
        offer.setAmountType(amountType);
        offer.setApproved(false);
        offerRepository.save(offer);
        return offer;
    }

    @Override
    public Long countOfferByContractId(Long contractId) {
        return offerRepository.countOfferByContractId(contractId);
    }

    @Override
    public Long countOfferByUserId(Long userId) {
        return offerRepository.countOfferByUserId(userId);
    }


    @Override
    public void deleteOffer(Long id) {
        notificationService.deleteNotificationByOfferId(id);
        offerRepository.deleteById(id);
    }

    @Override
    public void deleteOfferByContractId(Long contractId) {
        offerRepository.deleteOfferByContractId(contractId);
    }

    @Override
    public Offer editOffer(Long id, Long userId, String comment, BigDecimal amount, String amountType) throws OfferNotFoundException {
        Offer updatedOffer = findOfferById(id);
        updatedOffer.setUserId(userId);
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
    public List<Offer> findOfferByContractId(Long contractId, int page) {
        Pageable pageable = PageRequest.of(page, DEFAULT_PAGE_SIZE);
        return offerRepository.findOfferByContractIdOrderByAmountDesc(contractId, pageable);
    }

    @Override
    public List<Offer> findOfferByContractIdOrderByAmountAsc(Long contractId, int page) {
        Pageable pageable = PageRequest.of(page, DEFAULT_PAGE_SIZE);
        return offerRepository.findOfferByContractIdOrderByAmountAsc(contractId, pageable);
    }

    @Override
    public Offer findOfferByContractIdAndUserId(Long contractId, Long userId) {
        return offerRepository.findOfferByContractIdAndUserId(contractId, userId);
    }

    @Override
    public List<Offer> findOfferByUserId(Long userId, int page) {
        Pageable pageable = PageRequest.of(page, DEFAULT_PAGE_SIZE);
        return offerRepository.findOfferByUserIdOrderByLastUpdatedDateDesc(userId, pageable);
    }

    @Override
    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }

    @Override
    public Offer highestOfferByContractId(Long contractId) {
        try {
            Pageable pageable = PageRequest.of(0, DEFAULT_PAGE_SIZE);
            return offerRepository.findOfferByContractIdOrderByAmountDesc(contractId, pageable).get(0);
        } catch (Exception ex){
            Offer zeroOffer = new Offer();
            zeroOffer.setAmountType("USD");
            zeroOffer.setAmount(BigDecimal.ZERO);
            return zeroOffer;
        }
    }

    @Override
    public Offer lowestOfferByContractId(Long contractId) {
        try {
            Pageable pageable = PageRequest.of(0, DEFAULT_PAGE_SIZE);
            return offerRepository.findOfferByContractIdOrderByAmountAsc(contractId, pageable).get(0);
        } catch (Exception ex){
            Offer zeroOffer = new Offer();
            zeroOffer.setAmountType("USD");
            zeroOffer.setAmount(BigDecimal.ZERO);
            return zeroOffer;
        }
    }
}

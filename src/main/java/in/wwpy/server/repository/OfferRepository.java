package in.wwpy.server.repository;

import in.wwpy.server.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "offer-resource")
public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findOfferByContractId(Long contractId);
    Offer findOfferByContractIdAndUserId(Long contractId, Long userId);
    List<Offer> findOfferByContractIdOrderByAmountAsc(Long contractId);
    List<Offer> findOfferByContractIdOrderByAmountDesc(Long contractId);
    List<Offer> findOfferByUserId(Long userId);
    List<Offer> findOfferByUserIdOrderByCreatedDateDesc(Long userId);
}

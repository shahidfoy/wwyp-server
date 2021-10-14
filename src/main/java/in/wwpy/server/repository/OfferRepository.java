package in.wwpy.server.repository;

import in.wwpy.server.model.Offer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "offer-resource")
public interface OfferRepository extends JpaRepository<Offer, Long> {
    Long countOfferByContractId(Long contractId);
    Long countOfferByUserId(Long userId);

    Offer findOfferByContractIdAndUserId(Long contractId, Long userId);

    List<Offer> findOfferByContractId(Long contractId, Pageable pageable);
    List<Offer> findOfferByContractIdOrderByAmountAsc(Long contractId, Pageable pageable);
    List<Offer> findOfferByContractIdOrderByAmountDesc(Long contractId, Pageable pageable);

    List<Offer> findOfferByUserId(Long userId, Pageable pageable);
    List<Offer> findOfferByUserIdOrderByLastUpdatedDateDesc(Long userId, Pageable pageable);
}

package in.wwpy.server.repository;

import in.wwpy.server.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findOfferByContractId(Long contractId);
    List<Offer> findOfferByUserId(Long userId);
    List<Offer> findOfferByUsername(String username);
}

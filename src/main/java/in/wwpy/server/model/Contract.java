package in.wwpy.server.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @OneToOne
    private User contractee;
    @OneToOne
    private User contractor;
    private String status;
    private String type;
    @Column(nullable = false)
    private String subject;
    @Column(nullable = false)
    private String body;
    private String[] contractImageUrls;
    @OneToOne
    private Offer acceptedOffer;
    private String legalAgreement;
    //  private BigDecimal highestOfferAmount;
    //  private String highestOfferType;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String[] getContractImageUrls() {
        return contractImageUrls;
    }

    public void setContractImageUrls(String[] contractImageUrls) {
        this.contractImageUrls = contractImageUrls;
    }

    public User getContractee() {
        return contractee;
    }

    public void setContractee(User contractee) {
        this.contractee = contractee;
    }

    public User getContractor() {
        return contractor;
    }

    public void setContractor(User contractor) {
        this.contractor = contractor;
    }

    public Offer getAcceptedOffer() {
        return acceptedOffer;
    }

    public void setAcceptedOffer(Offer acceptedOffer) {
        this.acceptedOffer = acceptedOffer;
    }

    public String getLegalAgreement() {
        return legalAgreement;
    }

    public void setLegalAgreement(String legalAgreement) {
        this.legalAgreement = legalAgreement;
    }

//    public BigDecimal getHighestOfferAmount() {
//        return highestOfferAmount;
//    }
//
//    public void setHighestOfferAmount(BigDecimal highestOfferAmount) {
//        this.highestOfferAmount = highestOfferAmount;
//    }
//
//    public String getHighestOfferType() {
//        return highestOfferType;
//    }
//
//    public void setHighestOfferType(String highestOfferType) {
//        this.highestOfferType = highestOfferType;
//    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
}

package in.wwpy.server.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Long contracteeId;
    private Long contractorId;
    private String status;
    private String type;
    @Column(nullable = false)
    private String subject;
    @Column(nullable = false)
    private String body;
    private String[] contractImageUrls;
    private String legalAgreement;
    @OneToOne(fetch = FetchType.LAZY)
    private Offer acceptedOffer;
    private boolean isSeekingLowestOffer;
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

    public Long getContracteeId() {
        return contracteeId;
    }

    public void setContracteeId(Long contracteeId) {
        this.contracteeId = contracteeId;
    }

    public Long getContractorId() {
        return contractorId;
    }

    public void setContractorId(Long contractorId) {
        this.contractorId = contractorId;
    }

    public String getLegalAgreement() {
        return legalAgreement;
    }

    public void setLegalAgreement(String legalAgreement) {
        this.legalAgreement = legalAgreement;
    }

    public Offer getAcceptedOffer() {
        return acceptedOffer;
    }

    public void setAcceptedOffer(Offer acceptedOffer) {
        this.acceptedOffer = acceptedOffer;
    }

    public boolean isSeekingLowestOffer() {
        return isSeekingLowestOffer;
    }

    public void setSeekingLowestOffer(boolean seekingLowestOffer) {
        isSeekingLowestOffer = seekingLowestOffer;
    }

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

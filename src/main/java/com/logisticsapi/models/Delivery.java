package com.logisticsapi.models;

import com.logisticsapi.exceptions.DomainException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    private Client client;

    @Embedded
    @NotNull
    private Recipient recipient;

    @NotNull
    private BigDecimal rate;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Occurrence> occurrences;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @Column(name = "requestedat")
    private OffsetDateTime requestedAt;

    @Column(name = "finishedat")
    private OffsetDateTime finishedAt;

    public Occurrence addOccurrence(String description) {
        Occurrence occurrence = new Occurrence();
        occurrence.setDescription(description);
        occurrence.setRegistrationDate(OffsetDateTime.now());
        occurrence.setDelivery(this);
        this.occurrences.add(occurrence);
        return occurrence;
    }

    public void finish() {
        boolean isNotFinished = !this.status.equals(DeliveryStatus.PENDING);
        if (isNotFinished) {
            throw new DomainException("Delivery already finished or canceled");
        }
        this.status = DeliveryStatus.FINISHED;
        this.finishedAt = OffsetDateTime.now();
    }
}

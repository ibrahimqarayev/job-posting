package az.ijob.jobposting.model;

import jakarta.persistence.*;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@MappedSuperclass
@Data
public class BaseEntity {

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @Column(name = "number_of_views")
    private int numberOfViews=0;

    @Column(name = "serial_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serialNumber;

    @PrePersist
    protected void onCreate() {
        if (creationDate != null) {
            expirationDate = creationDate.plus(1, ChronoUnit.MONTHS);
        }
    }

}

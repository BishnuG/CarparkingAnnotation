package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="resident_annotation")
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="resident_id")
    private int residentId;

    @Column(name = "resident_name")
    private String residentName;

    @Column(name = "resident_email")
    private String residentEmail;

    @Column(name = "flat_number")
    private int flatNumber;

    @Column(name = "mobile_number")
    private long mobileNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}

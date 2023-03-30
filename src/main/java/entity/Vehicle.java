package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle_annotation")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private int vehicleId;

    @Column
    private String type;

    @Column(name = "registration_number")
    private long registrationNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "resident_id")
    private Resident resident;
}

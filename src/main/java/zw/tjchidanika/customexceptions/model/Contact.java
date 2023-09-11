package zw.tjchidanika.customexceptions.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String phoneNumber;
    private String emergencyContact;
    private String email;
    private String city;
    private String street;
    private String address;
    private String zipcode;

//    @OneToOne(mappedBy = "contact")
//    private Person person;
}

package zw.tjchidanika.customexceptions.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.tjchidanika.customexceptions.enums.Gender;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String nationality;
    private Gender gender;
    private Date dob;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_contact_id")
//    private Contact contact;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_contact_id", referencedColumnName = "id")
    private List<Contact> contacts;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Item> items = new HashSet<>();
}

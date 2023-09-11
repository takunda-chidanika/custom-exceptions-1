package zw.tjchidanika.customexceptions.dto;


import zw.tjchidanika.customexceptions.enums.Gender;
import zw.tjchidanika.customexceptions.model.Contact;

import java.util.Date;
import java.util.List;

public record PersonDto(String firstname,
                        String middlename,
                        String lastname,
                        Gender gender,
                        String nationality,
                        Date dob,
                        List<Contact> contact) {
}

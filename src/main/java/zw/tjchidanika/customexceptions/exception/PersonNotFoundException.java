package zw.tjchidanika.customexceptions.exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class PersonNotFoundException extends RuntimeException {
    private String message;
}


package zw.tjchidanika.customexceptions.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemNotFound extends RuntimeException{
    private String message;
}

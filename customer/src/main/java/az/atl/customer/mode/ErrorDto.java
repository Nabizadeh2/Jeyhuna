package az.atl.customer.mode;

import jakarta.validation.Valid;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ErrorDto {
    int errorCode;
    String message;
    LocalDateTime localDateTime;
}

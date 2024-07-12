package az.atl.customer.mode;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CustomerRequest {

    String name;
    String surname;
    String email;
    String contry;
}

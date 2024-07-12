package az.atl.customer.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customer")
public class EntityCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name="name",nullable = false)
    private  String name;
    @Column(name = "surname",nullable = false)
    private String surname;
    private String email ;
    @Column(name = "contry",nullable = false)
    private String contry;

}

package vn.edu.iuh.fit.backEnd.entities;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id")
    private long id;

    @Column(name = "number", length = 20)
    private String number;

    @Column(name = "country", nullable = false)
    private CountryCode country = CountryCode.VN;

    @Column(name = "zipcode", nullable = false, columnDefinition = "varchar(7)")
    private String zipCode;

    @Column(name = "city", nullable = false, columnDefinition = "varchar(50)")
    private String city;

    @Column(name = "street", nullable = false, columnDefinition = "varchar(150)")
    private String street;

    @OneToOne(mappedBy = "address")
    private Candidate candidate;

    @OneToOne(mappedBy = "address")
    private Company company;


    @Override
    public String toString() {
        return "Address{" +
            "number='" + number + '\'' +
            ", country=" + country.getName() +
            ", zipCode='" + zipCode + '\'' +
            ", city='" + city + '\'' +
            ", street='" + street + '\'' +
            '}';
    }


    public Address(String number, String street, String city, String zipcode, CountryCode country) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.zipCode = zipcode;
        this.country = country;
    }
}

package vn.edu.iuh.fit.backEnd.repositories;

import org.springframework.data.repository.CrudRepository;
import vn.edu.iuh.fit.backEnd.entities.Address;


public interface AddressRepository extends CrudRepository<Address, Long> {
}

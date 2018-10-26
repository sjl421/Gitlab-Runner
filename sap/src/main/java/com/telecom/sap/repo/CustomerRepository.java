package com.telecom.sap.repo;

import com.telecom.sap.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByLastName(@Param("lastName") String lastName);

}

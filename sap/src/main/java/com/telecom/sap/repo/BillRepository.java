package com.telecom.sap.repo;

import com.telecom.sap.entity.Bill;
import com.telecom.sap.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface BillRepository extends CrudRepository<Bill, Long> {

    List<Bill> findByCustomerId(@Param("customerId") String customerId);
}


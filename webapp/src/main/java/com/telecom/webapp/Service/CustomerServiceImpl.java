package com.telecom.webapp.Service;

import com.telecom.webapp.model.customer.Content;
import com.telecom.webapp.model.customer.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${bff.url.customers}")
    private String bffCustomerUrl;

    @Override
    public List<Content> getAllCustomers() {
        Customer customer = restTemplate.getForObject(bffCustomerUrl, Customer.class);
        log.info("Output from Bff service:" + customer);
        return customer.getContent();
    }
}

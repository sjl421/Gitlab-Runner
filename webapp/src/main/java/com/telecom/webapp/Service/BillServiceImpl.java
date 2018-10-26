package com.telecom.webapp.Service;

import com.telecom.webapp.model.bill.Bill;
import com.telecom.webapp.model.bill.Content;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    private static final Logger log = LoggerFactory.getLogger(BillServiceImpl.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${bff.url.bills}")
    private String bffBillUrl;

    @Override
    public List<Content> getBillByCustomerId(Long customerID) {
        Bill bill = restTemplate.getForObject(bffBillUrl+customerID, Bill.class);
        log.info("Output from Bff service:" + bill);
        return bill.getContent();
    }
}

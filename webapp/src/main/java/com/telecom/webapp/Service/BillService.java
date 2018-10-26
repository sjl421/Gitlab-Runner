package com.telecom.webapp.Service;

import com.telecom.webapp.model.bill.Content;

import java.util.List;

public interface BillService {

    public List<Content> getBillByCustomerId(Long customerID);
}

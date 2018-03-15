package com.globallogic.report.billing.data;

import com.globallogic.report.billing.constants.BillingConstant;
import com.globallogic.report.billing.domain.Bills;
import com.globallogic.report.billing.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by sunny on 15/03/18.
 */
@Service
public class DataServiceImpl implements DataService {

    @Override
    public List<Bills> getUserBills() {
        RestTemplate restTemplate = new RestTemplate();
        User result = restTemplate.getForObject(BillingConstant.URI, User.class);
        List<Bills> bills = result.getBills();
        return bills;
    }
}

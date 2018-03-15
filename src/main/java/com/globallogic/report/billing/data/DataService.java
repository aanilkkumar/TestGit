package com.globallogic.report.billing.data;

import com.globallogic.report.billing.domain.Bills;

import java.util.List;

/**
 * Created by sunny on 15/03/18.
 */
public interface DataService {
    List<Bills> getUserBills();
}

package com.globallogic.report.billing.service;


import com.globallogic.report.billing.constants.BillingConstant;
import com.globallogic.report.billing.data.DataService;
import com.globallogic.report.billing.domain.Bills;

import com.globallogic.report.billing.domain.PredictionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by sunny on 15/03/18.
 */

@Service
public class PredictionServiceImpl implements PredictionService {
    private final static Logger LOGGER = Logger.getLogger(PredictionServiceImpl.class.getName());

    @Autowired
    private DataService dataService;

    @Override
    public PredictionResponse getBillPrediction(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(BillingConstant.DATE_FORMAT);
        List<Bills> bills = dataService.getUserBills();
        if(bills == null){
            return null;
        }
        double billSum = 0.0;
        double count = 0.0;
        Date lastBillDate = new Date();
        Date lastDueDate = new Date();
        for (Bills bill: bills) {
            Date billDate = sdf.parse(bill.getBillDate());
            if(billDate.after(date) &&  bill.getBillAmount() > 0) { //satisfying the condition of using bill of higher date than input date and should be greater than 0
                billSum += bill.getBillAmount();
                //Get the latest month so that next bill month can be decided
                if(count == 0) {
                    lastBillDate = billDate;
                    lastDueDate = sdf.parse(bill.getDueDate());
                }
                else{
                    if(billDate.after(lastBillDate) && count > 0) {
                        lastBillDate = billDate;
                        lastDueDate = sdf.parse(bill.getDueDate());
                    }
                }
                count++;
            }
        }
        double avg = count > 0 ? billSum/count: 0;
        if(avg == 0.0) {
            return null;
        }
        PredictionResponse predictionResponse = new PredictionResponse(avg, addOneMonth(lastBillDate), addOneMonth(lastDueDate));

        return predictionResponse;
    }

    private String addOneMonth(Date date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        SimpleDateFormat sdf = new SimpleDateFormat(BillingConstant.DATE_FORMAT);
        String formattedDate = sdf.format(cal.getTime());
        return formattedDate;
    }

}

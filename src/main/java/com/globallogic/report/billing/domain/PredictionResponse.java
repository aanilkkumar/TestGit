package com.globallogic.report.billing.domain;

import java.text.DecimalFormat;

/**
 * Created by sunny on 15/03/18.
 */
public class PredictionResponse {

    private static DecimalFormat df = new DecimalFormat(".##");


    private double nextBillAmount;

    private String nextBillDate;

    private String dueDate;

    public PredictionResponse(double nextBillAmount, String nextBillDate, String dueDate) {
        this.nextBillAmount = nextBillAmount;
        this.nextBillDate = nextBillDate;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Next Bill Amount: " + df.format(nextBillAmount) + "\n" +
                "Next Bill Date: " + nextBillDate + "\n" +
                "Due Date: " + dueDate ;
    }
}

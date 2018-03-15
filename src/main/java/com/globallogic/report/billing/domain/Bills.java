package com.globallogic.report.billing.domain;

/**
 * Created by sunny on 15/03/18.
 */
public class Bills
{
    private String billDate;

    private double billAmount;

    private String dueDate;

    public String getBillDate ()
    {
        return billDate;
    }

    public void setBillDate (String billDate)
    {
        this.billDate = billDate;
    }

    public double getBillAmount ()
    {
        return billAmount;
    }

    public void setBillAmount (double billAmount)
    {
        this.billAmount = billAmount;
    }

    public String getDueDate ()
    {
        return dueDate;
    }

    public void setDueDate (String dueDate)
    {
        this.dueDate = dueDate;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [billDate = "+billDate+", billAmount = "+billAmount+", dueDate = "+dueDate+"]";
    }
}

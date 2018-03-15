package com.globallogic.report.billing.domain;

import java.util.List;

/**
 * Created by sunny on 15/03/18.
 */
public class User
{
    private String name;

    private String creditLimit;

    private String cardType;

    private List<Bills> bills;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getCreditLimit ()
    {
        return creditLimit;
    }

    public void setCreditLimit (String creditLimit)
    {
        this.creditLimit = creditLimit;
    }

    public String getCardType ()
    {
        return cardType;
    }

    public void setCardType (String cardType)
    {
        this.cardType = cardType;
    }

    public List<Bills> getBills ()
    {
        return bills;
    }

    public void setBills (List<Bills> bills)
    {
        this.bills = bills;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", creditLimit = "+creditLimit+", cardType = "+cardType+", bills = "+bills.toString()+"]";
    }
}
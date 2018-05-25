package models;


import gherkin.deps.com.google.gson.annotations.Expose;

public class SmartDataModel {

    @Expose
    private String __deprecation_message__;
    @Expose
    private String base;
    @Expose
    private Rates rates;
    @Expose
    private String date;

    public String get__deprecation_message__ ()
    {
        return __deprecation_message__;
    }

    public void set__deprecation_message__ (String __deprecation_message__)
    {
        this.__deprecation_message__ = __deprecation_message__;
    }

    public String getBase ()
    {
        return base;
    }

    public void setBase (String base)
    {
        this.base = base;
    }

    public Rates getRates ()
    {
        return rates;
    }

    public void setRates (Rates rates)
    {
        this.rates = rates;
    }

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }
}

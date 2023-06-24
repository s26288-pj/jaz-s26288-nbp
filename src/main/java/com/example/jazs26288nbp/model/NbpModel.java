package com.example.jazs26288nbp.model;

public class NbpModel {

    private String table;
    private String currency;
    private String code;
    private Rate[] rates;

    public String getTable() { return table; }
    public void setTable(String value) { this.table = value; }

    public String getCurrency() { return currency; }
    public void setCurrency(String value) { this.currency = value; }

    public String getCode() { return code; }
    public void setCode(String value) { this.code = value; }

    public Rate[] getRates() { return rates; }
    public void setRates(Rate[] value) { this.rates = value; }
}

package com.example.jazs26288nbp.model;

import java.time.LocalDate;

public class Rate {
    private String no;
    private LocalDate effectiveDate;
    private double mid;

    public String getNo() { return no; }
    public void setNo(String value) { this.no = value; }

    public LocalDate getEffectiveDate() { return effectiveDate; }
    public void setEffectiveDate(LocalDate value) { this.effectiveDate = value; }

    public double getMid() { return mid; }
    public void setMid(double value) { this.mid = value; }
}

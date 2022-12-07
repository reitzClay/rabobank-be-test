package nl.rabobank.example.model;

import java.util.Date;
import java.util.Objects;

public class Record {
    private int reference;
    private String accountNumber;
    private String description;
    private double startBalance;
    private double mutation;
    private double endBalance;
    private Date date;

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStartBalance() {
        return startBalance;
    }

    public void setStartBalance(double startBalance) {
        this.startBalance = startBalance;
    }

    public double getMutation() {
        return mutation;
    }

    public void setMutation(double mutation) {
        this.mutation = mutation;
    }

    public double getEndBalance() {
        return endBalance;
    }

    public void setEndBalance(double endBalance) {
        this.endBalance = endBalance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return reference == record.reference && Double.compare(record.startBalance, startBalance) == 0 && Double.compare(record.mutation, mutation) == 0 && Double.compare(record.endBalance, endBalance) == 0 && Objects.equals(accountNumber, record.accountNumber) && Objects.equals(description, record.description) && Objects.equals(date, record.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, accountNumber, description, startBalance, mutation, endBalance, date);
    }
}

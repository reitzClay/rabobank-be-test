package nl.rabobank.example.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.Date;
import java.util.Objects;

@JacksonXmlRootElement
public class Record {
    private int record;
    private int reference;
    private String accountNumber;
    private String description;
    private double startBalance;
    private double mutation;
    private double endBalance;
    private Date date;

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

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
        Record record1 = (Record) o;
        return record == record1.record && reference == record1.reference && Double.compare(record1.startBalance, startBalance) == 0 && Double.compare(record1.mutation, mutation) == 0 && Double.compare(record1.endBalance, endBalance) == 0 && Objects.equals(accountNumber, record1.accountNumber) && Objects.equals(description, record1.description) && Objects.equals(date, record1.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(record, reference, accountNumber, description, startBalance, mutation, endBalance, date);
    }
}

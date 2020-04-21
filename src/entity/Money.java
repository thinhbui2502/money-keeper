package entity;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Money")
@XmlAccessorType(XmlAccessType.FIELD)

public class Money implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String date;
    private String moneyName;
    private int amount;
    private String description;

    public Money() {
    }

    public Money(int id, String date, String moneyName, int amount, String description) {
        super();
        this.id = id;
        this.date = date;
        this.moneyName = moneyName;
        this.amount = amount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMoneyName() {
        return moneyName;
    }

    public void setMoneyName(String moneyName) {
        this.moneyName = moneyName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

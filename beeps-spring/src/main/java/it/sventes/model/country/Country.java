package it.sventes.model.country;

import it.sventes.model.holidays.Holidays;

import javax.persistence.*;
import java.util.List;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "country_id")
    private Long id;

    @Column(name = "name", nullable = false, unique=true)
    private String name;

    @Column(name = "flagImageH")
    private String flagImageH;

    @Column(name = "prezident")
    private String prezident;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="country")
    private List<Holidays> holidays;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Holidays> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<Holidays> holidays) {
        this.holidays = holidays;
    }

    public String getFlagImageH() {
        return flagImageH;
    }

    public void setFlagImageH(String flagImageH) {
        this.flagImageH = flagImageH;
    }

    public String getPrezident() {
        return prezident;
    }

    public void setPrezident(String prezident) {
        this.prezident = prezident;
    }

}

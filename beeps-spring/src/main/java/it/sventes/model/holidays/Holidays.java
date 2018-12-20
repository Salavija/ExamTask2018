package it.sventes.model.holidays;

import it.sventes.configs.Type;
import it.sventes.model.year.Year;
import it.sventes.model.country.Country;

import javax.persistence.*;

@Entity
public class Holidays {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "holidays_id")
    private Long id;

    @Column(name = "name", nullable = false, unique=true)
    private String name;

    @Column(name = "info", nullable = false)
    private String info;

    private String image;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "flagIsUp")
    private Boolean flagIsUp;

    @ManyToOne
    @JoinColumn(name = "country_name")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "year_number")
    private Year year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Boolean getFlagIsUp() {
        return flagIsUp;
    }

    public void setFlagIsUp(Boolean flagIsUp) {
        this.flagIsUp = flagIsUp;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }
}

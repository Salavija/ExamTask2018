package it.sventes.model.year;

import it.sventes.model.holidays.Holidays;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity
public class Year {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "year_id")
    private Long id;

    @Column(name="name", unique=true)
    private Integer number;

    @Column(name = "dayNumber", nullable = false)
    @Length(min = 1, max = 31, message = "*Day of a month")
    private Integer dayNumber;

    @Column(name = "eastHoroscope", nullable = false)
    private String eastHoroscope;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="year")
    private List<Holidays> holidays;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(Integer dayNumber) {
        this.dayNumber = dayNumber;
    }

    public String getEastHoroscope() {
        return eastHoroscope;
    }

    public void setEastHoroscope(String eastHoroscope) {
        this.eastHoroscope = eastHoroscope;
    }

    public List<Holidays> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<Holidays> holidays) {
        this.holidays = holidays;
    }
}

package it.sventes.model.country;

import it.sventes.model.holidays.Holidays;

import java.util.List;

public class CountryRest {

    private String nameR;
    private String flagImageR;
    private String prezidentR;
    private List<Holidays> holidaysR;

    public CountryRest() {
    }

    public CountryRest(String nameR, String flagImageR, String prezidentR, List<Holidays> holidaysR) {
        this.nameR = nameR;
        this.flagImageR = flagImageR;
        this.prezidentR = prezidentR;
        this.holidaysR = holidaysR;
    }

    public String getNameR() {
        return nameR;
    }

    public void setNameR(String nameR) {
        this.nameR = nameR;
    }

    public String getFlagImageR() {
        return flagImageR;
    }

    public void setFlagImageR(String flagImageR) {
        this.flagImageR = flagImageR;
    }

    public String getPrezidentR() {
        return prezidentR;
    }

    public void setPrezidentR(String prezidentR) {
        this.prezidentR = prezidentR;
    }

    public List<Holidays> getHolidaysR() {
        return holidaysR;
    }

    public void setHolidaysR(List<Holidays> holidaysR) {
        this.holidaysR = holidaysR;
    }
}


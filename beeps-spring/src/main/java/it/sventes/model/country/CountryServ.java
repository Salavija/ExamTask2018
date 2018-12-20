package it.sventes.model.country;

import it.sventes.model.holidays.Holidays;

import java.util.List;

public class CountryServ {

    private String nameS;
    private String flagImageS;
    private String prezidentS;
    private List<Holidays> holidaysS;

    public CountryServ() {
    }

    public CountryServ(String nameS, String flagImageS, String prezidentS, List<Holidays> holidaysS) {
        this.nameS = nameS;
        this.flagImageS = flagImageS;
        this.prezidentS = prezidentS;
        this.holidaysS = holidaysS;
    }

    public String getNameS() {
        return nameS;
    }

    public void setNameS(String nameS) {
        this.nameS = nameS;
    }

    public String getFlagImageS() {
        return flagImageS;
    }

    public void setFlagImageS(String flagImageS) {
        this.flagImageS = flagImageS;
    }

    public String getPrezidentS() {
        return prezidentS;
    }

    public void setPrezidentS(String prezidentS) {
        this.prezidentS = prezidentS;
    }

    public List<Holidays> getHolidaysS() {
        return holidaysS;
    }

    public void setHolidaysS(List<Holidays> holidaysS) {
        this.holidaysS = holidaysS;
    }
}

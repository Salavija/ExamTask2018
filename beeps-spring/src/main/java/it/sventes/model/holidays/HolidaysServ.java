package it.sventes.model.holidays;

import it.sventes.configs.Type;

public class HolidaysServ {

    private String nameS;
    private String infoS;
    private String imageR;
    private Type typeR;
    private Boolean flagIsUpS;

    public HolidaysServ() {
    }

    public HolidaysServ(String nameS, String infoS, String imageR, Type typeR, Boolean flagIsUpS) {
        this.nameS = nameS;
        this.infoS = infoS;
        this.imageR = imageR;
        this.typeR = typeR;
        this.flagIsUpS = flagIsUpS;
    }

    public String getNameS() {
        return nameS;
    }

    public void setNameS(String nameS) {
        this.nameS = nameS;
    }

    public String getInfoS() {
        return infoS;
    }

    public void setInfoS(String infoS) {
        this.infoS = infoS;
    }

    public String getImageR() {
        return imageR;
    }

    public void setImageR(String imageR) {
        this.imageR = imageR;
    }

    public Type getTypeR() {
        return typeR;
    }

    public void setTypeR(Type typeR) {
        this.typeR = typeR;
    }

    public Boolean getFlagIsUpS() {
        return flagIsUpS;
    }

    public void setFlagIsUpS(Boolean flagIsUpS) {
        this.flagIsUpS = flagIsUpS;
    }
}

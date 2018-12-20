package it.sventes.model.holidays;

import it.sventes.configs.Type;

public class HolidaysRest {

    private String nameR;;
    private String infoR;
    private String imageR;
    private Type typeR;
    private Boolean flagIsUpR;

    public HolidaysRest() {
    }

    public HolidaysRest(String nameR, String infoR, String imageR, Type typeR, Boolean flagIsUpR) {
        this.nameR = nameR;
        this.infoR = infoR;
        this.imageR = imageR;
        this.typeR = typeR;
        this.flagIsUpR = flagIsUpR;
    }

    public String getNameR() {
        return nameR;
    }

    public void setNameR(String nameR) {
        this.nameR = nameR;
    }

    public String getInfoR() {
        return infoR;
    }

    public void setInfoR(String infoR) {
        this.infoR = infoR;
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

    public Boolean getFlagIsUpR() {
        return flagIsUpR;
    }

    public void setFlagIsUpR(Boolean flagIsUpR) {
        this.flagIsUpR = flagIsUpR;
    }
}

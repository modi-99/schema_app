package Database;

public class Schedule {
    private String datum;
    private Integer id;
    private boolean lunch;
    private boolean middag;
    private String namn;

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isLunch() {
        return lunch;
    }

    public void setLunch(boolean lunch) {
        this.lunch = lunch;
    }

    public boolean isMiddag() {
        return middag;
    }

    public void setMiddag(boolean middag) {
        this.middag = middag;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

}

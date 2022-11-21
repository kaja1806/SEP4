package sep4Project.Model;

import java.util.Date;

public class WaterStatusModel {

    // declaring the variables
    private String SolarPanelID;
    private Date DateAndTime;
    private double WaterConsumption;

    public WaterStatusModel(String panelID, Date creationDate, double efficiency) {
        this.SolarPanelID = panelID;
        this.DateAndTime = creationDate;
        this.WaterConsumption = efficiency;
    }

    public String getSolarPanelID() {
        return SolarPanelID;
    }


    public Date getDateAndTime() {
        return DateAndTime;
    }

    public double getWaterConsumption() {
        return WaterConsumption;
    }

    // defining getter  methods

}

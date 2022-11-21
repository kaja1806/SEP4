package sep4Project.Model;

import java.util.Date;

public class EnergyStatusModel {

    // declaring the variables
    private int ID;
    private Date DateAndTime;
    private double Voltage;
    private double Current;
    private double Resistance;
    private double Power;
    private double Efficiency;
    private String SolarPanelID;

    public EnergyStatusModel(Date dateAndTime, double voltage, double current, double resistance, double power, double efficiency, String solarPanelID) {
        DateAndTime = dateAndTime;
        Voltage = voltage;
        Current = current;
        Resistance = resistance;
        Power = power;
        Efficiency = efficiency;
        SolarPanelID = solarPanelID;
    }

    public EnergyStatusModel() {
        
    }

    public Date getDateAndTime() {
        return DateAndTime;
    }

    public double getVoltage() {
        return Voltage;
    }

    public double getCurrent() {
        return Current;
    }

    public double getResistance() {
        return Resistance;
    }

    public double getPower() {
        return Power;
    }

    public double getEfficiency() {
        return Efficiency;
    }

    public String getSolarPanelID() {
        return SolarPanelID;
    }
}
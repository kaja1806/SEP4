package sep4Project.Model;

import java.util.Date;

public class PanelInstallationModel {
    private String id;
    private Date InstallDate;
    private String Manufacturer;
    private String PanelType;
    private String Placement;

    public PanelInstallationModel(String panelID, Date creationDate, String placement, String type, String manufacture) {
        this.id = panelID;
        this.InstallDate = creationDate;
        this.Manufacturer = manufacture;
        this.PanelType = type;
        this.Placement = placement;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getInstallDate() {
        return InstallDate;
    }

    public void setInstallDate(Date installDate) {
        this.InstallDate = installDate;
    }


    public String getPlacement() {
        return Placement;
    }

    public void setPlacement(String placement) {
        this.Placement = placement;
    }


    public String getPanelType() {
        return PanelType;
    }

    public void setPanelType(String panelType) {
        PanelType = panelType;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }
}

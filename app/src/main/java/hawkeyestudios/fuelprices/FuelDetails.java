package hawkeyestudios.fuelprices;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FuelDetails {

    public FuelDetails(String city, Double diesel, Double petrol) {
        this.city = city;
        this.diesel = diesel;
        this.petrol = petrol;
    }

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("diesel")
    @Expose
    private Double diesel;

    @SerializedName("petrol")
    @Expose
    private Double petrol;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getDiesel() {
        return diesel;
    }

    public void setDiesel(Double diesel) {
        this.diesel = diesel;
    }

    public Double getPetrol() {
        return petrol;
    }

    public void setPetrol(Double petrol) {
        this.petrol = petrol;
    }


}

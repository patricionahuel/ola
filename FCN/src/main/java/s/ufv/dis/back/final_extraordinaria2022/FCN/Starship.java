package s.ufv.dis.back.final_extraordinaria2022.FCN;

import java.util.ArrayList;

public class Starship {

        private String model;
        private String manufacturer;
        private String costInCredits;
        private String length;
        private String maxAtmospheringSpeed;
        private String crew;
        private String passengers;
        private String cargoCapacity;
        private String consumables;
        private String hyperdriveRating;
        private String MGLT;
        private String starshipClass;
        private ArrayList<String> pilots;
        private ArrayList<String> films;

        public Starship(String model, String manufacturer, String costInCredits, String length, String maxAtmospheringSpeed, String crew, String passengers, String cargoCapacity, String consumables, String hyperdriveRating, String MGLT, String starshipClass, ArrayList<String> pilots, ArrayList<String> films) {
            this.model = model;
            this.manufacturer = manufacturer;
            this.costInCredits = costInCredits;
            this.length = length;
            this.maxAtmospheringSpeed = maxAtmospheringSpeed;
            this.crew = crew;
            this.passengers = passengers;
            this.cargoCapacity = cargoCapacity;
            this.consumables = consumables;
            this.hyperdriveRating = hyperdriveRating;
            this.MGLT = MGLT;
            this.starshipClass = starshipClass;
            this.pilots = pilots;
            this.films = films;
        }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCostInCredits() {
        return costInCredits;
    }

    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getHyperdriveRating() {
        return hyperdriveRating;
    }

    public void setHyperdriveRating(String hyperdriveRating) {
        this.hyperdriveRating = hyperdriveRating;
    }

    public String getMGLT() {
        return MGLT;
    }

    public void setMGLT(String MGLT) {
        this.MGLT = MGLT;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    public ArrayList<String> getPilots() {
        return pilots;
    }

    public void setPilots(ArrayList<String> pilots) {
        this.pilots = pilots;
    }

    public ArrayList<String> getFilms() {
        return films;
    }

    public void setFilms(ArrayList<String> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Starship{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", costInCredits='" + costInCredits + '\'' +
                ", length='" + length + '\'' +
                ", maxAtmospheringSpeed='" + maxAtmospheringSpeed + '\'' +
                ", crew='" + crew + '\'' +
                ", passengers='" + passengers + '\'' +
                ", cargoCapacity='" + cargoCapacity + '\'' +
                ", consumables='" + consumables + '\'' +
                ", hyperdriveRating='" + hyperdriveRating + '\'' +
                ", MGLT='" + MGLT + '\'' +
                ", starshipClass='" + starshipClass + '\'' +
                ", pilots=" + pilots +
                ", films=" + films +
                '}';
    }
}

package models;

public class Brand {
    private String brandName;
    private CarModel[] models;

    public Brand(String brandName, CarModel[] models) {
        this.brandName = brandName;
        this.models = models;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public CarModel[] getModels() {
        return models;
    }

    public void setModels(CarModel[] models) {
        this.models = models;
    }

    /**
     * Calcula el total de años válidos en todos los modelos de esta marca
     * 
     * @return cantidad total de años válidos
     */
    public int getTotalValidYears() {
        int total = 0;
        for (CarModel model : models) {
            if (model != null && model.getYears() != null) {
                for (CarYear year : model.getYears()) {
                    if (year != null && year.isValid()) {
                        total++;
                    }
                }
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return "Marca: " + brandName + ", Total de años válidos: " + getTotalValidYears();
    }
}

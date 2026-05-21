package models;

import java.util.Arrays;

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

  public int getTotalValidYears() {
    int contYears = 0;
    for (int i = 0; i < models.length; i++) {
      CarYear[] years = models[i].getYears();
      for (int j = 0; j < years.length; j++) {
        if (years[i].isValid())
          contYears++;
      }
    }
    return contYears;
  }

  @Override
  public String toString() {
    return "BrandController [brandName=" + brandName + ", models=" + Arrays.toString(models) + "]";
  }
}

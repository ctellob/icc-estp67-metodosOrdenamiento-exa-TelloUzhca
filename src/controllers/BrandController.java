package controllers;

import models.Brand;

public class BrandController {
  public Brand[] sortBubbleDesc(Brand[] brands) {
    for (int i = 0; i < brands.length - 1; i++) {
      boolean cambio = false;
      for (int j = 0; j < brands.length - i - 1; j++) {
        if (brands[j].getTotalValidYears() < brands[j + 1].getTotalValidYears()) {
          Brand aux = brands[j];
          brands[j] = brands[j + 1];
          brands[j + 1] = aux;
          cambio = true;
        }
      }
      if (!cambio) {
        break;
      }
    }
    return brands;
  }
}

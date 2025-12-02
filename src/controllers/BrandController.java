package controllers;

import models.Brand;

public class BrandController {

    // /**
    // * Selection Sort descendente - Ordena por cantidad de años válidos de mayor a
    // menor
    // * @param brands Arreglo de marcas a ordenar
    // * @return Arreglo ordenado
    // */
    // public Brand[] sortSelectionDesc(Brand[] brands) {
    // int n = brands.length;

    // for (int i = 0; i < n - 1; i++) {
    // int maxIdx = i;
    // for (int j = i + 1; j < n; j++) {
    // if (brands[j].getTotalValidYears() > brands[maxIdx].getTotalValidYears()) {
    // maxIdx = j;
    // }
    // }
    // // Intercambiar
    // Brand temp = brands[maxIdx];
    // brands[maxIdx] = brands[i];
    // brands[i] = temp;
    // }

    // return brands;
    // }

    // /**
    // * Selection Sort ascendente - Ordena por cantidad de años válidos de menor a
    // mayor
    // * @param brands Arreglo de marcas a ordenar
    // * @return Arreglo ordenado
    // */
    // public Brand[] sortSelectionAsc(Brand[] brands) {
    // int n = brands.length;

    // for (int i = 0; i < n - 1; i++) {
    // int minIdx = i;
    // for (int j = i + 1; j < n; j++) {
    // if (brands[j].getTotalValidYears() < brands[minIdx].getTotalValidYears()) {
    // minIdx = j;
    // }
    // }
    // // Intercambiar
    // Brand temp = brands[minIdx];
    // brands[minIdx] = brands[i];
    // brands[i] = temp;
    // }

    // return brands;
    // }

    // /**
    // * Insertion Sort descendente - Ordena por cantidad de años válidos de mayor a
    // menor
    // * @param brands Arreglo de marcas a ordenar
    // * @return Arreglo ordenado
    // */
    // public Brand[] sortInsertionDesc(Brand[] brands) {
    // int n = brands.length;

    // for (int i = 1; i < n; i++) {
    // Brand key = brands[i];
    // int j = i - 1;

    // while (j >= 0 && brands[j].getTotalValidYears() < key.getTotalValidYears()) {
    // brands[j + 1] = brands[j];
    // j = j - 1;
    // }
    // brands[j + 1] = key;
    // }

    // return brands;
    // }

    /**
     * Bubble Sort descendente - Ordena por cantidad de años válidos de mayor a
     * menor
     * 
     * @param brands Arreglo de marcas a ordenar
     * @return Arreglo ordenado
     */
    public Brand[] sortBubbleDesc(Brand[] brands) {
        int n = brands.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (brands[j].getTotalValidYears() < brands[j + 1].getTotalValidYears()) {
                    // Intercambiar
                    Brand temp = brands[j];
                    brands[j] = brands[j + 1];
                    brands[j + 1] = temp;
                }
            }
        }

        return brands;
    }

    /**
     * Búsqueda binaria por cantidad de años válidos
     * 
     * @param brands      Arreglo de marcas ordenado
     * @param validYears  Cantidad de años válidos a buscar
     * @param isAscending true si el arreglo está ordenado ascendentemente, false si
     *                    es descendente
     * @return La marca encontrada o null si no existe
     */
    public Brand binarySearchByValidYears(Brand[] brands, int validYears, boolean isAscending) {
        int left = 0;
        int right = brands.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValidYears = brands[mid].getTotalValidYears();

            if (midValidYears == validYears) {
                return brands[mid];
            }

            if (isAscending) {
                // Búsqueda en orden ascendente
                if (midValidYears < validYears) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // Búsqueda en orden descendente
                if (midValidYears > validYears) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return null; // No encontrado
    }

    /**
     * Imprime un arreglo de marcas
     * 
     * @param brands Arreglo de marcas
     */
    public void printBrands(Brand[] brands) {
        for (Brand brand : brands) {
            System.out.println(brand.getBrandName() + " - Años válidos: " + brand.getTotalValidYears());
        }
    }
}

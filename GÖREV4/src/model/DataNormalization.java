package model;

import java.util.Arrays;
import java.util.Random;

public class DataNormalization {
    public static void main(String[] args) {
        int[] dataset = new int[500]; // 500 elemanlı dizi
        
        // Diziye rastgele sayılar ekleme
        Random rand = new Random();
        for (int i = 0; i < dataset.length; i++) {
            dataset[i] = rand.nextInt(10000) + 1; // 1 ile 10000 arasında rastgele sayılar
        }
        
        int min = dataset[0]; // Minimum değer
        int max = dataset[0]; // Maksimum değer
        
        // Dizideki minimum ve maksimum değerleri bulma
        for (int num : dataset) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        System.out.println("Veri Seti: " + Arrays.toString(dataset));
        System.out.println("Normalizasyon: " + normalize(dataset, min, max));
    }
    
    // Verileri normalleştiren metod
    public static String normalize(int[] dataset, int min, int max) {
        StringBuilder normalization = new StringBuilder("[");
        for (int i = 0; i < dataset.length; i++) {
            double normalizedValue = (double) (dataset[i] - min) / (max - min); // Normalizasyon formülü
            normalization.append(String.format("%.2f", normalizedValue)); // 2 ondalık basamakla formatlama
            if (i < dataset.length - 1) {
                normalization.append(", ");
            }
        }
        normalization.append("]");
        return normalization.toString();
    }
}

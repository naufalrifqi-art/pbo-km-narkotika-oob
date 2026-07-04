package controller;

import model.Putusan;
import java.util.Comparator;

/**
 * Class untuk mengurutkan objek Putusan.
 * Mengimplementasikan interface Comparator untuk memenuhi syarat OOP.
 * @author [Nama Kamu]
 */
public class PengurutPutusan implements Comparator<Putusan> {

    private String kriteria;

    public PengurutPutusan(String kriteria) {
        this.kriteria = kriteria;
    }

    @Override
    public int compare(Putusan p1, Putusan p2) {
        // Mengurutkan berdasarkan Vonis Hukuman (bulan)
        if (kriteria.equalsIgnoreCase("vonis")) {
            return Integer.compare(p1.getVonisHukuman(), p2.getVonisHukuman());
        }
        // Mengurutkan berdasarkan Vonis Denda (rupiah)
        else if (kriteria.equalsIgnoreCase("denda")) {
            return Double.compare(p1.getVonisDenda(), p2.getVonisDenda());
        }
        return 0;
    }
}
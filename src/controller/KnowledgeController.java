package controller;

import model.*;
import java.util.ArrayList;

/**
 * Controller yang menjembatani Model dan View
 * @author [Nama Kamu]
 */
public class KnowledgeController {

    private KnowledgeRepository repository;

    public KnowledgeController() {
        this.repository = new KnowledgeRepository();
    }

    /**
     * Tambah putusan baru
     */
    public boolean tambahPutusan(Putusan putusan) {
        try {
            repository.simpan(putusan);
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    /**
     * Cari putusan berdasarkan keyword
     */
    public ArrayList<Putusan> cariPutusan(String keyword, String mode) {
        if (mode.equals("nomor")) {
            Putusan p = repository.cariByNomor(keyword);
            ArrayList<Putusan> hasil = new ArrayList<>();
            if (p != null) hasil.add(p);
            return hasil;
        } else if (mode.equals("nama")) {
            return repository.cariByNama(keyword);
        }
        return new ArrayList<>();
    }

    /**
     * Filter putusan berdasarkan kriteria
     */
    public ArrayList<Putusan> filterPutusan(String kriteria, String nilai) {
        if (kriteria.equals("jenis")) {
            return repository.filterByJenis(nilai);
        } else if (kriteria.equals("pengadilan")) {
            return repository.filterByPengadilan(nilai);
        }
        return new ArrayList<>();
    }

    /**
     * Hapus putusan
     */
    public boolean hapusPutusan(String nomorPerkara) {
        return repository.hapus(nomorPerkara);
    }

    /**
     * Dapatkan statistik
     */
    public StatistikPutusan getStatistik() {
        return new StatistikPutusan(repository.getDaftarSemua());
    }

    /**
     * Tampilkan semua putusan
     */
    public ArrayList<Putusan> tampilkanSemua() {
        return repository.getDaftarSemua();
    }

    /**
     * Dapatkan repository
     */
    public KnowledgeRepository getRepository() {
        return repository;
    }
}
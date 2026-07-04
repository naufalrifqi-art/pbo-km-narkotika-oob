package controller;

import java.util.Collections;
import model.*;
import util.InputHandler;
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
    public boolean tambahPutusan(String[] data) {
        try {
            String nomor = InputHandler.validasiString(data[0]);
            String pengadilan = InputHandler.validasiString(data[1]);
            String tanggal = InputHandler.validasiString(data[2]);
            String nama = InputHandler.validasiString(data[3]);
            int umur = InputHandler.validasiInt(data[4]);
            String jenis = InputHandler.validasiString(data[5]);
            double berat = InputHandler.validasiDouble(data[6]);
            String pasal = InputHandler.validasiString(data[7]);
            String peran = InputHandler.validasiString(data[8]);
            int vonisHukuman = InputHandler.validasiInt(data[9]);
            double vonisDenda = InputHandler.validasiDouble(data[10]);
            String hakim = InputHandler.validasiString(data[11]);

            // 2. Validasi Logika Bisnis (Batasan nilai sesuai panduan)
            if (berat <= 0) {
                throw new IllegalArgumentException("Berat barang bukti harus lebih dari 0 gram.");
            }
            if (umur <= 0) {
                throw new IllegalArgumentException("Umur terdakwa tidak valid.");
            }
            if (vonisHukuman < 0 || vonisDenda < 0) {
                throw new IllegalArgumentException("Vonis hukuman dan denda tidak boleh negatif.");
            }

            // 3. Instansiasi Objek Putusan (Controller yang membuat objek, BUKAN Model)
            // Catatan: Ini akan error dulu sampai Model Engineer membuat constructor parameterized di Putusan.java
            Putusan putusanBaru = new Putusan(nomor, pengadilan, tanggal, nama, umur, jenis, berat, pasal, peran, vonisHukuman, vonisDenda, hakim);

            // 4. Simpan ke Repository (Model)
            repository.simpan(putusanBaru);
            return true;

        } catch (NumberFormatException e) {
            System.err.println("Error Format: " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            System.err.println("Error Validasi: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println("Error Sistem: " + e.getMessage());
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

    /**
     * Fitur Bonus: Mengurutkan daftar putusan
     * @param kriteria "vonis" untuk hukuman, "denda" untuk denda
     * @param ascending true untuk terkecil ke terbesar, false sebaliknya
     */
    public ArrayList<Putusan> urutkanPutusan(String kriteria, boolean ascending) {
        // Ambil semua data dari repository
        ArrayList<Putusan> daftar = repository.getDaftarSemua();

        // Gunakan class PengurutPutusan yang sudah kita buat
        PengurutPutusan pengurut = new PengurutPutusan(kriteria);
        Collections.sort(daftar, pengurut);

        // Jika user minta descending (terbesar ke terkecil), balik urutannya
        if (!ascending) {
            Collections.reverse(daftar);
        }

        return daftar;
    }
}
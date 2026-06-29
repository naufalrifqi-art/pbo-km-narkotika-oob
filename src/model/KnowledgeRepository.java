package model;

import java.util.ArrayList;

public class KnowledgeRepository {
    // Skeleton method - akan diisi logika CRUD sebenarnya nanti

    public void simpan(Putusan putusan) {
    }

    public Putusan cariByNomor(String nomor) {
        return null;
    }

    public ArrayList<Putusan> cariByNama(String nama) {
        return new ArrayList<>();
    }

    public ArrayList<Putusan> filterByJenis(String jenis) {
        return new ArrayList<>();
    }

    public ArrayList<Putusan> filterByPengadilan(String pengadilan) {
        return new ArrayList<>();
    }

    public boolean hapus(String nomorPerkara) {
        return false;
    }

    public ArrayList<Putusan> getDaftarSemua() {
        return new ArrayList<>();
    }
}
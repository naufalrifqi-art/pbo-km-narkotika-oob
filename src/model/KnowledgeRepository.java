package model;

import java.util.ArrayList;

public class KnowledgeRepository{
    private ArrayList<Putusan>daftarPutusan;

    public KnowledgeRepository(){
        this.daftarPutusan = new ArrayList<>();
    }

    public void simpan(Putusan putusan) {
        if (putusan != null) {
            daftarPutusan.add(putusan);
        }
    }

    public Putusan cariByNomor(String nomor) {
        if (nomor == null) return null; // Mencegah error
        for (Putusan p : daftarPutusan) {
            if (p.getNomorPerkara() != null && p.getNomorPerkara().equalsIgnoreCase(nomor)) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Putusan>cariByNama(String nama){
        ArrayList<Putusan>hasil = new ArrayList<>();
        for (Putusan p:daftarPutusan) {
            if (p.getNamaTerdakwa().toLowerCase().contains(nama.toLowerCase())) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    public ArrayList<Putusan>filterByJenis(String jenis) {
        ArrayList<Putusan>hasil = new ArrayList<>();
        for (Putusan p:daftarPutusan) {
            if (p.getJenisNarkotika().equalsIgnoreCase(jenis)) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    public ArrayList<Putusan>filterByPengadilan(String pengadilan) {
        ArrayList<Putusan>hasil=new ArrayList<>();
        for (Putusan p:daftarPutusan) {
            if (p.getPengadilan().toLowerCase().contains(pengadilan.toLowerCase())) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    public boolean hapus(String nomorPerkara){
        Putusan p=cariByNomor(nomorPerkara);
        if (p!=null) {
            daftarPutusan.remove(p);
            return true;
        }
        return false;
    }

    public ArrayList<Putusan>getDaftarSemua() {
        return new ArrayList<>(daftarPutusan);
    }

    public int getTotalData(){
        return daftarPutusan.size();
    }
}
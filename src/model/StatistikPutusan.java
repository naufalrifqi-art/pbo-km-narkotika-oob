package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatistikPutusan{
    private int totalPutusan;
    private double rataRataVonis;
    private double rataRataDenda;
    private String jenisNarkotikaTerbanyak;
    private String distribusiPeran;

    private ArrayList<Putusan>data;

    public StatistikPutusan(ArrayList<Putusan>daftar){
        this.data=daftar;
        hitungSemua();
    }

    public void hitungSemua(){
        this.totalPutusan=data.size();
        if (totalPutusan==0){
            this.rataRataVonis=0;
            this.rataRataDenda=0;
            this.jenisNarkotikaTerbanyak="Tidak ada data";
            this.distribusiPeran="Tidak ada data";
            return;
        }

        double totalVonis=0;
        double totalDenda=0;
        HashMap<String,Integer>petaNarkotika=new HashMap<>();
        HashMap<String,Integer>petaPeran=new HashMap<>();

        for (Putusan p:data){
            totalVonis+=p.getVonisHukuman();
            totalDenda+=p.getVonisDenda();

            String jenis=p.getJenisNarkotika();
            petaNarkotika.put(jenis,petaNarkotika.getOrDefault(jenis,0)+1);

            String peran=p.getPeranTerdakwa();
            petaPeran.put(peran,petaPeran.getOrDefault(peran,0)+1);
        }

        this.rataRataVonis=totalVonis/totalPutusan;
        this.rataRataDenda=totalDenda/totalPutusan;

        String maksNarkotika="";
        int hitungMaksNarkotika=-1;
        for (Map.Entry<String,Integer>entry:petaNarkotika.entrySet()){
            if (entry.getValue()>hitungMaksNarkotika){
                hitungMaksNarkotika=entry.getValue();
                maksNarkotika=entry.getKey();
            }
        }
        this.jenisNarkotikaTerbanyak=maksNarkotika+" ("+hitungMaksNarkotika+" kasus)";

        StringBuilder sbPeran=new StringBuilder();
        for (Map.Entry<String,Integer>entry:petaPeran.entrySet()){
            sbPeran.append(entry.getKey()).append(": ").append(entry.getValue()).append(" | ");
        }
        this.distribusiPeran=sbPeran.toString();
    }

    public void tampilkanLaporan(){
        System.out.println("\n================= LAPORAN STATISTIK KMS =================");
        System.out.println("Total Kasus Putusan       : " + totalPutusan);
        System.out.printf("Rata-rata Hukuman Penjara : %.2f Bulan\n", rataRataVonis);
        System.out.printf("Rata-rata Nilai Denda     : Rp %,.2f\n", rataRataDenda);
        System.out.println("Jenis Narkotika Terbanyak : " + jenisNarkotikaTerbanyak);
        System.out.println("Distribusi Peran Terdakwa : " + distribusiPeran);
        System.out.println("=========================================================");
    }

    public int getTotalPutusan(){
        return totalPutusan;
    }
    public double getRataRataVonis(){
        return rataRataVonis;
    }
    public double getRataRataDenda(){
        return rataRataDenda;
    }
    public String getJenisNarkotikaTerbanyak(){
        return jenisNarkotikaTerbanyak;
    }
    public String getDistribusiPeran(){
        return distribusiPeran;
    }
}
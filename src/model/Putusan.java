package model;

public class Putusan extends DokumenPengadilan {
    private String namaTerdakwa;
    private int umurTerdakwa;
    private String jenisNarkotika;
    private String nomorPerkara;
    private String pengadilan;
    private String tanggalPutusan;
    private double beratBarangBukti;
    private String pasalDilanggar;
    private String peranTerdakwa;
    private int vonisHukuman;
    private double vonisDenda;
    private String namaHakim;

    private static int jumlahDibuat=0;

    public Putusan() {
        super("Belum Ada","Belum Ada","Belum Ada");
        this.namaTerdakwa="Belum Ada";
        this.jenisNarkotika="Belum Ada";
        this.pasalDilanggar="Belum Ada";
        this.peranTerdakwa="Belum Ada";
        this.namaHakim="Belum Ada";
        jumlahDibuat++;
    }

    public Putusan(String nomorPerkara,String pengadilan,String tanggalPutusan,String namaTerdakwa,int umurTerdakwa,String jenisNarkotika,double beratBarangBukti,String pasalDilanggar,String peranTerdakwa,int vonisHukuman,double vonisDenda,String namaHakim) {
        super(nomorPerkara,pengadilan,tanggalPutusan);
        this.namaTerdakwa=namaTerdakwa;
        this.umurTerdakwa=umurTerdakwa;
        this.jenisNarkotika=jenisNarkotika;
        this.beratBarangBukti=beratBarangBukti;
        this.pasalDilanggar=pasalDilanggar;
        this.peranTerdakwa=peranTerdakwa;
        this.vonisHukuman=vonisHukuman;
        this.vonisDenda=vonisDenda;
        this.namaHakim=namaHakim;
        jumlahDibuat++;
    }

    public static int getJumlahDibuat() {
        return jumlahDibuat;
    }

    @Override
    public void tampilkan() {
        System.out.println("["+nomorPerkara+"] Terdakwa: "+namaTerdakwa+" | Vonis: "+vonisHukuman+" Bulan");
    }

    public void tampilkan(boolean detail) {
        if (detail){
            System.out.println("======= DETAIL PUTUSAN NARKOTIKA =======");
            System.out.println("Nomor Perkara : "+nomorPerkara);
            System.out.println("Pengadilan    : "+pengadilan);
            System.out.println("Tanggal       : "+tanggalPutusan);
            System.out.println("Terdakwa      : "+namaTerdakwa+" ("+umurTerdakwa+" Tahun)");
            System.out.println("Barang Bukti  : "+jenisNarkotika+" ("+beratBarangBukti+" gram)");
            System.out.println("Pasal / Peran : "+pasalDilanggar+" / "+peranTerdakwa);
            System.out.println("Vonis Hukum   : "+vonisHukuman+" Bulan Penjara");
            System.out.println("Vonis Denda   : Rp "+vonisDenda);
            System.out.println("Hakim Ketua   : "+namaHakim);
            System.out.println("Kategori Kasus: "+getKategoriHukuman());
            System.out.println("========================================");
        } else {
            tampilkan();
        }
    }

    @Override
    public String getKategoriHukuman() {
        if (vonisHukuman<48) {
            return "Ringan";
        } else if (vonisHukuman<=120) {
            return "Sedang";
        } else {
            return "Berat";
        }
    }

    @Override
    public String toString() {
        return nomorPerkara+" | "+namaTerdakwa+" | "+jenisNarkotika+" | "+vonisHukuman+" Bulan";
    }

    public String getNomorPerkara(){
        return nomorPerkara;
    }
    public void setNomorPerkara(String nomorPerkara) {
        this.nomorPerkara = nomorPerkara;
    }

    public String getPengadilan(){
        return pengadilan;
    }
    public void setPengadilan(String pengadilan) {
        this.pengadilan = pengadilan;
    }

    public String getTanggalPutusan(){
        return tanggalPutusan;
    }
    public void setTanggalPutusan(String tanggalPutusan) {
        this.tanggalPutusan = tanggalPutusan;
    }

    public String getNamaTerdakwa(){
        return namaTerdakwa;
    }
    public void setNamaTerdakwa(String namaTerdakwa) {
        this.namaTerdakwa = namaTerdakwa;
    }

    public int getUmurTerdakwa(){
        return umurTerdakwa;
    }
    public void setUmurTerdakwa(int umurTerdakwa) {
        this.umurTerdakwa = umurTerdakwa;
    }

    public String getJenisNarkotika(){
        return jenisNarkotika;
    }
    public void setJenisNarkotika(String jenisNarkotika) {
        this.jenisNarkotika = jenisNarkotika;
    }

    public double getBeratBarangBukti(){
        return beratBarangBukti;
    }
    public void setBeratBarangBukti(double beratBarangBukti) {
        this.beratBarangBukti = beratBarangBukti;
    }

    public String getPasalDilanggar(){
        return pasalDilanggar;
    }
    public void setPasalDilanggar(String pasalDilanggar) {
        this.pasalDilanggar = pasalDilanggar;
    }

    public String getPeranTerdakwa(){
        return peranTerdakwa;
    }
    public void setPeranTerdakwa(String peranTerdakwa) {
        this.peranTerdakwa = peranTerdakwa;
    }

    public int getVonisHukuman(){
        return vonisHukuman;
    }
    public void setVonisHukuman(int vonisHukuman) {
        this.vonisHukuman = vonisHukuman;
    }

    public double getVonisDenda(){
        return vonisDenda;
    }
    public void setVonisDenda(double vonisDenda) {
        this.vonisDenda = vonisDenda;
    }

    public String getNamaHakim(){
        return namaHakim;
    }
    public void setNamaHakim(String namaHakim) {
        this.namaHakim = namaHakim;
    }
}
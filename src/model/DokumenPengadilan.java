package model;

public abstract class DokumenPengadilan implements DokumenHukum {
    protected String nomorPerkara;
    protected String pengadilan;
    protected String tanggalPutusan;

    public DokumenPengadilan(String nomorPerkara, String pengadilan, String tanggalPutaran){
        this.nomorPerkara=nomorPerkara;
        this.pengadilan=pengadilan;
        this.tanggalPutusan=tanggalPutusan;
    }

    public abstract void tampilkan();
}
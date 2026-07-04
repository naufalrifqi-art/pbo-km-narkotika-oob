package util;

import controller.KnowledgeController;
import model.Putusan;
import java.io.File;

/**
 * Class untuk memuat data dari folder PDF dan hard-coded.
 */
public class DataGenerator {
    private static final String PDF_FOLDER = "pdf-putusan";

    public static void muatDataSampel(KnowledgeController controller) {
        File folder = new File(PDF_FOLDER);

        // Cek apakah folder PDF ada
        if (!folder.exists() || !folder.isDirectory()) {
            System.err.println("⚠ Folder '" + PDF_FOLDER + "' tidak ditemukan! Menggunakan data hard-coded.");
            muatDataHardcoded(controller);
            return;
        }

        // Ambil semua file PDF
        File[] pdfFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));

        if (pdfFiles == null || pdfFiles.length == 0) {
            System.err.println("⚠ Tidak ada file PDF di folder '" + PDF_FOLDER + "'! Menggunakan data hard-coded.");
            muatDataHardcoded(controller);
            return;
        }

        System.out.println("📂 Menemukan " + pdfFiles.length + " file PDF");
        System.out.println("🔄 Memulai parsing PDF...\n");

        PDFParser parser = new PDFParser(); // Inisialisasi Parser
        int berhasil = 0;
        int gagal = 0;
        int batasMaks = 50; // Sesuai panduan minimal 50 data

        // Loop melalui setiap file PDF
        for (int i = 0; i < pdfFiles.length && berhasil < batasMaks; i++) {
            File file = pdfFiles[i];
            try {
                // Panggil method baru yang mengembalikan objek Putusan
                Putusan putusan = parser.prosesPdfKeObjek(file.getAbsolutePath());

                if (putusan != null) {
                    // Validasi sederhana: pastikan data penting tidak "Tidak Ditemukan"
                    if (!putusan.getNomorPerkara().equals("Tidak Ditemukan") &&
                            !putusan.getNamaTerdakwa().contains("Tidak Terbaca")) {

                        // ⭐ PENTING: Simpan LANGSUNG ke Repository (bypass validasi String[] di Controller)
                        // Ini mencegah crash jika ada field angka yang terekstrak sebagai "Tidak Ditemukan"
                        controller.getRepository().simpan(putusan);

                        berhasil++;
                        System.out.println("  [" + berhasil + "] ✓ " + file.getName() + " | " + putusan.getNamaTerdakwa());
                    } else {
                        gagal++;
                        System.out.println("  [✗] Data tidak lengkap: " + file.getName());
                    }
                } else {
                    gagal++;
                    System.out.println("  [✗] Gagal parsing: " + file.getName());
                }
            } catch (Exception e) {
                gagal++;
                System.err.println("  [✗] Error: " + file.getName() + " - " + e.getMessage());
            }
        }

        System.out.println("\n========================================");
        System.out.println("✅ SELESAI PARSING PDF");
        System.out.println("   Berhasil: " + berhasil + " data");
        System.out.println("   Gagal: " + gagal + " data");
        System.out.println("========================================\n");

        // Fallback jika data dari PDF kurang dari 50
        if (berhasil < 50) {
            System.out.println("⚠ Data dari PDF hanya " + berhasil + ". Menambah data hard-coded untuk melengkapi...");
            tambahDataTambahan(controller, 50 - berhasil);
        }
    }

    /**
     * Menambah data hard-coded jika data PDF kurang dari 50
     */
    private static void tambahDataTambahan(KnowledgeController controller, int jumlah) {
        String[][] dataTambahan = {
                {"2440/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-08-10", "Ahmad Fauzi", "35", "Sabu-sabu", "1.50", "Pasal 112(1)", "Pengguna", "36", "500000000", "Ferdinand Marcus Leander"},
                {"2445/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-08-15", "Budi Santoso", "28", "Ganja", "10.20", "Pasal 112(1)", "Pengguna", "42", "500000000", "Hakim Ketua"},
                {"2450/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-08-20", "Siti Aminah", "24", "Ekstasi", "2.40", "Pasal 114(1)", "Pengedar", "72", "1000000000", "NI Putu Sri Indayani"},
                {"2460/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-09-01", "Dewi Lestari", "30", "Sabu-sabu", "0.55", "Pasal 127(1)", "Pengguna", "24", "200000000", "Toniwidjaya"},
                {"2470/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-09-10", "Rudi Hermawan", "40", "Sabu-sabu", "5.00", "Pasal 114(1)", "Pengedar", "108", "1500000000", "Ferdinand Marcus Leander"},
                {"2480/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-09-20", "Ani Wijaya", "26", "Ganja", "3.50", "Pasal 112(1)", "Pengguna", "36", "500000000", "Hakim Anggota"},
                {"2490/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-10-01", "Joko Susilo", "33", "Sabu-sabu", "12.50", "Pasal 114(2)", "Bandar", "200", "4000000000", "NI Putu Sri Indayani"},
                {"2500/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-10-10", "Maya Sari", "22", "Ekstasi", "1.10", "Pasal 114(1)", "Kurir", "54", "1000000000", "Toniwidjaya"},
                {"2510/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-10-20", "Doni Setiawan", "29", "Sabu-sabu", "0.80", "Pasal 112(1)", "Pengguna", "48", "500000000", "Ferdinand Marcus Leander"},
                {"2520/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-11-01", "Rina Marlina", "27", "Sabu-sabu", "2.20", "Pasal 114(1)", "Pengedar", "84", "1000000000", "Hakim Ketua"}
        };

        int count = 0;
        for (String[] data : dataTambahan) {
            if (count >= jumlah) break;
            controller.tambahPutusan(data); // Pakai method controller karena data hard-coded sudah pasti valid
            count++;
        }
        System.out.println("✓ Menambah " + count + " data hard-coded");
    }

    /**
     * Fallback total jika folder PDF tidak ditemukan
     */
    private static void muatDataHardcoded(KnowledgeController controller) {
        String[][] dataPutusan = {
                { "2528/Pid.Sus/2023/PN Sby",  "PN Surabaya",  "2024-01-15",  "Bagus Dwi Hartaning Budi",  "20",  "Sabu-sabu",  "0.074",  "Pasal 114(1)",  "Pengedar",  "78",  "1000000000",  "NI Putu Sri Indayani"},
                { "2536/Pid.Sus/2023/PN Sby",  "PN Surabaya",  "2023-12-10",  "Abdul Gafur Bin Maisun Anwar",  "35",  "Sabu-sabu",  "1171.06",  "Pasal 114(2)",  "Bandar",  "240",  "5000000000",  "Hakim Ketua"},
                { "2439/Pid.Sus/2023/PN Sby",  "PN Surabaya",  "2023-11-20",  "Moh. Hanik Faisol",  "32",  "Sabu-sabu",  "100.36",  "Pasal 114(2)",  "Kurir",  "120",  "2000000000",  "Toniwidjaya"},
                { "2526/Pid.Sus/2023/PN Sby",  "PN Surabaya",  "2023-09-15",  "Rudi Nugraha",  "28",  "Tembakau Gorilla",  "4.661",  "Pasal 112(1)",  "Pengguna",  "36",  "500000000",  "Ferdinand Marcus Leander"},
                { "2600/Pid.Sus/2023/PN Sby",  "PN Surabaya",  "2023-10-18",  "Bagas Dwi Julianto",  "25",  "Ganja",  "0.90",  "Pasal 112(1)",  "Pengguna",  "24",  "200000000",  "Hakim Anggota"}
        };

        for (String[] data : dataPutusan) {
            controller.tambahPutusan(data);
        }
        System.out.println("✓ Loaded " + dataPutusan.length + " hard-coded data");
    }
}
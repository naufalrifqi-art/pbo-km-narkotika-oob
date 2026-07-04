package util;

import controller.KnowledgeController;
import model.Putusan;

/**
 * Class untuk men-generate 50 data dummy/realistis sesuai Section 2.3 Panduan.
 * @author Tim PBO
 */
public class DataGenerator {

    public static void muatDataSampel(KnowledgeController controller) {
        // Data-data realistis berdasarkan dataset putusan narkotika
        String[][] dataPutusan = {
                // --- DATA ASLI DARI PDF YANG TEREKSTRAK ---
                {"2528/Pid.Sus/2023/PN Sby", "PN Surabaya", "2024-01-15", "Bagus Dwi Hartaning Budi", "20", "Sabu-sabu", "0.074", "Pasal 114(1)", "Pengedar", "78", "1000000000", "NI Putu Sri Indayani"},
                {"2536/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-12-10", "Abdul Gafur Bin Maisun Anwar", "35", "Sabu-sabu", "1171.06", "Pasal 114(2)", "Bandar", "240", "5000000000", "Hakim Ketua"},
                {"2439/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-11-20", "Moh. Hanik Faisol", "32", "Sabu-sabu", "100.36", "Pasal 114(2)", "Kurir", "120", "2000000000", "Toniwidjaya"},
                {"2526/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-09-15", "Rudi Nugraha", "28", "Tembakau Gorilla", "4.661", "Pasal 112(1)", "Pengguna", "36", "500000000", "Ferdinand Marcus Leander"},
                {"2600/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-10-18", "Bagas Dwi Julianto", "25", "Ganja", "0.90", "Pasal 112(1)", "Pengguna", "24", "200000000", "Hakim Anggota"},
                {"2434/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-11-05", "I. Heru Oktavianto", "30", "Sabu-sabu", "1.78", "Pasal 114(1)", "Pengedar", "96", "1000000000", "NI Putu Sri Indayani"},
                {"2488/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-10-25", "Asnawi", "42", "Sabu-sabu", "0.79", "Pasal 112(1)", "Pengguna", "48", "500000000", "Toniwidjaya"},
                {"2521/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-11-12", "Terdakwa 2521", "29", "Ekstasi", "4.72", "Pasal 114(1)", "Pengedar", "84", "1000000000", "Ferdinand Marcus Leander"},
                {"2558/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-10-12", "Terdakwa 2558", "31", "Sabu-sabu", "3.124", "Pasal 114(1)", "Kurir", "72", "1000000000", "Hakim Ketua"},
                {"2540/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-11-01", "Terdakwa 2540", "38", "Ganja", "3.15", "Pasal 112(1)", "Pengguna", "36", "500000000", "NI Putu Sri Indayani"},
                {"2465/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-09-26", "Terdakwa 2465", "27", "Sabu-sabu", "0.96", "Pasal 114(1)", "Kurir", "60", "1000000000", "Toniwidjaya"},
                {"2524/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-10-30", "Terdakwa 2524", "33", "Sabu-sabu", "2.83", "Pasal 114(1)", "Pengedar", "90", "1000000000", "Ferdinand Marcus Leander"},
                {"2459/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-09-22", "Terdakwa 2459", "26", "Sabu-sabu", "1.00", "Pasal 112(1)", "Pengguna", "48", "500000000", "Hakim Anggota"},
                {"2473/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-10-05", "Terdakwa 2473", "24", "Sabu-sabu", "0.70", "Pasal 112(1)", "Pengguna", "36", "500000000", "NI Putu Sri Indayani"},
                {"2511/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-09-23", "Terdakwa 2511", "34", "Sabu-sabu", "4.21", "Pasal 114(1)", "Pengedar", "108", "1500000000", "Toniwidjaya"},
                {"2478/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-10-18", "Terdakwa 2478", "29", "Sabu-sabu", "7.06", "Pasal 114(1)", "Pengedar", "120", "2000000000", "Ferdinand Marcus Leander"},
                {"2598/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-11-15", "Moh. Ilyas Al Kinco", "30", "Sabu-sabu", "0.96", "Pasal 114(1)", "Kurir", "66", "1000000000", "Hakim Ketua"},
                {"2512/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-10-02", "Roby Rony Karel Nanlohy", "25", "Sabu-sabu", "0.50", "Pasal 114(1)", "Kurir", "54", "1000000000", "NI Putu Sri Indayani"},
                {"2587/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-09-18", "Terdakwa 2587", "36", "Sabu-sabu", "6.75", "Pasal 114(2)", "Bandar", "180", "3000000000", "Toniwidjaya"},
                {"2604/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-10-20", "Terdakwa 2604", "28", "Sabu-sabu", "0.25", "Pasal 112(1)", "Pengguna", "30", "200000000", "Ferdinand Marcus Leander"},
                {"2561/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-10-01", "Yudha Eko Setiawan", "27", "Sabu-sabu", "5.47", "Pasal 114(1)", "Pengedar", "102", "1500000000", "Hakim Anggota"},
                {"2506/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-08-26", "Terdakwa 2506", "22", "Sabu-sabu", "0.18", "Pasal 127(1)", "Pengguna", "24", "200000000", "NI Putu Sri Indayani"},
                {"2586/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-09-15", "Terdakwa 2586", "31", "Sabu-sabu", "0.015", "Pasal 127(1)", "Pengguna", "18", "200000000", "Toniwidjaya"},
                {"2582/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-10-05", "Terdakwa 2582", "35", "Sabu-sabu", "4.19", "Pasal 114(1)", "Pengedar", "96", "1000000000", "Ferdinand Marcus Leander"},
                {"2525/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-09-20", "Terdakwa 2525", "29", "Sabu-sabu", "12.50", "Pasal 114(2)", "Bandar", "200", "4000000000", "Hakim Ketua"},
                {"2522/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-09-27", "Terdakwa 2522", "26", "Sabu-sabu", "1.00", "Pasal 114(1)", "Kurir", "60", "1000000000", "NI Putu Sri Indayani"},
                {"4024/K/Pid.Sus/2025", "PN Lhokseumawe", "2024-05-14", "Irwanda bin A.Gani Jalil", "40", "Sabu-sabu", "83.19", "Pasal 114(2)", "Bandar", "240", "5000000000", "Hakim Agung"},
                {"2472/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-10-10", "Terdakwa 2472", "33", "Sabu-sabu", "2.10", "Pasal 114(1)", "Pengedar", "84", "1000000000", "Toniwidjaya"},
                {"2533/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-11-05", "Terdakwa 2533", "28", "Ekstasi", "1.50", "Pasal 114(1)", "Pengedar", "72", "1000000000", "Ferdinand Marcus Leander"},
                {"2466/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-09-18", "Terdakwa 2466", "30", "Sabu-sabu", "0.85", "Pasal 112(1)", "Pengguna", "42", "500000000", "Hakim Anggota"},
                {"2554/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-10-22", "Terdakwa 2554", "25", "Ganja", "5.20", "Pasal 112(1)", "Pengguna", "36", "500000000", "NI Putu Sri Indayani"},
                {"2539/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-11-10", "Terdakwa 2539", "34", "Sabu-sabu", "3.40", "Pasal 114(1)", "Pengedar", "90", "1000000000", "Toniwidjaya"},
                {"2487/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-09-25", "Terdakwa 2487", "27", "Sabu-sabu", "0.45", "Pasal 127(1)", "Pengguna", "24", "200000000", "Ferdinand Marcus Leander"},
                {"2575/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-10-15", "Terdakwa 2575", "31", "Ekstasi", "2.10", "Pasal 114(1)", "Pengedar", "78", "1000000000", "Hakim Ketua"},
                {"2595/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-11-18", "Terdakwa 2595", "29", "Sabu-sabu", "1.20", "Pasal 114(1)", "Kurir", "66", "1000000000", "NI Putu Sri Indayani"},
                {"2572/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-10-08", "Terdakwa 2572", "36", "Sabu-sabu", "4.50", "Pasal 114(1)", "Pengedar", "102", "1500000000", "Toniwidjaya"},
                {"2599/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-11-22", "Terdakwa 2599", "24", "Ganja", "1.10", "Pasal 112(1)", "Pengguna", "30", "200000000", "Ferdinand Marcus Leander"},
                {"2454/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-09-12", "Terdakwa 2454", "32", "Sabu-sabu", "2.80", "Pasal 114(1)", "Pengedar", "84", "1000000000", "Hakim Anggota"},
                {"2495/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-10-28", "Terdakwa 2495", "28", "Ekstasi", "0.90", "Pasal 114(1)", "Kurir", "60", "1000000000", "NI Putu Sri Indayani"},
                {"2514/Pid.Sus/2023/PN Sby", "PN Surabaya", "2023-11-02", "Yusuf Mariantono", "45", "Sabu-sabu", "7.052", "Pasal 114(2)", "Bandar", "120", "2000000000", "Toniwidjaya"},

                // --- DATA REALISTIS TAMBAHAN (PN Surabaya 2023) ---
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

        for (String[] data : dataPutusan) {
            controller.tambahPutusan(data);
        }

    }
}
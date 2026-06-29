package util;

import java.util.Scanner;

public class InputHandler {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Validasi input integer dengan retry
     */
    /**
     * Validasi input integer
     * @throws NumberFormatException jika bukan angka
     * @throws IllegalArgumentException jika kosong
     */
    public static int validasiInt(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input tidak boleh kosong.");
        }
        return Integer.parseInt(input.trim());
    }

    /**
     * Validasi input double
     * @throws NumberFormatException jika bukan angka desimal
     * @throws IllegalArgumentException jika kosong
     */
    public static double validasiDouble(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input tidak boleh kosong.");
        }
        return Double.parseDouble(input.trim());
    }

    /**
     * Validasi input string (tidak boleh kosong)
     * @throws IllegalArgumentException jika kosong
     */
    public static String validasiString(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input string tidak boleh kosong.");
        }
        return input.trim();
    }

    /**
     * Validasi input pilihan menu (min-max)
     */
//    public static int validasiPilihan(String prompt, int min, int max, Scanner sc) {
//        int pilihan = 0;
//        boolean valid = false;
//
//        while (!valid) {
//            pilihan = validasiInt(prompt, sc);
//            if (pilihan >= min && pilihan <= max) {
//                valid = true;
//            } else {
//                System.out.println("Error: Pilihan harus antara " + min + " - " + max);
//            }
//        }
//        return pilihan;
//    }

}

package util;

import java.util.Scanner;

public class InputHandler {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Validasi input integer dengan retry
     */
    public static int validasiInt(String prompt, Scanner sc) {
        int value = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(sc.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Input harus berupa angka!");
            }
        }
        return value;
    }

    /**
     * Validasi input double dengan retry
     */
    public static double validasiDouble(String prompt, Scanner sc) {
        double value = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print(prompt);
                value = Double.parseDouble(sc.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Input harus berupa angka desimal!");
            }
        }
        return value;
    }

    /**
     * Validasi input string (tidak boleh kosong)
     */
    public static String validasiString(String prompt, Scanner sc) {
        String value = "";
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                valid = true;
            } else {
                System.out.println("Error: Input tidak boleh kosong!");
            }
        }
        return value;
    }

    /**
     * Validasi input pilihan menu (min-max)
     */
    public static int validasiPilihan(String prompt, int min, int max, Scanner sc) {
        int pilihan = 0;
        boolean valid = false;

        while (!valid) {
            pilihan = validasiInt(prompt, sc);
            if (pilihan >= min && pilihan <= max) {
                valid = true;
            } else {
                System.out.println("Error: Pilihan harus antara " + min + " - " + max);
            }
        }
        return pilihan;
    }

}

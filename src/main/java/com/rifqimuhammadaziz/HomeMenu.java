package com.rifqimuhammadaziz;

public class HomeMenu {
    public static void showHomeMenu() {
        Utility.showHeader();

        System.out.println();
        System.out.println("-- LETAKAN FILE CSV DENGAN NAMA FILE data_sekolah.csv DI DIREKTORI BERIKUT: /Users/rifqimuhammadaziz/Documents/Work/IDSTAR/IDP/AplikasiPengolahNilai/src/main/resources");

        System.out.println();
        System.out.println("PILIH MENU");
        System.out.println("[1] GENERATE TEXT UNTUK MENAMPILKAN MODUS");
        System.out.println("[2] GENERATE TEXT UNTUK MENAMPILKAN NILAI RATA RATA / MEDIAN");
        System.out.println("[3] GENERATE KEDUA FILE");
        System.out.println("-- [0] EXIT");
        System.out.println();
    }
}

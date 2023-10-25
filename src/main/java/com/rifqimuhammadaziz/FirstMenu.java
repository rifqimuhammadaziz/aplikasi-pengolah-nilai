package com.rifqimuhammadaziz;

import java.util.Scanner;

import static com.rifqimuhammadaziz.Utility.isHomePage;

public class FirstMenu {

    public static void printModus(Scanner scanner) {
        boolean isHomePage = false;

        while (!isHomePage) {
            Utility.showHeader();
            Utility.printModus();
            System.out.println("-- BERHASIL GENERATE FILE DI /Users/rifqimuhammadaziz/Documents/Work/IDSTAR/IDP/AplikasiPengolahNilai/src/main/resources");

            isHomePage = isHomePage(scanner, isHomePage);
        }
    }
}

package com.rifqimuhammadaziz;

import java.util.Scanner;

import static com.rifqimuhammadaziz.Utility.*;

public class SecondMenu {

    public static void printModusMeanMedian(Scanner scanner) {
        boolean isHomePage = false;

        while (!isHomePage) {
            showHeader();

            printModusMedianMean();
            System.out.println("-- FILE BERHASIL GENERATE DI /Users/rifqimuhammadaziz/Documents/Work/IDSTAR/IDP/AplikasiPengolahNilai/src/main/resources");

            isHomePage = isHomePage(scanner, isHomePage);
        }
    }
}

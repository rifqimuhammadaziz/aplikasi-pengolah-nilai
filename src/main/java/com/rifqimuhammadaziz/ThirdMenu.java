package com.rifqimuhammadaziz;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.rifqimuhammadaziz.Utility.*;

public class ThirdMenu {

    public static void printAllFile(Scanner scanner) {
        boolean isHomePage = false;

        while (!isHomePage) {
            showHeader();

            ExecutorService executorService = Executors.newFixedThreadPool(2);

            executorService.submit(Utility::printModus);
            executorService.submit(Utility::printModusMedianMean);

            executorService.shutdown();
            System.out.println("-- FILE BERHASIL GENERATE DI /Users/rifqimuhammadaziz/Documents/Work/IDSTAR/IDP/AplikasiPengolahNilai/src/main/resources");

            isHomePage = isHomePage(scanner, isHomePage);
        }
    }
}

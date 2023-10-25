package com.rifqimuhammadaziz;

import java.util.Scanner;

import static com.rifqimuhammadaziz.FirstMenu.printModus;
import static com.rifqimuhammadaziz.HomeMenu.showHomeMenu;
import static com.rifqimuhammadaziz.SecondMenu.printModusMeanMedian;
import static com.rifqimuhammadaziz.ThirdMenu.printAllFile;

public class Main {
    public static void main(String[] args) {
        System.out.println("[===== APLIKASI PENGOLAH NILAI =====]");

        Scanner scanner = new Scanner(System.in);
        boolean statusExit = false;

        showMainMenu(scanner, statusExit);
    }

    private static void showMainMenu(Scanner scanner, boolean isExit) {
        while (!isExit) {
            showHomeMenu();

            int input = scanner.nextInt();
            switch (input) {
                case 1: {
                    printModus(scanner);
                }
                case 2: {
                    printModusMeanMedian(scanner);
                }
                case 3: {
                    printAllFile(scanner);
                }
                case 0: {
                    isExit = true;
                    scanner.close();
                    break;
                }
                default:
                    System.out.println("-- MENU TIDAK TERSEDIA");
            }
        }
    }


}
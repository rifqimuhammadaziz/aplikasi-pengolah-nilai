package com.rifqimuhammadaziz;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Utility {
    private static final String FILE_PATH = "/Users/rifqimuhammadaziz/Documents/Work/IDSTAR/IDP/AplikasiPengolahNilai/src/main/resources/data_sekolah.csv";

    public static void showHeader() {
        System.out.println("[============== -- ==============]");
        System.out.println("APLIKASI PENGELOLAAN NILAI SISWA");
        System.out.println("[============== -- ==============]");
        System.out.println();
    }

    public static void showMenu() {
        System.out.println("[0] EXIT");
        System.out.println("[1] KEMBALI KE MENU UTAMA");
    }

    public static void printModus() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            Map<Integer, Integer> frequencyValueMap = new HashMap<>();
            String line;

            // mengambil nilai dari file csv
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                for (int i = 1; i < data.length; i++) {
                    int value = Integer.parseInt(data[i]);
                    frequencyValueMap.put(value, frequencyValueMap.getOrDefault(value, 0) + 1);
                }
            }

            PrintStream output = new PrintStream("/Users/rifqimuhammadaziz/Documents/Work/IDSTAR/IDP/AplikasiPengolahNilai/src/main/resources/data_modus.txt");
            PrintStream console = System.out;
            System.setOut(output);

            System.out.println("HASIL PENGOLAHAN NILAI: \n");
            System.out.println("Nilai\t\t\t| Frekuensi");
            System.out.println("Kurang dari 6\t| " + frequencyValueMap.getOrDefault(5, 0));

            for (int i = 6; i <= 10; i++) {
                System.out.println(i + "\t\t\t\t| " + frequencyValueMap.getOrDefault(i, 0));
            }

            System.setOut(console);
        } catch (FileNotFoundException e) {
            System.out.println("File does not exists");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    public static void printModusMedianMean() {
        List<Integer> allData = new ArrayList<>();
        Map<Integer, Integer> frequencyValueMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                for (int i = 1; i < data.length; i++) {
                    int value = Integer.parseInt(data[i]);
                    allData.add(value);
                    frequencyValueMap.put(value, frequencyValueMap.getOrDefault(value, 0) + 1);
                }
            }

            double mean = countMean(allData);
            double median = countMedian(allData);
            int modus = showModus(frequencyValueMap);

            // print data to text document
            PrintStream output = new PrintStream("/Users/rifqimuhammadaziz/Documents/Work/IDSTAR/IDP/AplikasiPengolahNilai/src/main/resources/data_modus_median_mean.txt");
            PrintStream console = System.out;
            System.setOut(output);

            System.out.println("Berikut Hasil Pengolahan Nilai:\n");
            System.out.println("Berikut hasil sebaran data nilai");
            System.out.println("Mean\t\t\t: " + mean);
            System.out.println("Median\t\t\t: " + median);
            System.out.println("Modus\t\t\t: " + modus);

            System.setOut(console);
        } catch (FileNotFoundException e) {
            System.out.println("File does not exists");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    private static double countMean(List<Integer> allData) {
        return allData
                .stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0);
    }

    private static double countMedian(List<Integer> allData) {
        List<Integer> sortedData = allData.stream().sorted().collect(Collectors.toList());
        int dataSize = sortedData.size();
        double median;
        if (dataSize % 2 == 0) {
            median = (sortedData.get(dataSize / 2 - 1) + sortedData.get(dataSize / 2)) / 2.0;
        } else {
            median = sortedData.get(dataSize / 2);
        }

        return median;
    }

    private static int showModus(Map<Integer, Integer> frequencyValueMap) {
        return frequencyValueMap.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getValue)
                .orElse(0);
    }

    static boolean isHomePage(Scanner scanner, boolean isHomePage) {
        Utility.showMenu();

        System.out.print("[MASUKAN ANGKA MENU] : ");
        int input = scanner.nextInt();
        switch (input) {
            case 1: {
                isHomePage = true;
                break;
            }
            case 0: {
                scanner.close();
                System.exit(0);
                break;
            }
            default:
                System.out.println("-- MENU TIDAK DITEMUKAN, PILIH 1 ATAU 0! --");
        }

        return isHomePage;
    }
}

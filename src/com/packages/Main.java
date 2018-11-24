package com.packages;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String file;
        File path;

        do {
            System.out.println("Enter the directory for search:");
            path = new File(input.nextLine());

            if (!path.isDirectory()) {
                System.out.println("Directory not found!");
            }

        } while (!path.isDirectory());

        System.out.println("Enter the file's name for search: ");
        file = input.nextLine();

        searchFile(path, file);
    }

    private static void searchFile(File topDirectory, String file) {
        File[] matches = topDirectory.listFiles();
        for (File entry : matches) {
            if (entry.isDirectory()) {
                searchFile(entry, file);
            }

            if (entry.getName().toLowerCase().equals(file.toLowerCase())) {
                System.out.println(entry.getAbsolutePath());
            }
        }
    }
}
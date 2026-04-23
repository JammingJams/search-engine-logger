package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserInterfaceApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean userInProgram = true;
        logUserLaunch();

        System.out.println("Welcome user to search.net!");
        System.out.println("(S) Search the web\n(X) Exit the program");
        System.out.print("Type your answer here!: ");

        while (userInProgram) {
            String userInput = sc.nextLine().replaceAll("\\s+","").toUpperCase().trim();
            switch (userInput) {
                case ("S") -> {
                    System.out.println("Type anything you want to search");
                    System.out.print("search: ");
                    logUser();
                    System.out.print("Type S or X: ");
                }
                case ("X") -> {System.out.println("Have a good day!"); userInProgram = false; logUserExit();}
                default -> System.out.println("Invalid input type 'S' -> search or type 'X' -> exit: ");
            }

        }

    }

    public static void logUser() {
        Scanner sc = new Scanner(System.in);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/log.txt", true))) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
            LocalTime currentTime = LocalTime.parse(LocalTime.now().format(formatter));
            LocalDate currentDate = LocalDate.now();
            String userInput = sc.nextLine().replaceAll("\\s+","").trim();
            String userLog = currentDate + "|" + currentTime + "|" + "user search: " + userInput;

            bufferedWriter.write(userLog);
            bufferedWriter.newLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void logUserLaunch() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/log.txt", true))) {

            LocalTime currentTime = LocalTime.parse(LocalTime.now().format(formatter));
            LocalDate currentDate = LocalDate.now();

            String userLog = currentDate + "|" + currentTime + "|" + "user launch";

            bufferedWriter.write(userLog);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void logUserExit() {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/log.txt", true))) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
            LocalTime currentTime = LocalTime.parse(LocalTime.now().format(formatter));
            LocalDate currentDate = LocalDate.now();

            String userLog = currentDate + "|" + currentTime + "|" + "user exit";

            bufferedWriter.write(userLog);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        int totalSeats = rows * seats;
        System.out.println("Total income:");

        if (totalSeats <= 60) {
            System.out.println("$" + totalSeats * 10);
        } else {
            if (rows % 2 == 0) {
                System.out.println("$" + totalSeats * 9);
            } else {
                int frontRows = rows / 2 * seats * 10;
                int backRows = (rows / 2 + 1) * seats * 8;
                System.out.println("$" + (frontRows + backRows));
            }
        }
    }
}
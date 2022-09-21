import java.util.*;

public class Cinema {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        // CinemaSize
        cinema.askCinemaSize();
    }
    Scanner scanner = new Scanner(System.in);
    int rows = 0;
    int seats = 0;
    int row = 0;
    int seat = 0;
    int option = 0;

    public void askCinemaSize() {
        System.out.print("Enter the number of rows:\n> ");
        rows = scanner.nextInt();

        System.out.print("Enter the number of seats in each row:\n> ");
        seats = scanner.nextInt();

        String[][] array = new String[rows + 1][seats + 1];

        createCinema(array);
        chooseOption(array);
    }

    public void createCinema(String[][] array) {
        // giving values to array, only empty seats
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                array[i][j] = "S ";
            }
        }
    }

    public void showSeats(String[][] array) {
        // seats taken
        if (seat > 0) {
            array[row][seat] = "B ";
        }

        // printing array to console
        System.out.print("Cinema:\n ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(" " + i);
        }
        System.out.println("");

        int count = 1;
        for (int i = 1; i < array.length; i++) {
            System.out.print(count + " ");
            for (int j = 1; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            count++;
            System.out.println("");
        }
        chooseOption(array);
    }

    public void buyTicket(String[][] array) {

        int ticketPrice = 0;

        System.out.print("Enter a row number:\n> ");
        row = scanner.nextInt();

        System.out.print("Enter a seat number in that row:\n> ");
        seat = scanner.nextInt();

        if (rows * seats > 60) {
            int frontRows = rows / 2;

            if (row > frontRows) {
                ticketPrice = 8;
            } else {
                ticketPrice = 10;
            }
        } else {
            ticketPrice = 10;
        }
        System.out.printf("\nTicket price: $%d\n", ticketPrice);

        chooseOption(array);
    }

    public void chooseOption(String[][] array) {
        System.out.print("\n1. Show the seats\n2. Buy a ticket\n0. Exit\n> ");
        option = scanner.nextInt();
        System.out.println("");

        switch(option) {
            case 1:
                showSeats(array);
                break;
            case 2:
                buyTicket(array);
                break;
            case 0:
                return;
        }
    }
}




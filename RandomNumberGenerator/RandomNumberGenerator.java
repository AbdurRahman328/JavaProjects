package RandomNumberGenerator;

import java.util.Random;
import java.util.Scanner;

public class RandomNumberGenerator {
    public static void main(String[] args) {

        int low, high;
        int n;
        int number;

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Enter start number : ");
        low = sc.nextInt();

        System.out.println("Enter end number : ");
        high = sc.nextInt();

        System.out.println("Enter no. of numbers to be generated : ");
        n = sc.nextInt();

        System.out.println("=====================================================");
        System.out.println("Generated Random Numbers");

        for (int i = 0; i < n; i++) {
            // include low but exlude high = rand.nextInt(high-low)+low
            number = rand.nextInt((high + 1) - low) + low; // includes both high and low
            System.out.println(number);
        }
    }
}

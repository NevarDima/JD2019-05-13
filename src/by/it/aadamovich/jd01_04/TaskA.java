package by.it.aadamovich.jd01_04;

import java.util.Scanner;

public class TaskA {

    private static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                int res = i * j;
                System.out.printf("%1d*%1d=%-2d ", i, j, res);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstElem = array[0];
        double lastElem = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);

        for (int i = 0; i < array.length; i++) {
            if (array[i] == firstElem) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == lastElem) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        buildOneDimArray(sc.nextLine());

    }
}
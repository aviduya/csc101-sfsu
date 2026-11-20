import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BeanMachine {

    public static void main() {
        int ballAmount;
        int slotAmount;

        Scanner input = new Scanner(System.in);

                while (true) {
                    System.out.print("Enter the number of balls for the bean machine: ");
                    if (!input.hasNextInt()) {
                        System.out.println("Error, please enter a valid number");
                        input.nextLine();
                        continue;
                    }

                    ballAmount = input.nextInt();

                    if (ballAmount <= 0) {
                        System.out.println("Error: please enter a number greater than 0");
                        input.nextLine();
                        continue;
                    }
                    break;

                }

                while(true) {
                    System.out.print("Enter the number of slots for the bean machine: ");
                    if (!input.hasNextInt()) {
                        System.out.println("Error, please enter a valid number");
                        input.nextLine();
                        continue;
                    }
                    slotAmount = input.nextInt();

                    if (slotAmount <= 0) {
                        System.out.println("Error: please enter a number greater than 0");
                        input.nextLine();
                        continue;
                    }

                    break;


                }


        System.out.println(ballAmount);
        System.out.println(slotAmount);
        int[][] balls = new int[ballAmount][slotAmount];
        int[] slots = new int[slotAmount];
        int height = 0;

        Random rand = new Random();
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new int[slotAmount - 1];
            int rightCount = 0;

            for (int j = 0; j < balls[i].length; j++) {
                int num = rand.nextInt(0, 100);
                if (num > 50) {
                    balls[i][j] = 1;
                    rightCount++;
                    IO.print("R");
                } else {
                    balls[i][j] = 0;
                    IO.print("L");
                }

            }
            IO.print("\n");
            slots[rightCount] += 1;
        }


        for (int i = 0; i < slots.length; i++) {
            if (slots[i] > height) {
                height = slots[i];

            }
        }

        for (int i = 0; i < slots.length; i++) {
            IO.print(" " + "-" + " ");
        }
        IO.println("");
        for (int i = 0; i < slots.length; i++) {
            IO.print(" " + i + " ");
        }

        IO.println("\n\n");

        for (int i = height; i != 0; i--) {
            for (int j = 0; j < slots.length; j++) {
                if (slots[j] >= i) {
                    IO.print(" O ");
                } else {
                    IO.print("   ");
                }
            }
            IO.print("\n");

        }


        for (int i = 0; i < slots.length; i++) {
            IO.print(" " + "-" + " ");
        }
        IO.println("");
        for (int i = 0; i < slots.length; i++) {
            IO.print(" " + i + " ");
        }
    }
}

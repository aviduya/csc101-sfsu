import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class BeanMachine {
    public static void main() {
        int ballAmount = 9;
        int slotAmount = 12;


        Scanner input = new Scanner(System.in);

//        while (true) {
//            System.out.print("Enter the number of balls for the bean machine: ");
//            if (!input.hasNextInt()) {
//                System.out.println("Error, please enter a valid number");
//                input.nextLine();
//                continue;
//            }
//
//            ballAmount = input.nextInt();
//
//            if (ballAmount <= 0) {
//                System.out.println("Error: please enter a number greater than 0");
//                input.nextLine();
//                continue;
//            }
//            break;
//
//        }
//
//        while(true) {
//            System.out.print("Enter the number of slots for the bean machine: ");
//            if (!input.hasNextInt()) {
//                System.out.println("Error, please enter a valid number");
//                input.nextLine();
//                continue;
//            }
//            slotAmount = input.nextInt();
//
//            if (slotAmount <= 0) {
//                System.out.println("Error: please enter a number greater than 0");
//                input.nextLine();
//                continue;
//            }
//
//            break;
//
//
//        }
        System.out.println(ballAmount);
        System.out.println(slotAmount);
        int[][] balls = new int[ballAmount][slotAmount];

        Random rand = new Random();
        for(int i = 0; i < balls.length; i++) {

            balls[i] = new int[slotAmount];

            for(int j = 0; j < balls[i].length; j++) {

                int num = rand.nextInt(0,100);

                if (num > 50) {

                    balls[i][j] = 1;

                } else {

                    balls[i][j] = 0;
                }
            }
            IO.println(Arrays.toString(balls[i]));
        }



    }
}

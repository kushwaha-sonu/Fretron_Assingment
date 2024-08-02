package problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        ArrayList<Integer> apple_weight = new ArrayList<>();
        ArrayList<Integer> ram_apples = new ArrayList<>();
        ArrayList<Integer> sham_apples = new ArrayList<>();
        ArrayList<Integer> rahim_apples = new ArrayList<>();

        int ram_paid = 50;
        int sham_paid = 30;
        int rahim_paid = 20;
        int total_paid = ram_paid + sham_paid + rahim_paid;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter apple weight in gram (-1 to stop )");
        int weight = scanner.nextInt();

        while (weight != -1) {
            apple_weight.add(weight);
            System.out.println("Enter apple weight in gram (-1 to stop )");
            weight = scanner.nextInt();
        }

        Collections.sort(apple_weight, Collections.reverseOrder());

        int total_weight = apple_weight.stream().mapToInt(Integer::intValue).sum();

        int total_share_ram = (int) (total_weight * ((double) ram_paid / total_paid));
        int total_share_sham = (int) (total_weight * ((double) sham_paid / total_paid));
        int total_share_rahim = total_weight - total_share_ram - total_share_sham;

        // System.out.println("Total weight of apples: " + total_weight);
        // System.out.println("Ram's share:" + total_share_ram);
        // System.out.println("Sham's share:" + total_share_sham);
        // System.out.println("Rahim's share:" + total_share_rahim);

        for (int appleWeight : apple_weight) {
            if (total_share_ram >= appleWeight) {
                ram_apples.add(appleWeight);
                total_share_ram -= appleWeight;
                // System.out.println("Ram's share:" + total_share_ram);
            } else if (total_share_sham >= appleWeight) {

                sham_apples.add(appleWeight);
                total_share_sham -= appleWeight;
                // System.out.println("Sham's share:" + total_share_sham);
            } else {
                rahim_apples.add(appleWeight);
                total_share_rahim -= appleWeight;
                // System.out.println("Rahim's share:" + total_share_rahim);
            }
        }

        if (weight == -1) {

            System.out.print("Ram : ");
            for (int apple : ram_apples) {
                System.out.print(apple + " ");
            }
            System.out.println();

            System.out.print("Sham : ");
            for (int apple : sham_apples) {
                System.out.print(apple + " ");
            }
            System.out.println();

            System.out.print("Rahim : ");
            for (int apple : rahim_apples) {
                System.out.print(apple + " ");
            }
            System.out.println();

            scanner.close();

        }

    }
}
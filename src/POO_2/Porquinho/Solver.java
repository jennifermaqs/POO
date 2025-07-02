package POO_2.Porquinho;

import java.util.Scanner;
import java.util.ArrayList;

public class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pig pig = new Pig(0);

        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String[] ui = line.split(" ");

            try {
                if (ui[0].equals("end")) {
                    break;
                } else if (ui[0].equals("init")) {
                    pig = new Pig(Integer.parseInt(ui[1]));
                } else if (ui[0].equals("show")) {
                    System.out.println(pig);
                } else if (ui[0].equals("addCoin")) {
                    switch (ui[1]) {
                        case "10":  pig.addCoin(Coin.C10);  break;
                        case "25":  pig.addCoin(Coin.C25);  break;
                        case "50":  pig.addCoin(Coin.C50);  break;
                        case "100": pig.addCoin(Coin.C100); break;
                        default:    System.out.println("fail: invalid coin"); break;
                    }
                } else if (ui[0].equals("addItem")) {
                    pig.addItem(new Item(ui[1], Integer.parseInt(ui[2])));
                } else if (ui[0].equals("break")) {
                    pig.breakPig();
                } else if (ui[0].equals("extractCoins")) {
                    System.out.println(pig.extractCoins());
                } else if (ui[0].equals("extractItems")) {
                    System.out.println(pig.extractItems());
                } else {
                    System.out.println("fail: invalid command");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                if (e.getMessage().contains("must break the pig first")) {
                    if (ui[0].equals("extractCoins")) {
                        System.out.println(new ArrayList<Coin>());
                    } else if (ui[0].equals("extractItems")) {
                        System.out.println(new ArrayList<Item>());
                    }
                }
            }
        }
        scanner.close();
    }
}
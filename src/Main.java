/*   All possible errors have been accounted for: incorrect user input,
incorrect data type input, to prevent crashes from the application,
and exceptions have been handled!  */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int wather = 400;
        int milk = 540;
        int coffeeBeanc =  120;
        int cups = 9;
        int money = 550;
        Machine maсhine = new Machine(wather, milk, coffeeBeanc, cups, money);
        maсhine.start();
    }
}


class Machine {
    Scanner input = new Scanner(System.in);
    private int wather;
    private int milk;
    private int coffeeBeanc;
    private int cups;
    private int money;

    public Machine(int wather, int milk, int coffeeBeanc, int cups, int money) {
        this.wather = wather;
        this.milk = milk;
        this.coffeeBeanc = coffeeBeanc;
        this.cups = cups;
        this.money = money;
    }

    public void start() {
        while (true) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            String operation;
            while (true) {
                operation = input.nextLine();
                if ("buy".equals(operation) || "fill".equals(operation) || "take".equals(operation) || "remaining".equals(operation) || "exit".equals(operation)) {
                    break;
                }
                System.out.println("Write action (buy, fill, take, remaining, exit):");
            }

            if ("exit".equals(operation)) { break;}
            switch (operation) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    remaining();
                    break;
            }
        }
    }


    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        int numProduct = 0;
        while (true) {
            String parseNum = input.nextLine();
            try {
                numProduct = Integer.parseInt(parseNum);
                if (numProduct <= 3 && numProduct >= 1) {
                    break;
                }
                continue;
            } catch (Exception e) {
                if ("back".equals(parseNum)) {
                    numProduct = 0;
                    break;
                }
            }
        }

        switch (numProduct) {
            case 1:
                buyEspresso();
                break;
            case 2:
                buyLatte();
                break;

            case 3:
                buyCappuccino();
                break;
            case 0:
                break;
        }

    }


    public void buyEspresso () {
        String error = "";
        if (this.wather >= 250 && this.coffeeBeanc >= 16 && this.money >= 4 && this.cups > 0) {
            this.wather -= 250;
            this.coffeeBeanc -= 16;
            this.cups -= 1;
            this.money += 4;
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            error = this.wather - 250 < 0 ? error += "Sorry, not enough water!\n": error;
            error = this.coffeeBeanc - 12 < 0 ? error += "Sorry, not enough coffee beans!\n": error;
            error = this.cups - 1 < 0 ? error += "Sorry, not enough coffee cups!\n": error;
            System.out.println(error);
        }
    }


    public void buyLatte () {
        String error = "";
        if (this.wather >= 350 && this.milk >= 75 && this.coffeeBeanc >= 20 && this.money >= 7 && this.cups > 0) {
            this.wather -= 350;
            this.milk -= 75;
            this.coffeeBeanc -= 20;
            this.cups -= 1;
            this.money += 7;
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            error = this.wather - 350 < 0 ? error += "Sorry, not enough water!\n": error;
            error = this.milk - 75 < 0 ? error += "Sorry, not enough milk!\n": error;
            error = this.coffeeBeanc - 20 < 0 ? error += "Sorry, not enough coffee beans!\n": error;
            error = this.cups - 1 < 0 ? error += "Sorry, not enough coffee cups!\n": error;
            System.out.println(error);
        }
    }


    public void buyCappuccino () {
        String error = "";
        if (this.wather >= 200 && this.milk >= 100 && this.coffeeBeanc >= 12 && this.money >= 6 && this.cups > 0) {
            this.wather -= 200;
            this.milk -= 100;
            this.coffeeBeanc -= 12;
            this.cups -= 1;
            this.money += 6;
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            error = this.wather - 200 < 0 ? error += "Sorry, not enough water!\n": error;
            error = this.milk - 100 < 0 ? error += "Sorry, not enough milk!\n": error;
            error = this.coffeeBeanc - 12 < 0 ? error += "Sorry, not enough coffee beans!\n": error;
            error = this.cups - 1 < 0 ? error += "Sorry, not enough coffee cups!\n": error;
            System.out.println(error);
        }
    }


    public void fill() {
        System.out.println("Write how many ml of water you want to add:");
        this.wather += controlNum();
        System.out.println("Write how many ml of milk you want to add: ");
        this.milk += controlNum();
        System.out.println("Write how many grams of coffee beans you want ");
        this.coffeeBeanc += controlNum();
        System.out.println("Write how many disposable cups you want to add:");
        this.cups += controlNum();
    }


    public void take() {
        System.out.printf("I gave you $%d", this.money);
        this.money = 0;
    }


    public void remaining () {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d ml of water\n", this.wather);
        System.out.printf("%d ml of milk\n", this.milk);
        System.out.printf("%d g of coffee beans\n", this.coffeeBeanc);
        System.out.printf("%d disposable cups\n", this.cups);
        System.out.printf("$%d of money\n", this.money);
    }


    public int controlNum() {
        int numProduct = 0;
        while (true) {
            String buyProduct = input.nextLine();
            try {
                if (!buyProduct.isEmpty()) {
                    numProduct = Integer.parseInt(buyProduct);
                    break;
                }
            } catch (Exception e) {
                continue;
            }
            break;
        }
        return numProduct;
    }
}


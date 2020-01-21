package com.henrysgrocery;

import com.henrysgrocery.checkout.ShoppingCheckout;
import com.henrysgrocery.item.Item;
import com.henrysgrocery.offer.AppleOffer;
import com.henrysgrocery.offer.SoupOffer;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

public class HenrysGroceryApplication {
    private PrintStream printStream;
    private Scanner scanner;

    public HenrysGroceryApplication(Scanner scanner, PrintStream printStream) {
        this.printStream = printStream;
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        HenrysGroceryApplication henrysGroceryApplication = new HenrysGroceryApplication(new Scanner(System.in), System.out);
        henrysGroceryApplication.process();
    }

    private void process() {
        List<Item> itemList = new ArrayList<>();
        printStream.println("\n========  WELCOME TO HENRY'S GROCERY  =========\n");
        printStream.println("\nPlease enter Q to exit from app anytime..");
        printStream.println("\n...........................................");
        while (true) {
            readItems(itemList);
            shoppingCheckout(itemList);
            itemList.clear();
        }
    }

    private void readItems(List<Item> itemList) {
        for (Item item : Item.values()) {
            printStream.println("\nPlease enter number of " + item.getName() + " or press C to checkout:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("C")) {
                break;
            } else if (input.equalsIgnoreCase("Q")) {
                printStream.println("HenrysGroceryApplication is ending without shopping checkout..!");
                System.exit(0);
            }
            try {
                int numberOfItem = Integer.parseInt(input);
                addItemToBasket(itemList, item, numberOfItem);
            } catch (Exception e) {
                printStream.println("Number can not be recognized. Item couldn't be added to basket!");
            }
        }
    }

    private void shoppingCheckout(List<Item> itemList) {
        ShoppingCheckout shoppingCheckout = new ShoppingCheckout(itemList,
                Arrays.asList(
                        new SoupOffer(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(7)),
                        new AppleOffer(LocalDateTime.now().plusDays(3), LocalDateTime.now().plusMonths(1).with(lastDayOfMonth()))
                )
        );
        BigDecimal totalCost = shoppingCheckout.checkout(LocalDateTime.now());
        printStream.println("\n****Total cost for this shopping : " + totalCost);
    }

    private void addItemToBasket(List<Item> itemList, Item item, int numberOfItem) {
        for (int i = 0; i < numberOfItem; i++) {
            itemList.add(item);
        }
    }
}

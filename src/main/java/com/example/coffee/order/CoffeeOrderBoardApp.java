package com.example.coffee.order;


public class CoffeeOrderBoardApp {
    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();

        board.add("Alen");
        board.add("Yoda");
        board.add("Obi-van");
        board.add("John Snow");

        board.draw();

        board.deliver();
        board.deliver(33);

        board.draw();
    }
}


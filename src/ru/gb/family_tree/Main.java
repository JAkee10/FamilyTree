package ru.gb.family_tree;

import ru.gb.family_tree.model.family_tree.saver.FileHandler;
import ru.gb.family_tree.view.ConsoleUI;

public class Main {

    public static void main(String[] args) {

        ConsoleUI view = new ConsoleUI(new FileHandler());
        view.start();

    }

}
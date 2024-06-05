package ru.gb.family_tree.human.comparators;

import ru.gb.family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByChildrenCount implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getChildren().size(), o2.getChildren().size());
    }
}

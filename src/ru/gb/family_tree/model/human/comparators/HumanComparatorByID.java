package ru.gb.family_tree.model.human.comparators;

import ru.gb.family_tree.model.family_tree.FamilyTreeGeneric;
import ru.gb.family_tree.model.family_tree.HasID;

import java.util.Comparator;

public class HumanComparatorByID<E extends HasID> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getID(), o2.getID());
    }
}

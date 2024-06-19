package ru.gb.family_tree.model.human.comparators;

import ru.gb.family_tree.model.family_tree.FamilyTreeGeneric;
import ru.gb.family_tree.model.family_tree.HasAge;
import ru.gb.family_tree.model.family_tree.HasName;

import java.util.Comparator;

public class HumanComparatorByName<E extends HasName> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

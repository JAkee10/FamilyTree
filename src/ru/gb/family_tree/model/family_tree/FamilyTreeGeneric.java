package ru.gb.family_tree.model.family_tree;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeGeneric<E> extends Comparable<E>, HasID, HasName, HasChildren, HasAge{
    E getFather();
    E getMother();
    void setChildren(List<E> e);
    void addChildren(E e);
}

package ru.gb.family_tree.tree.iterators;

import ru.gb.family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class EIterator<E> implements Iterator<E> {
    private int index;
    private List<E> humanList;

    public EIterator(List<E> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public E next() {
        return humanList.get(index++);
    }

}

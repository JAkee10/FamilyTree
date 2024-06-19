package ru.gb.family_tree.model.family_tree;

import java.util.List;

public interface HasChildren<E> {
    List<E> getChildren();
}

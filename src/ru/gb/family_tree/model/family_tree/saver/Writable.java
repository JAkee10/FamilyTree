package ru.gb.family_tree.model.family_tree.saver;

import java.io.Serializable;

public interface Writable{
    void save(Serializable serializable);
    Object load();

}

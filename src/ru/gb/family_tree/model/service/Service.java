package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.family_tree.saver.Writable;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> familyTree;


    public Service() {
        familyTree = new FamilyTree<>();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate, int fatherID, int motherID) {
        familyTree.addHuman(new Human(name, gender, birthDate, familyTree.findByID(fatherID), familyTree.findByID(motherID)));
    }

    public String getFamilyTreeInfo() {
        StringBuilder sb = new StringBuilder();
        for (Object o : familyTree) {
            sb.append(o);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByID() {
        familyTree.sortByID();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void sortByChildrenCount() {
        familyTree.sortByChildrenCount();
    }

    public String findByName(String name) {
        return familyTree.findByName(name);
    }


    public void saveTree(Writable writable) {
        writable.save(familyTree);
    }

    public void loadTree(Writable writable) {
        familyTree = (FamilyTree<Human>) writable.load();
        Human.setHumanCounter(familyTree.getSize());
    }

}

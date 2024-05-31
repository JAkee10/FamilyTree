package ru.gb.family_tree.human;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

/**
 * @class_Human позволяющий создавать и управлять людьми в дереве. Имеет команды:
 * @setChildren - Присвоение детей родителю
 * @addChildren - Добавление детей родителю
 * @getAge - Возвращает возраст
 * @parentToString - Возвращает String с именЕМ родителя
 * @childrenToString - Возвращает String с именАМИ детей
 */
public class Human {
//    private static int generation = 1;

    private String name;
    private Gender gender;
    private LocalDate dateOfBirth, dateOfDeath;
    private List<Human> children;
    private Human father, mother;


    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void addChildren(Human children) {
        List<Human> childrens = new ArrayList<>(this.children);
        childrens.add(children);
        this.children = childrens;
    }

    public String getName() {
        return name;
    }


    private Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, List<Human> children, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.children = children;
        this.father = father;
        this.mother = mother;
    }

    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, Human father, Human mother) {
        this(name, gender, dateOfBirth, dateOfDeath, null, father, mother);
    }

    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        this(name, gender, dateOfBirth, dateOfDeath, null, null);

    }

    public Human(String name, Gender gender, LocalDate dateOfBirth, Human father, Human mother) {
        this(name, gender, dateOfBirth, null, father, mother);
    }

    public Human(String name, Gender gender, LocalDate dateOfBirth) {
        this(name, gender, dateOfBirth, null, null);
    }

    public Human() {
        this("human", Gender.Male, LocalDate.of(new Random().nextInt(1600, 2024), new Random().nextInt(1, 13), new Random().nextInt(1, 31)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name) && Objects.equals(dateOfBirth, human.dateOfBirth) && Objects.equals(dateOfDeath, human.dateOfDeath);
    }

    @Override
    public int hashCode() {
        int[] codes = name.codePoints().toArray();
        long hashNumPart = 0;
        for (int code : codes) {
            hashNumPart += code;
        }
        String hashStringPart = String.valueOf(hashNumPart + (long) new Random().nextInt(2, 100) * dateOfBirth.getDayOfYear());
        return Objects.hash(hashStringPart, getAge(dateOfBirth, dateOfDeath));
    }

    @Override
    public String toString() {
        return "name: " + name + ", gender: " + gender + ", age: " + getAge(dateOfBirth, dateOfDeath) + " | parents: (" + parentToString(father) + ", " + parentToString(mother) + ")" + ", children: " + childrenToString(children);
    }


    private int getAge(LocalDate dayOfBirth, LocalDate dayOfDeath) {
        String age;
        if (dayOfDeath == null) {
            age = Period.between(dayOfBirth, LocalDate.now()).toString();
        } else {
            age = Period.between(dayOfBirth, dayOfDeath).toString();
        }
        return Integer.parseInt(age.substring(1).split("Y")[0]);
    }

    private String parentToString(Human parent) {
        if (parent == null) return null;
        return parent.name;
    }

    private String childrenToString(List<Human> children) {
        if (children == null) return null;

        StringBuilder stringBuilder = new StringBuilder().append("(");
        Iterator<Human> iterator = children.iterator();
        while (iterator.hasNext()) {
            Human child = iterator.next();
            stringBuilder.append(child.name);
            if (iterator.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.append(")").toString();

    }

    /**
     * Более красивый вывод детей, но слишком много повторов
     * @param children List< Humon > Список детей
     * @return String в уже упорядоченном виде
     */
//    private String childrenToString(List<Human> children) {
//        if (children == null) {
//            generation--;
//            if (generation < 1) generation = 1;
//            return null;
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        StringBuilder space = new StringBuilder();
//
//        for (int i = 0; i < generation; i++) {
//            space.append("    ");
//        }
//        space.append("|-> ");
//        for (Human child : children) {
//            stringBuilder.append("\n");
//            stringBuilder.insert(stringBuilder.length(), space);
//            if (child.children != null) generation++;
//            stringBuilder.append(child.toString());
//        }
//        return stringBuilder.toString();
//    }


}

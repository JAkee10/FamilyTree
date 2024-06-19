package ru.gb.family_tree.model.family_tree;

import java.time.LocalDate;

public interface HasAge {
    LocalDate getDateOfBirth();
    LocalDate getDateOfDeath();
    int getAge(LocalDate birthDate, LocalDate DeathDate);
}

package com.example.javafxtry.Controllers;

import com.example.javafxtry.Models.FullName;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class FullNameComporator {
    private boolean sortFirstName = false;
    private boolean sortLastName = false;
    private boolean sortPatronymic = false;
    private final BiFunction<FullName, FullName, Integer> firstNameComporator = (a, b) -> {
        if (a.getFirstName().compareTo(b.getFirstName()) < 0){
            return -1;
        } else {
            return 1;
        }
    };
    private final BiFunction<FullName, FullName, Integer> lastNameComporator = (a, b) -> {
        if (a.getLastName().compareTo(b.getLastName()) < 0){
            return -1;
        } else {
            return 1;
        }
    };
    private final BiFunction<FullName, FullName, Integer> patronymicComporator = (a, b) -> {
        if (a.getPatronymic().compareTo(b.getPatronymic()) < 0){
            return -1;
        } else {
            return 1;
        }
    };
    private final BiFunction<FullName, FullName, Integer> firstAndLastNameComporator = (a, b) -> {
        if (a.getFirstName().compareTo(b.getFirstName()) < 0){
            return -1;
        } else if (a.getFirstName().compareTo(b.getFirstName()) > 0) {
            return 1;
        }else {
            if (a.getLastName().compareTo(b.getLastName()) < 0){
                return -1;
            } else if (a.getLastName().compareTo(b.getLastName()) > 0) {
                return 1;
            }else {
                return 1;
            }
        }
    };
    private final BiFunction<FullName, FullName, Integer> lastNameAndPatronymicComporator = (a, b) -> {
        if (a.getLastName().compareTo(b.getLastName()) < 0){
            return -1;
        } else if (a.getLastName().compareTo(b.getLastName()) > 0) {
            return 1;
        } else {
            if (a.getPatronymic().compareTo(b.getPatronymic()) < 0){
                return -1;
            } else {
                return 1;
            }
        }
    };
    private final BiFunction<FullName, FullName, Integer> firstLastNameAndPatronymicComporator = (a, b) -> {
        if (a.getFirstName().compareTo(b.getFirstName()) < 0){
            return -1;
        } else if (a.getFirstName().compareTo(b.getFirstName()) > 0) {
            return 1;
        } else {
            if (a.getLastName().compareTo(b.getLastName()) < 0){
                return -1;
            } else if (a.getLastName().compareTo(b.getLastName()) > 0) {
                return 1;
            } else {
                if (a.getPatronymic().compareTo(b.getPatronymic()) < 0){
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    };

    public FullNameComporator(boolean sortFirstName, boolean sortLastName, boolean sortPatronymic) {
        this.sortFirstName = sortFirstName;
        this.sortLastName = sortLastName;
        this.sortPatronymic = sortPatronymic;
    }
    public BiFunction<FullName, FullName, Integer> getComporator(){
        if(sortFirstName && sortLastName && sortPatronymic)
        {
            return firstLastNameAndPatronymicComporator;
        } else if (sortFirstName && sortLastName) {
            return firstAndLastNameComporator;
        } else if (sortFirstName && sortPatronymic) {
            return firstAndLastNameComporator;
        } else if (sortLastName && sortPatronymic) {
            return lastNameAndPatronymicComporator;
        } else if (sortFirstName) {
            return firstNameComporator;
        } else if (sortLastName) {
            return lastNameComporator;
        } else {
            return patronymicComporator;
        }
    }
}

package com.company;

public class AlredyUsedExeption extends Exception {
    public AlredyUsedExeption () {
        super ("поле уже занято");
    }
}

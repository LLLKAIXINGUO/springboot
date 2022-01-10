package com.xty.abstractfactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AK47 extends Weapon {

    public void shoot(){
        System.out.println("tutututututu.........");
    }

    public static void main(String[] args) {
        System.out.println(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
    }
}

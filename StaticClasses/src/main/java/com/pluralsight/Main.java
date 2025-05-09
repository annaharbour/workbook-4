package com.pluralsight;

public class Main {
    //    Prefix: Mr., Mrs., Miss., Dr. etc
//FirstName
//MiddleName
//LastName
//Suffix: PhD, Jr, III etc
//The standard formats that we require for all names must match this pattern:
//LastName, Prefix FirstName MiddleName, Suffix
//Johnson, Dr. Mel B, PhD
//Johnson, Mel B, PhD
//Johnson, Mel
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println("Dr. Mel B Johnson, Phd -> \t" + NameFormatter.format("Dr. Mel B Johnson, Phd"));
        System.out.println("Mel Johnson -> \t" + NameFormatter.format("Mel Johnson"));
        System.out.println("Mel B Johnson, PhD -> \t" + NameFormatter.format("Mel B Johnson, PhD"));
        System.out.println("\"Mel\", \"Johnson\" -> \t" + NameFormatter.format("Mel", "Johnson"));
        System.out.println("\"Dr\", \"Mel\", \"B\", \"Johnson\", \"Phd\" -> \t" + NameFormatter.format("Dr", "Mel", "B",
                "Johnson", "Phd"));
    }
}
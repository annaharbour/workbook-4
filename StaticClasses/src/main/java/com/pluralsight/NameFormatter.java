package com.pluralsight;

public class NameFormatter {
    private NameFormatter() {

    }

    public static String format(String firstName, String lastName) {
        StringBuilder formatted = new StringBuilder();
        formatted.append(lastName).append(", ").append(firstName);
        return formatted.toString();
    }

    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
        StringBuilder formatted = new StringBuilder();
//TODO: replace ,'s
        formatted.append(lastName).append(", ").append(prefix).append(" ").append(firstName).append(middleName).append(
                ", ").append(suffix);
        return formatted.toString();
    }

    public static String format(String fullName) {
        String[] names = fullName.split(" ");
        String first = "";
        String middleName = "";
        String lastName = "";
        String suffix = "";

        switch(fullName.length()){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:

                break;
            default:
                break;
        }

        StringBuilder formattedName = new StringBuilder();
//        TOD: append
        String result = formattedName.toString();
        System.out.println(result);
        //You should assume that an incoming fullName will always come formatted in this order:
        //Prefix FirstName MiddleName LastName, Suffix
        //Dr. Mel B Johnson, PhD
        //Mel B Johnson, PhD
        //Mel Johnson
        return "";
    }
}

// Prefix: Mr., Mrs., Miss., Dr. etc
//FirstName
//MiddleName
//LastName
//Suffix: PhD, Jr, III etc

//The standard formats that we require for all names must match this pattern:
//LastName, Prefix FirstName MiddleName, Suffix
//Johnson, Dr. Mel B, PhD
//Johnson, Mel B, PhD
//Johnson, Mel
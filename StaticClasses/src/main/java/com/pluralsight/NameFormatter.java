package com.pluralsight;

public class NameFormatter {


    public static String format(String firstName, String lastName) {
        StringBuilder formatted = new StringBuilder();
        formatted.append(lastName).append(", ").append(firstName);
        return formatted.toString();
    }

    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
        StringBuilder formatted = new StringBuilder();


        if(!lastName.isEmpty()){
            formatted.append(lastName).append(", ");
        }
        if (!prefix.isEmpty()) {
            formatted.append(prefix).append(" ");
        }
        if (!firstName.isEmpty()) {
            formatted.append(firstName).append(" ");
        }
        if (!middleName.isEmpty()) {
            formatted.append(middleName);
        }
        if (!suffix.isEmpty()) {
            formatted.append(", ").append(suffix);
        }

        return formatted.toString();
    }

    public static String format(String fullName) {
        String[] names = fullName.split(" ");
        String firstName = "";
        String middleName = "";
        String lastName = "";
        String suffix = "";
        String prefix = "";
        StringBuilder formattedName = new StringBuilder();

        switch (names.length) {
            case 1:
                firstName = names[0];
                formattedName.append(firstName);
                break;
            case 2:
                firstName = names[0];
                lastName = names[1];
                formattedName.append(lastName).append(", ").append(firstName);
                break;
            case 3:
                firstName = names[0];
                middleName = names[1];
                lastName = names[2];
                formattedName.append(lastName).append(" ").append(firstName).append(" ").append(middleName);
                break;
            case 4:
                firstName = names[0];
                middleName = names[1];
                lastName = names[2];
                suffix = names[3];
                formattedName.append(lastName).append(" ").append(firstName).append(" ").append(middleName).append(
                        ", ").append(suffix);
                break;
            case 5:
                prefix = names[0];
                firstName = names[1];
                middleName = names[2];
                lastName = names[3];
                suffix = names[4];
                formattedName.append(lastName).append(" ").append(prefix).append(" ").append(firstName).append(
                        " ").append(middleName).append(", ").append(suffix);
                break;
            default:
                break;
        }
        String result = formattedName.toString();
        //You should assume that an incoming fullName will always come formatted in this order:
        //Prefix FirstName MiddleName LastName, Suffix
        //Dr. Mel B Johnson, PhD
        //Mel B Johnson, PhD
        //Mel Johnson
        return result;
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
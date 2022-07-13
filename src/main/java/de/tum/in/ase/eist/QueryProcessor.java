package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        System.out.println("Query: " + query);
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "Finn D.";
        } else if (query.startsWith("what is") && query.contains("plus")){ // TODO extend the programm here
            // parse what is 11 plus 10
            String[] split = query.split("plus");
            int a = Integer.parseInt(split[0].replaceAll("[^\\d.]", ""));
            int b = Integer.parseInt(split[1].replaceAll("[^\\d.]", ""));
            return String.valueOf(a + b);
        }
        else if(query.startsWith("what is") && query.contains("minus")){ // TODO extend the programm here
            // parse what is 11 minus 10
            String[] split = query.split("minus");
            int a = Integer.parseInt(split[0].replaceAll("[^\\d.]", ""));
            int b = Integer.parseInt(split[1].replaceAll("[^\\d.]", ""));
            return String.valueOf(a - b);
        }
        else if(query.startsWith("what is") && query.contains("multiplied by")){ // TODO extend the programm here
            // parse what is 11 times 10
            String[] split = query.split("multiplied by");
            int a = Integer.parseInt(split[0].replaceAll("[^\\d.]", ""));
            int b = Integer.parseInt(split[1].replaceAll("[^\\d.]", ""));
            return String.valueOf(a * b);
        }
        else if(query.startsWith("what is") && query.contains("divided by")){ // TODO extend the programm here
            // parse what is 11 divided by 10
            String[] split = query.split("divided by");
            int a = Integer.parseInt(split[0].replaceAll("[^\\d.]", ""));
            int b = Integer.parseInt(split[1].replaceAll("[^\\d.]", ""));
            return String.valueOf(a / b);
        }
        else if(query.startsWith("what is") && query.contains("modulo")){ // TODO extend the programm here
            // parse what is 11 modulo 10
            String[] split = query.split("modulo");
            int a = Integer.parseInt(split[0].replaceAll("[^\\d.]", ""));
            int b = Integer.parseInt(split[1].replaceAll("[^\\d.]", ""));
            return String.valueOf(a % b);
        }
        else if(query.startsWith("which of the following numbers is the largest: ")) {
            // parse which of the following numbers is the largest:  147, 264, 19, 85
            String[] split = query.split("which of the following numbers is the largest: ");
            String[] numbers = split[1].split(", ");
            int max = Integer.parseInt(numbers[0].replaceAll("[^\\d.]", ""));
            for(int i = 1; i < numbers.length; i++) {
                int number = Integer.parseInt(numbers[i].replaceAll("[^\\d.]", ""));
                if(number > max) {
                    max = number;
                }
            }
            return String.valueOf(max);
        }
        else if(query.startsWith("which of the following numbers is both a square and a cube:")) {
            // parse which of the following numbers is both a square and a cube: 914, 64, 841, 415
            String[] split = query.split("which of the following numbers is both a square and a cube: ");
            String[] numbers = split[1].split(", ");
            for(int i = 0; i < numbers.length; i++) {
                int number = Integer.parseInt(numbers[i].replaceAll("[^\\d.]", ""));
                if(Math.sqrt(number) == (int)Math.sqrt(number) && Math.cbrt(number) == (int)Math.cbrt(number)) {
                    return String.valueOf(number);
                }
            }
            return "";
        }
        else {
            return "\\(°~°)/";
        }
    }
}

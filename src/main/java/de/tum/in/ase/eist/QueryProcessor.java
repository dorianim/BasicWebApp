package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "Finn D.";
        } else if (query.startsWith("what is") && query.contains("plus")){ // TODO extend the programm here
            // parse 15 plus 17
            String[] split = query.split("plus");
            int a = Integer.parseInt(split[0].substring(7));
            int b = Integer.parseInt(split[1].substring(7));
            return String.valueOf(a + b);
        }
        else if(query.startsWith("which of the following numbers is the largest: ")) {
            // parse which of the following numbers is the largest:  147, 264, 19, 85
            String[] split = query.split("which of the following numbers is the largest: ");
            String[] numbers = split[1].split(", ");
            int max = Integer.parseInt(numbers[0]);
            for(int i = 1; i < numbers.length; i++) {
                int number = Integer.parseInt(numbers[i]);
                if(number > max) {
                    max = number;
                }
            }
            return String.valueOf(max);
        }
        else {
            return "\\(°~°)/";
        }
    }
}

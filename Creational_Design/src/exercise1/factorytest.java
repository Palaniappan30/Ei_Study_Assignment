package exercise1;

import java.util.Scanner;

interface Currency {
    String getSymbol();
}

class Rupee implements Currency {
    @Override
    public String getSymbol() {
        return "Rs";
    }
}

class SGDDollar implements Currency {
    @Override
    public String getSymbol() {
        return "SGD";
    }
}

class USDollar implements Currency {
    @Override
    public String getSymbol() {
        return "USD";
    }
}

class CurrencyFactory {
    public static Currency createCurrency(String country) {
        if (country.equalsIgnoreCase("India")) {
            return new Rupee();
        } else if (country.equalsIgnoreCase("Singapore")) {
            return new SGDDollar();
        } else if (country.equalsIgnoreCase("US")) {
            return new USDollar();
        }
        throw new IllegalArgumentException("No such currency");
    }
}

public class factorytest {
    public static void main(String args[]) {
        String country;

        if (args.length > 0) {
            country = args[0];
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a country: ");
            country = scanner.nextLine();
        }

        try {
            Currency currency = CurrencyFactory.createCurrency(country);
            System.out.println(currency.getSymbol());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

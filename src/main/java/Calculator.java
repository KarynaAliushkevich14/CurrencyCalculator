import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {

    private String ExchangeTime;
    private ArrayList<String> currencyArray;
    private ArrayList<Double> rateArray;
    private double result;
    private double amount;

    public Calculator(String exchangeTime, ArrayList<String> currencyArray, ArrayList<Double> rateArray, double amount) {
        this.ExchangeTime = exchangeTime;
        this.currencyArray = currencyArray;
        this.rateArray = rateArray;
        this.amount = amount;
    }


    public String getExchangeTime() {
        return ExchangeTime;
    }

    public void setExchangeTime(String exchangeTime) throws  Exception {
        if (exchangeTime != getExchangeTime()) {
            throw new Exception("Time can't be changed");
        }this.ExchangeTime = exchangeTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) throws Exception {
        if (amount < 0 ) {
            throw new Exception("Amount should be positive number");
        }this.amount = amount;
    }

    public ArrayList<String> getCurrencyArray() {
        return currencyArray;
    }

    public void setCurrencyArray(ArrayList<String> currencyArray) {
        this.currencyArray = currencyArray;
    }

    public ArrayList<Double> getRateArray() {
        return rateArray;
    }

    public void setRateArray(ArrayList<Double> rateArray) {
        this.rateArray = rateArray;
    }

    public double inputAmount () throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome to pocket converter!");
        System.out.println("Please set amount in EUR you want to convert: ");
        double amount = sc.nextDouble();

        while(amount<0 || String.valueOf(amount).isBlank()){
            System.out.println("Amount should be positive number!");
            sc = new Scanner(System.in);
            amount = sc.nextDouble();
        }
        return amount;
    }

    public void setCurrency (ArrayList currencyArray, ArrayList rateArray, double amount) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose currency to convert to from the following: ");
        for(int i=0; i<currencyArray.size(); i++){
            System.out.print(currencyArray.get(i)+" ");
        }System.out.println();
        String currency = sc.nextLine();

        while (currency.isBlank()){
            System.out.println("Currency should not be blank!");
            sc = new Scanner(System.in);
            currency = sc.nextLine();
        }

        while (!currencyArray.contains(currency.toUpperCase())){
            System.out.println("There is no such currency.Please choose currency from the following!");
            sc = new Scanner(System.in);
            currency = (String) sc.nextLine();
        }

            switch (currency.toUpperCase(Locale.ROOT)) {
                case "USD": {
                    result = amount * (Double) rateArray.get(0);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+ " "+currencyArray.get(0));
                    break;
                }
                case "JPY": {
                    result = amount * (Double) rateArray.get(1);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(1));
                    break;
                }case "BGN": {
                    result = amount * (Double) rateArray.get(2);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(2));
                    break;
                }
                case "CZK": {
                    result = amount * (Double) rateArray.get(3);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(3));
                    break;
                }case "DKK": {
                    result = amount * (Double) rateArray.get(4);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(4));
                    break;
                }
                case "GBP": {
                    result = amount * (Double) rateArray.get(5);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(5));
                    break;
                } case "HUF": {
                    result = amount * (Double) rateArray.get(6);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(6));
                    break;
                }case "PLN": {
                    result = amount * (Double) rateArray.get(7);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(7));
                    break;
                }
                case "RON": {
                    result = amount * (Double) rateArray.get(8);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(8));
                    break;
                }case "SEK": {
                    result = amount * (Double) rateArray.get(9);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(9));
                    break;
                }case "CHF": {
                    result = amount * (Double) rateArray.get(10);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(10));
                    break;
                }
                case "ISK": {
                    result = amount * (Double) rateArray.get(11);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(11));
                    break;
                } case "NOK": {
                    result = amount * (Double) rateArray.get(12);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(12));
                    break;
                }case "HRK": {
                    result = amount * (Double) rateArray.get(13);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(13));
                    break;
                }
                case "TRY": {
                    result = amount * (Double) rateArray.get(14);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(14));
                    break;
                }case "AUD": {
                    result = amount * (Double) rateArray.get(15);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(15));
                    break;
                } case "BRL": {
                    result = amount * (Double) rateArray.get(16);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(16));
                    break;
                }case "CAD": {
                    result = amount * (Double) rateArray.get(17);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(17));
                    break;
                }
                case "CNY": {
                    result = amount * (Double) rateArray.get(18);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(18));
                    break;
                }case "HKD": {
                    result = amount * (Double) rateArray.get(19);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(19));
                    break;
                } case "IDR": {
                    result = amount * (Double) rateArray.get(20);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(20));
                    break;
                }case "ILS": {
                    result = amount * (Double) rateArray.get(21);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(21));
                    break;
                }
                case "INR": {
                    result = amount * (Double) rateArray.get(22);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(22));
                    break;
                }case "KRW": {
                    result = amount * (Double) rateArray.get(23);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(23));
                    break;
                } case "MXN": {
                    result = amount * (Double) rateArray.get(24);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(24));
                    break;
                }case "MYR": {
                    result = amount * (Double) rateArray.get(25);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(25));
                    break;
                }
                case "NZD": {
                    result = amount * (Double) rateArray.get(26);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(26));
                    break;
                }case "PHP": {
                    result = amount * (Double) rateArray.get(27);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(27));
                    break;
                } case "SGD": {
                    result = amount * (Double) rateArray.get(28);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(28));
                    break;
                }case "THB": {
                    result = amount * (Double) rateArray.get(29);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(29));
                    break;
                }
                case "ZAR": {
                    result = amount * (Double) rateArray.get(30);
                    System.out.println("\n"+amount+" EUR = "+Math.round(result * 1000.0) / 1000.0+" "+currencyArray.get(30));
                    break;
                }
            }
        }
    }


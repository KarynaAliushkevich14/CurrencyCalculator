import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    ArrayList<String> currencyList = new ArrayList();
    ArrayList<Double> rateList = new ArrayList();

    private Calculator calculator;

    @BeforeEach
    void initTest() {
        this.calculator = new Calculator("2022-07-18", currencyList, rateList, 10);
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }

    //testing get methods
    @Test
    public void getExchangeTimeTest() throws Exception {
        String expected = "2022-07-18";
        String actual = calculator.getExchangeTime();
        assertEquals(expected, actual);
    }

    @Test
    public void getAmountTest() throws Exception {
        double expected = 10;
        double actual = calculator.getAmount();
        assertEquals(expected, actual);
    }

    @Test
    public void getCurencyArrayTest() throws Exception {
        assertEquals(0, currencyList.size());
        currencyList.add("USD");
        assertEquals(1, currencyList.size());

        String expected = "USD";
        String actual = calculator.getCurrencyArray().get(0);
        assertEquals(expected, actual);

        String expectedLow = "usd".toUpperCase(Locale.ROOT);
        String actualLow = calculator.getCurrencyArray().get(0);
        assertEquals(expectedLow, actualLow);

    }

    @Test
    public void getRateArrayTest() throws Exception {
        assertEquals(0, rateList.size());
        rateList.add(1.0131);
        assertEquals(1, rateList.size());

        double expected = 1.0131;
        double actual = calculator.getRateArray().get(0);
        assertEquals(expected, actual);
    }

    //testing set methods
    @Test
    public void setExchangeTimeTest() throws Exception {
        assertThrows(Exception.class, ()->{  calculator.setExchangeTime("2000-01-01"); });
    }

    @Test
    public void setAmountTest() throws Exception {
        assertThrows(Exception.class, ()->{  calculator.setAmount(-5); });
    }

    @Test
    public void setCurrencyArrayTest() throws Exception {
        ArrayList<String> newCurrencyList = new ArrayList();
        calculator.setCurrencyArray(newCurrencyList);
        newCurrencyList.add("PLN");
        assertEquals(1, calculator.getCurrencyArray().size());
    }

    @Test
    public void setRateArrayTest() throws Exception {
        ArrayList<Double> newRateArrayList = new ArrayList();
        calculator.setRateArray(newRateArrayList);
        newRateArrayList.add(4.078);
        assertEquals(1, calculator.getRateArray().size());
    }

    @Test
    public void setCurrencySwitchUSDTest() throws Exception {
        double amount = 10;
        double result = 0;
        String currency = "pln";
        rateList.add(1.0131);

        switch (currency.toUpperCase()){
            case "PLN":{
                result =  Math.round(amount * (Double) rateList.get(0) * 1000.0) / 1000.0;
                break;
            }
        }

        double expected = 10.131;
        double actual = result;
        assertEquals(expected, actual);
    }
}

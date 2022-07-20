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
        int expected = 10;
        int actual = calculator.getAmount();
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


}

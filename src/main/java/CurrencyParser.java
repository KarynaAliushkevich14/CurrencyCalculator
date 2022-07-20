import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CurrencyParser {
    public static void main(String[] args) {
        //initializing variables
        String time = null;
        String currency = null;
        String rate = null;
        int amount = 0;
        ArrayList <String> currencyList = new ArrayList<>();
        ArrayList <Double> rateList = new ArrayList<>();

        //parse xml file
        File xmlFile = new File ("eurofxref-daily.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(xmlFile);

                //extract data
                NodeList list = doc.getElementsByTagName("Cube");
                for(int i =0; i<list.getLength(); i++){
                    Node node = list.item(i);
                    if(node.getNodeType()==Node.ELEMENT_NODE ){
                        Element cube = (Element) node;
                        time = cube.getAttribute("time");
                        currency = cube.getAttribute("currency");
                        rate = cube.getAttribute("rate");

                        //extract currency and rate into ArrayLists
                        if (!currency.isBlank()) {
                            currencyList.add(currency);
                            try{
                            rateList.add(Double.parseDouble(rate));
                            }catch (Exception e){
                                e.getMessage();
                            }
                        }
                    }
                }
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }


        //create Calculator
        Calculator calc = new Calculator(time, currencyList, rateList, amount);
        int newAmount = calc.inputAmount();
        calc.setCurrency(currencyList, rateList, newAmount);

    }
}

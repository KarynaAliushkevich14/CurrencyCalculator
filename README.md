# Projekt kalkulatora walut w języku Java

Cel: Niniejsze zadanie polegało na napisaniu prostego kalkulatora walut ze źródłem kursów walut http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml. Projekt musiał składać się z 2 klas: parser pliku .xml oraz klasy Kalkulatora. Kalkulator powinien przyjmować kwotę w EUR, a zwracać w docelowej walucie.


Projekt:
   Projekt konsolowy jest zbudowany za pomocą Maven’a. W SourceRoot zawiera 2 klasy: Calculator oraz CurrencyParser; w TestSources Root – klasę CalculatorTest z testami jednostkowymi za pomocą Junit.
   Parsing pliku XML zrobiony za poomocą interfejsu DOM ( Document Object Model).




# Currency calculator project in Java.

Target:
    Task was to write a simple currency calculator with a source for exchange rates http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml. The project is consist of 2 classes: the .xml file parser and the Calculator class. The calculator should accept an amount in EUR and return in the target currency.


Design:
    The console project is built with Maven. In SourceRoot it contains 2 classes: Calculator and CurrencyParser; in TestSources Root - the CalculatorTest class with unit tests using Junit.
    XML file parsing done with DOM (Document Object Model) interface.

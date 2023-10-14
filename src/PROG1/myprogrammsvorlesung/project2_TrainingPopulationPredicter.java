package PROG1.myprogrammsvorlesung;

/**
 * In einer Stadt U a.d. D gibt es heute 20 Biber (=beaver), Die Wachstumsrate (=rate of growth)
 * beträgt 30% pro Jahr. Schreiben Sie ein Programm, welches die zu erwartenden Populationen
 * für die nächsten Jahre berechnet.
 */

public class project2_TrainingPopulationPredicter {
    public static void main(String[] args) {
        printPopulationPredicition(20,30, 10);
    }

    // Methode
    // rateOfGrowth in percent!
    public static void printPopulationPredicition (int initialPopulation, int rateOfGrowth, int numOfYears) {
        int year = 0;
        int currentPopulation = initialPopulation;

        while (year <= numOfYears) {
            //Ausgabe (Ausgabe vor Berechnung, weil wir für Jahr = 0 keine Berechnung bräuchten und diese zu viel wär
            System.out.println("Year: " + year + " Population: " + currentPopulation);
            //Berechnung der Population
            currentPopulation = (int) (currentPopulation * (1 + (rateOfGrowth/100.0))); // wird so gerundet

            year = year+1; //oder year ++, ++ ist eleganter
        }


    }

}

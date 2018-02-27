package kody;

/**
 *
 * @author Duckyta
 */
public class Casovac {

    int pocetDotazu; /*celkove zapoctene casy*/
    double prumernyCas;
    double maximalniCas;
    /*maximalni ze vsech*/
    double hranice;
    /*cas, pod ktery musi byt uloha vykonana*/
    int prescas;

    public Casovac(double hranice) {
        this.hranice = hranice;
    }

    public int getPocetDotazu() {
        return pocetDotazu;
    }

    public double getPrumernyCas() {
        return Math.round(prumernyCas * 1000) / 1000d;
    }

    public double getMaximalniCas() {
        return Math.round(maximalniCas * 1000) / 1000d;
    }

    public int getPrescas() {
        return prescas;
    }
    
    public void vypocitejCas(double cas) {
        
        pocetDotazu += 1;
        prumernyCas = (prumernyCas * (pocetDotazu - 1) + cas) / pocetDotazu;
        
        if (cas > hranice) {
            prescas++;
        }
        
        if (maximalniCas < cas) {
            maximalniCas = cas;
        }
    }

    @Override
    public String toString() {
        return "Celkovy pocet dotazu: " + pocetDotazu + ", prumerny cas: " + prumernyCas + ", maximalni cas: " + maximalniCas + ", prescas: " + prescas;
    }

}

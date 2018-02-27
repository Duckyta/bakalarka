package kody;

/**
 *
 * @author Duckyta
 */
public class Stopky {
    long start, stop;
    
    public void start() {
        start = System.currentTimeMillis();
    }
    
    public void stop() {
        stop = System.currentTimeMillis();
    }
    
    public float ubehlyCas() {
        return (stop - start)/1000f;
    }
    
    @Override
    public String toString() {
        return "cas provedeni: " + Float.toString(ubehlyCas()) + " s.";
    }
}

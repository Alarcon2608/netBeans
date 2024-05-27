


package micalculadora;

public class Calculadora implements Operaciones {

    @Override
    public double suma(double n1, double n2) {
        return n1+n2;
    }

    @Override
    public double resta(double n1, double n2) {
        return n1-n2;

    }
    
    @Override
    public double division(double n1, double n2) {
        return n1/n2;

    }
    
    @Override
    public double multi(double n1, double n2) {
        return n1*n2;

    }

}

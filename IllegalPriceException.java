package chevalBlanc;

public class IllegalPriceException extends Exception{
    private static final long serialVersionUID = 1L;

    public IllegalPriceException(){
        super("Le prix d'une chambre ne peut pas être négatif");
    }
}

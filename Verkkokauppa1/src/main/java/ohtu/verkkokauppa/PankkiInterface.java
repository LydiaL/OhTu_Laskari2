package ohtu.verkkokauppa;

/**
 *
 * @author Lydia Lairala
 */
public interface PankkiInterface {

    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
    
}

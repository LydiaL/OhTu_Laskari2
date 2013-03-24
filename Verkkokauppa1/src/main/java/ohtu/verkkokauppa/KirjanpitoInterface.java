package ohtu.verkkokauppa;

import java.util.ArrayList;

/**
 *
 * @author Lydia Lairala
 */
public interface KirjanpitoInterface {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
    
}

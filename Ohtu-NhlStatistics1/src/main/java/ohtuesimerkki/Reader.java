package ohtuesimerkki;

import java.util.List;

/**
 *
 * @author Lydia Lairala
 */
public interface Reader {

    List<Player> getPlayers();

    int extractInt(String str);
}

package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lydia Lairala
 */
public class StatisticsTest {

    Statistics stats;
    Reader readerStub = new Reader() {
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }

        @Override
        public int extractInt(String str) {
            return Integer.parseInt(str.trim());
        }
    };

    public StatisticsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSearch() {
        stats = new Statistics(readerStub);
        int actual = 0;
        int expected = 4;
        if (stats.search("NotARealPlayer") == null) {
            Player player = stats.search("Semenko");
            actual = player.getGoals();
        }
        assertTrue(actual == expected);
    }

    @Test
    public void team() {
        stats = new Statistics(readerStub);
        ArrayList<Player> players = (ArrayList<Player>) stats.team("EDM");
        Player player = players.get(1);
        String actual = player.getName();
        String expected = "Kurri";
        assertTrue(actual.equals(expected));
    }

    @Test
    public void topScorers() {
        stats = new Statistics(readerStub);
        ArrayList<Player> players = (ArrayList<Player>) stats.topScorers(3);
        Player player = players.get(1);
        String actual = player.getName();
        String expected = "Lemieux";
        assertTrue(actual.equals(expected));
    }
}

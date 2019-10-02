package bowling;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedago
 */
public class MutiPlayerGameTest {
    
    private MultiPlayersGame game;
    String[] testname={"Roger","Bastien","Mickael"};
    String[] noname;

	@Before
	public void setUp() {
            
		game = new MultiPlayersGame();
	}
        
        @Test
        public void CorrectName(){
            game.startNewGame(testname);
            assertEquals(testname[1],game.player[1]);
            }
        
        @Test (expected = UnsupportedOperationException.class)
        public void NoPlayer(){
            game.startNewGame(noname);
            assertEquals(null,game.player[0]);
            
        }
        
        @Test
        public void PasseToursuiv(){
            game.startNewGame(testname);
            assertEquals("Prochain tir : joueur Bastien, tour n°1, boule n° 1",game.lancer(10));
        }
        @Test
        public void PasseBoulsuiv(){
            game.startNewGame(testname);
            assertEquals("Prochain tir : joueur Roger, tour n°1, boule n°2",game.lancer(5));
        }
        @Test
        public void Score() {
            game.startNewGame(testname);
            game.lancer(5);
            assertEquals(5,game.scoreFor("Roger"));
        }
        @Test (expected = UnsupportedOperationException.class)
        public void NoLancer() {
            game.lancer(1);
        }
        
        @Test
        public void cherche(){
            game.startNewGame(testname);
            assertEquals(0,game.search("Roger"));
        }
        
}
    


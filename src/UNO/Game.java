package UNO;


import java.util.ArrayList;
        import java.util.Scanner;
/**
 *
 * @author Ratinder Bhullar
 */
public abstract class Game{
    private final String gameName = "UNO";//the title of the game
    private ArrayList <Player> players;// the players of the game


    Scanner input = new Scanner(System.in);

    public Game(String givenName)
    {
        players = new ArrayList();
    }

    public Game() {

    }
    /**
     * @return the gameName
     */
    public String getGameName()
    {
        return gameName;
    }

    /**
     * @return the players of this game
     */


    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList <Player> players)
    {
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending
     * on your game.
     */
    public abstract void play() ;



    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public abstract void declareWinner();
}

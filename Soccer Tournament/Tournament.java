import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;


/**
 * Creates several ArrayLists to store Team objects and manipulate them so you may randomly generate pools of competitors.
 *
 * @author Gage Poling
 * @version v1.0
 */
public class Tournament
{
    // instance variables
    private ArrayList<Team> competitors;

    /**
     * Constructor for objects of class Tournament
     */
    public Tournament()
    {
        // initialise instance variables
        competitors = new ArrayList<>();
    }

    /**
     * This simply adds all the countries listed in the assignment all at once.
     * If you wish to add invidual teams, see the addTeam() method.
     */
    public void createTourney()
    {
        // put your code here
        competitors.add(new Team("Austria"));
        competitors.add(new Team("Belgium"));
        competitors.add(new Team("Croatia"));
        competitors.add(new Team("Czech Republic"));
        competitors.add(new Team("Denmark"));
        competitors.add(new Team("England"));
        competitors.add(new Team("Finland"));
        competitors.add(new Team("France"));
        competitors.add(new Team("Germany"));
        competitors.add(new Team("Hungary"));
        competitors.add(new Team("Italy"));
        competitors.add(new Team("Netherlands"));
        competitors.add(new Team("North Macedonia"));
        competitors.add(new Team("Poland"));
        competitors.add(new Team("Portugal"));
        competitors.add(new Team("Russia"));
        competitors.add(new Team("Scotland"));
        competitors.add(new Team("Slovakia"));
        competitors.add(new Team("Spain"));
        competitors.add(new Team("Sweden"));
        competitors.add(new Team("Switzerland"));
        competitors.add(new Team("Turkey"));
        competitors.add(new Team("Ukraine"));
        competitors.add(new Team("Wales"));
    }
    
    /**
     * Randomly picks 6 teams and forms a pool, then removes them from the availiable competitors list.
     * Run this until you have exhausted your competitors list.
     * Ideally there would be a check to prevent you from running createPool() once the competitors list is exhausted
     * but instead this will just throw an error.
     */
    public void createPool()
    {
        System.out.println("This pool consists of teams from:");
        Collections.shuffle(competitors);
        for (int i = 0; i < 6; i++)
        {
            int index = (int)(Math.random() * competitors.size());
            System.out.println(competitors.get(index).getCountry());
            competitors.remove(index);
        }
    }
    
    /**
     * Adds individual teams to the competitors collection.
     */
    public void addTeam(String teamName)
    {
        competitors.add(new Team(teamName));
    }
}

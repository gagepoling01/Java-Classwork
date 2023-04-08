
/**
 * Creates a Team object with a name of a country. Could be expanded to add individual players, but unnecessary for assignment.
 *
 * @author Gage Poling
 * @version v1.0
 */
public class Team
{
    // instance variables
    private String teamCountry;

    /**
     * Constructor for objects of class Team
     */
    public Team(String Country)
    {
        // initialise instance variables
        teamCountry = Country;
    }

    /**
     * @return    the name of the country
     */
    public String getCountry()
    {
        return teamCountry;
    }
    
    /**
     *  @param newCountry is the new name of a country in case it needs modified
     */
    public void setCountry(String newCountry)
    {
        teamCountry = newCountry;
    }
}

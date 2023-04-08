
/**
 * Stores the information of each candidate
 *
 * @author Gage Poling
 * @version v1.0
 */
public class Candidate
{
    
    private int votes;
    private String name;
    /**
     * Constructor for objects of class Candidate
     */
    public Candidate(String candidateName, int candidateVotes)
        throws IllegalArgumentException
    {
        // initialise instance variables
        if (votes < 0)
        {
            throw new IllegalArgumentException("Votes cannot be negative.");
        }
        else
        {
            votes = candidateVotes;
            name = candidateName;
        }
    }

    /**
     * @return name of the candidate
     */
    public String getName()
    {
        return name;
    }
    /**
     * @return candidate's number of votes
     */
    public float getVotes()
    {
        return votes;
    }
    /**
     * @return candidate name and votes in a structured, sentence form
     */
    public String listCandidates()
    {
        String details = name + " has " + votes + " votes.";
        return details;
    }
}

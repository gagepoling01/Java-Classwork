/**
 * Just an exercise in recursion
 *
 * @author Gage Poling
 * @version 10/12/2021
 */
public class Recursion
{
    // instance variables
    private float i;
    private float sum;
    /**
     * Constructor for objects of class Recursion
     */
    public Recursion()
    {
        // initialise instance variables
        i = 0;
    }

    /**
     * @param  i  Integer reflecting how large you want the summation to be
     * @return    the summation itself
     */
    public float recursion(float i)
    {
        if (i <= 1)
        {
            System.out.println((i/((2*i)+1)));
            return (i/((2*i)+1));
        }
        if (i > 1)
        {
            sum = (i/((2*i)+1)) + recursion(i-1);
            System.out.println(sum);
        }
        return sum;
    }
}

/**
 * @author Gage Poling
 * @version v1.0
 */
public class ThreadTest
{
    
    /**
     * Constructor for objects of class Threads
     */
    public ThreadTest()
    {
    }
    
    public static void main(String args[])
    {
        Thread t = null;
        for(int i = 1; i < 5; i++)
        {
            int temp = i;
            Operations op = new Operations(temp, "Thread-" + temp);
            t = new Thread(op);
            t.start();
        }
        
        try
        {
            t.join();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        catch(InterruptedException e)
        {
            System.out.println("Main thread interrupted.");
        }
    }
}


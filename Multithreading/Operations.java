/**
 * @author Gage Poling
 * @version v1.0
 */
public class Operations implements Runnable
{
    private String threadName;
    private int threadFunction;
          
    /**
     * Constructor for objects of class Operations
     */
    public Operations(int function, String name)
    {
        threadFunction = function;
        threadName = name;
        System.out.println("Creating " + threadName);
    }
    
    /**
     *
     */
    public void run()
    {
        System.out.println("Starting " + threadName);
        Thread t;
        
        if(threadFunction == 1)
        {
            Runnable atSign = new Runnable()
            {
                public void run()
                {
                    for(int i = 0; i < 100; i++)
                    {
                        System.out.print("@");
                    }
                }
            };
            t = new Thread(atSign);
            t.start();
        }
        
        else if(threadFunction == 2)
        {
            Runnable dollarSign = new Runnable()
            {
                public void run()
                {
                    for(int i = 0; i < 300; i++)
                    {
                        System.out.print("$");
                    }
                }
            };
            t = new Thread(dollarSign);
            t.start();
        }
        
        else if(threadFunction == 3)
        {
            Runnable oddNumber = new Runnable()
            {
                public void run()
                {
                    for(int i = 0; i < 300; i++)
                    {
                        if(i % 2 != 0)
                        {
                            System.out.print(i + " ");
                        }
                    }
                }
            };
            t = new Thread(oddNumber);
            t.start();
        }
        
        else
        {
            Runnable powerOfTwo = new Runnable()
            {
                public void run()
                {
                    for(int i = 0; i <= 8; i++)
                    {
                        System.out.print((int)Math.pow(2, i) + " ");
                    }
                    
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        System.out.println(threadName + " was interrupted.");
                    }
                    
                    for(int i = 9; i <= 16; i++)
                    {
                        System.out.print((int)Math.pow(2, i) + " ");
                    }
                }
            };
            t = new Thread(powerOfTwo);
            t.start();
        }
        
        try
        {
            t.join();
            System.out.println("\nExiting " + threadName);
        }
        catch(InterruptedException e) 
        {
            System.out.println(threadName + " was interrupted."); 
        }
    }
}

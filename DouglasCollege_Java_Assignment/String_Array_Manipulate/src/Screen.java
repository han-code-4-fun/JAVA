
public class Screen 
{
	static public void scrollScreen() {
		for(int i = 0; i<50; i++)
    	{
    		System.out.println(" \n");
    	}
	    System.out.flush();  
		
	}
	
	public static void scrollScreen(char displayChar, int charTimes, int lines)
	{
		for(int line =0; line<lines; line++) 
    	{
    		for (int i =0; i<charTimes;i++)
        	{
        		System.out.print(displayChar);
    		}
    		System.out.println("");
        
    	}
	}
	
}

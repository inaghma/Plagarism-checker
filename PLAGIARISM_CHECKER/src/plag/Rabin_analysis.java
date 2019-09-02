package plag;
import java.awt.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Rabin_analysis {
	
	private static long startTime;
	private static long endTime;
	static int q=101;
	public Rabin_analysis(String text,String pattern)
	{
		search(pattern.toCharArray(),text.toCharArray());
	}
	public static void search(char pat[], char txt[])
	{ 		
		int d=256;
	    int M = pat.length;
	    int N = txt.length;
	    int i, j;
	    int p = 0; //hash value for pattern
	    int t = 0; //hash value for text
	    int h = 1;
	 
	    // The value of h would be "pow(d, M-1)%q"
	    for (i = 0; i < M-1; i++)
	        h = (h*d)%q;
	 
	    // Calculate the hash value of pattern and first
	    // window of text
	    for (i = 0; i < M; i++)
	    {
	        p = (d*p + pat[i])%q;
	        t = (d*t + txt[i])%q;
	    }
	 
	    // Slide the pattern over text one by one
	    for (i = 0; i <= N - M; i++)
	    {
	 
	        // Check the hash values of current window of text
	        // and pattern. If the hash values match then only
	        // check for characters on by one
	        if ( p == t )
	        {
	            /* Check for characters one by one */
	            for (j = 0; j < M; j++)
	            {
	                if (txt[i+j] != pat[j])
	                    break;
	            }
	 
	           // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
	            if (j == M)
	            {
	           
	               System.out.println("Pattern found at index "+i); 
	          
	              
	             }
	        }
	 
	        // Calculate hash value for next window of text: Remove
	        // leading digit, add trailing digit
	        if ( i < N-M )
	        {
	            t = (d*(t - txt[i]*h) + txt[i+M])%q;
	 
	            // We might get negative value of t, converting it
	            // to positive
	            if (t < 0)
	            t = (t + q);
	        }
	    }}
	public static void main(String[] args) throws IOException
    {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("RABIN KARP Test");
        System.out.println("\nEnter Text\n");
        String text = br.readLine();
        System.out.println("\nEnter Pattern\n");
        String pattern = br.readLine();
        startTime = System.nanoTime();  
        Rabin_analysis obj= new Rabin_analysis (text, pattern);  
        endTime = System.nanoTime();
	    System.out.println("Took "+(endTime - startTime) + " ns");
    }
}

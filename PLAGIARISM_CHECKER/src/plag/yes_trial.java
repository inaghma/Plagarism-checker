package plag;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class yes_trial extends fileread
{
	static String s="";
	static int tri=0;//var to count no.of grams
	static int dup=0;//var to calculate the duplication
	static int q=101;//prime no. for hash value calculation
	static String p;//query docuement
	static double roundOff; //to round off the % 
    static List<String> flist= new ArrayList<String>();//the final list of the matched n grams
    static List<String> ngramList= new ArrayList<String>(); //create list for storage

	 
	public static void clearll()
	{
		
		tri=0;
		dup=0;
		roundOff=0.0;
		flist.clear();
		ngramList.clear();
		
	}
	
	//constructor to initialize the pattern 	
	public static void iyes_trial(String pat)
	{
		
		System.out.println("standard length ="+word_count(s)+" words    Query length="+word_count(pat)+"words");
		if(word_count(s)<word_count(pat))
		{
			String t;
			t=pat;
			pat=s;
			s=t;
			System.out.println("YESS SWAPPED!!");
			//swap file names
			String temp;
			temp=MAIN_GUI.fname1;
			MAIN_GUI.fname1=MAIN_GUI.fname2;
			MAIN_GUI.fname2=temp;
			
		}
		 System.out.println(s); 
		    System.out.println(pat);
		System.out.println("standard length ="+word_count(s)+" words    Query length="+word_count(pat)+"words");
		p=pat.replaceAll("[^a-zA-Z0-9]"," ");
		p=p.replaceAll("\\s+"," ");
		s=s.replaceAll("[^a-zA-Z0-9]"," ");
		s=s.replaceAll("\\s+"," ");
		
		   System.out.println(s);
		    System.out.println(p);
	    generateNgrams(3,s);//call for ngramlist creation
	}
	
	
	//to count the no.of words
	public static  int word_count(String str)
	{
	   String[] w_array=str.split("\\s+");
	  
		return w_array.length;
		
	}
	
    //rabin karp code-1(for the %calculation)
	public static void search(char pat[], char txt[],List<String> nlist,int in)
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
	            /*	System.out.println(nlist.get(in));//display the pattern*/
	               System.out.println("Pattern found at index "+i); 
	           //  HIGHLIGHT.get(i,M);
	             
	               dup=dup+1;//increment duplication value
	               flist.add(ngramList.get(in));
	              
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
	  //generating n grams for % calculation
			public static void generateNgrams(int N, String sent) {
			  String[] tokens = sent.split("\\s+"); //split sentence into tokens
	
			  //GENERATE THE N-GRAMS
			  for(int k=0; k<(tokens.length-N+1); k++){
			    String s="";
			    int start=k;
			    int end=k+N;
			    
			    for(int j=start; j<end; j++){
			     s=s+""+tokens[j]+" ";
			    }
			    //Add n-gram to a list
			    ngramList.add(s);
			   

		  }
			  ngramList=check_dup(ngramList);
			  tri=ngramList.size();
			  System.out.println(tri+"no.of grams");
			  for(int m=0;m<ngramList.size();m++)
			  {
				 System.out.println(ngramList.get(m));
				  search((ngramList.get(m).toLowerCase()).toCharArray(), (p.toLowerCase()).toCharArray(),ngramList,m);		  
			  }
			  
			  
			 
			}//End of method
		
		//checking for duplicated ngrams
				public static List<String> check_dup(List<String> Nlist)
				{
					int lsize=Nlist.size();
					List<String> nl = Nlist;
					// add elements to al, including duplicates
					LinkedHashSet<String> hs = new LinkedHashSet<String>();
					hs.addAll(nl);
					nl.clear();
					nl.addAll(hs);
					return nl;
				}
		//diaplay the no.of duplicated grams
		 public static double display() 
		    {
			   // System.out.println(s);
			   // System.out.println(p);
		    	System.out.println(dup+"no.of grams duplicated ");
		    	float percent = (dup* 100f) / tri;
		    	
		    		 roundOff = Math.round(percent * 100.0) / 100.0D;
			    	
		    	if(roundOff>100.0)
		    	{
		    		roundOff=100.0;
		    	}		    
		    	System.out.println(roundOff+"% duplicated");
		    	return roundOff;
		  
		    	
		    	
		    }
		 
			//rabin karp code-1(for highlighting
			public static void search(char pat[], char txt[],int in,boolean b)
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
			            /*	System.out.println(nlist.get(in));//display the pattern*/
			            //   System.out.println("Pattern found at index "+i); 
			            	if(b==true)
			            	{
			               HIGHLIGHT.get(i,M,true);//file 1 ka,source ,leftside ,largefile
			            	}
			            	else
			            	{
			            		 HIGHLIGHT.get(i,M,false);//file 2 ka,pattern ,rightside ,smallfile
			            	}
			             
			               //dup=dup+1;//increment duplication value
			           //    flist.add(ngramList.get(in));
			              
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
			    }
			   }
		public  static void main(String[] args) throws  IOException
		{
			
			// TODO Auto-generated method stub
			 String path1="C:/Users/3bca2016/Documents/check1.txt";
			 String path2="C:/Users/3bca2016/Documents/check2.txt";
			 String path3="C:/Users/3bca2016/Documents/check3.txt";

			List<String> nlist= new ArrayList<String>();
            List<Integer> wlist=new ArrayList();
			int i=0;
			int in;
			int jn;
			String t1=readFile(path1);
		    String t2=readFile(path2);
		    String t3=readFile(path3);
		    String pattern="which makes it easier to access";
		    int w1=yes_trial.word_count(t1);
		    int w2=yes_trial.word_count(t2);
		    int w3=yes_trial.word_count(t3);
		    wlist.add(w1);
		    wlist.add(w2);
		    wlist.add(w3);
		    
		    Collections.sort(wlist, Collections.reverseOrder());
		    
		    System.out.println(wlist);
	        while(i<wlist.size())
		   {
			   if((wlist.get(i))==w1)
				   nlist.add(t1);
			   else if((wlist.get(i))==w2)
				   nlist.add(t2);
			   else
				   nlist.add(t3);
			   i++;
			   
		   }
		    		   
	 System.out.println(nlist);
	    	
	   for(in=0;in<nlist.size();in++)
	   {
		   for(jn=in+1;jn<nlist.size();jn++)
		   {
			   yes_trial.s=nlist.get(in);
	    		yes_trial.iyes_trial(nlist.get(jn));
	    		yes_trial.display();
	    		System.out.println("----------------------------------------------------------------------------------------------");
		   }
	   }
	    		
	    		
	    		in++;
	    		
	    	
			
			
	
		


		}


}
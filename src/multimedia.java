import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Scanner ;
import java.util.StringTokenizer;  

public class multimedia {
	static public class Tags
	{
	    public String entry; 
	    public int index; 
	    public String GetString() 
	    {
			return entry;	
	    }
	    public int GetIndex()
	    {
	    	return index;
	    }
	    public void SetString(String Entry)
	    {
	    	this.entry = Entry;
	    }
	    public void SetIndex(int Index)
	    {
	    	this.index = Index;
	    }
	 };
	 
	 static Vector<Tags> Encode = new Vector<Tags>();
     static Vector<String> Encode_Dec = new Vector <String> (); 
     static Vector <Tags> Decode = new Vector <Tags>();
     static Vector<String> Decode_Dec = new Vector <String>(); 

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		    int choice ;
		    Scanner ch = new Scanner(System.in);
 	        System.out.println("Would you like\n1-Encode\n2-Decode\n3-Exit"); 
 	        
     	    choice = ch.nextInt();  
     	    while(choice == 1 || choice == 2 || choice == 3)
     	    { 	
     	    if (choice == 1)
     	    {   
	         String s; 
		     Scanner sc = new Scanner(System.in);
 	         System.out.println("Enter a string"); 
     	     s = sc.nextLine();  
     	     //System.out.println("You entered String "+s);
     	     encode(s) ;
  	        System.out.println("Your Tags:"); 
     	     for (int c = 0 ; c < Encode.size();c++)
     	     {   
     	      System.out.println ("<"+Encode.get(c).GetIndex()+","+Encode.get(c).GetString()+">");
     	     }
     	   }
     	   if (choice == 2) 
     	   {	   

         	 Scanner z = new Scanner(System.in);       		
 	   
       		 Vector <Tags> Tags_Vec = new Vector<Tags>() ;   
             int Decision ;

       		 Decision = choice ;
       		 while (Decision !=1)
       		 {	 
       			Tags de = new Tags() ;  
         		 
         		 System.out.println("Enter Tags:") ;
         		 
     	    	 de.index = z.nextInt();  
        		 de.entry = z.next();          		 
        		 
         		 System.out.println("Are You Finish?/n1-Yes/n2-No") ;
           		 Decision = z.nextInt();	 
           		 
           		Tags_Vec.add(de) ;   
       		 }
       		decode(Tags_Vec); 
     	   }
     	   if (choice == 3) 
     	   {	   
     		  System.exit(0);  
     	   }
     	   System.out.println("Would you like\n1-Encode\n2-Decode\n3-Exit"); 
    	   choice = ch.nextInt();  
     	 } 
     	   
     } 

	public static boolean check (String character)
	{
		if (Encode_Dec.indexOf(character) == -1 )  
		{	
	      return false ;			
		}
		else
		{	
		  return true ; 	
		} 
	}
	
	public static void encode (String The_word)
	{
		int i = 0 , the_index ;
		Tags d = new Tags() ;	
	    the_index = 0 ;
	   while ( i < The_word.length())
	   {	   
		   String mychar = Character.toString(The_word.charAt(i));
		   if (check (mychar)==true ) 
		   {   
		     while (check (mychar) == true)
             {
			  the_index = (Encode_Dec.indexOf (mychar))+1 ;  
			  i = i+1 ;
			  if (i < The_word.length())
			    {	 
			     mychar = mychar + Character.toString(The_word.charAt(i)) ;
			    }
			  else 
			  {
				 Encode_Dec.add(mychar) ;
	             d = new Tags() ;
	             d.index = 0 ;
	             d.entry =Character.toString(mychar.charAt(mychar.length()-1)) ; 
	             Encode.add(d);
			     i++ ;
			     return ;
			   }
				 
              }	   
		   Encode_Dec.add(mychar) ;
           d = new Tags() ;
           d.index = the_index ;
           d.entry =Character.toString(mychar.charAt(mychar.length()-1)) ; 
           Encode.add(d);
		   i++;}

		   else {
		    Encode_Dec.add(mychar) ; 
			d = new Tags() ;
			d.index = 0 ;
			d.entry = mychar;
			i++;
			Encode.add(d);}
		   		   
		   }
	   }
	   
	public static void decode (Vector<Tags>tags) 
	{
	 int index ;	
	 String The_word = ""; 	
	 for (int counter = 0 ; counter < tags.size();counter++)
	 {
		 
	   if ((tags.get(counter).index) == 0)
	   {	   
		 Encode_Dec.add(tags.get(counter).entry) ;  
		 The_word += tags.get(counter).entry ;
	   }
	   else
	   {	   

		 index = tags.get(counter).index ;     
	     The_word = The_word+ Encode_Dec.get(index-1) ;
		 The_word+= tags.get(counter).entry ;
	   }
	 }
	System.out.println("Your Tags Ater Decompression:"+The_word+"\n");
	 
	}
	   
	}






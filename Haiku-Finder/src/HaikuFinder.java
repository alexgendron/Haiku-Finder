package src;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
	
	public class HaikuFinder {
		
		public static int countSyllables(String word)
		   {
		      int count = 0;
		      int end = word.length() - 1;
		      if (end < 0) return 0; 
		      char ch = Character.toLowerCase(word.charAt(end));
		      if (ch == 'e') end--;

		      boolean insideVowelGroup = false;
		      for (int i = 0; i <= end; i++)
		      {
		         ch = Character.toLowerCase(word.charAt(i));
		         String vowels = "aeiouy";
		         if (vowels.indexOf(ch) >= 0) 
		         {
		         
		            if (!insideVowelGroup)
		            {
		               count++; 
		               insideVowelGroup = true;
		            }
		         }
		      }

		      if (count == 0) 
		         count = 1;

		      return count;      
		   }
		  
		
	public static void main(String[] args) {
		String fileName = "test.txt";
		int count =0;
		int count2 = 5;
		String h = "";
		String h2= "";
		BufferedReader br =null;
		Scanner scanFile;
		try{
			
			String currentLine;
			scanFile = new Scanner(new FileReader(new File(fileName)));
			
			while(scanFile.hasNext()){
				currentLine = scanFile.next();
					count += countSyllables(currentLine);
					h += currentLine + " ";
					if(count == count2){
		
					if(count2 == 5){
						count2 += 7;
					}
					else if(count2 == 12){
						count2 +=5;
					}
					else if(count2 ==17){
						count2 =5;
						h2 += h + "\n";
						h= " ";
						count = 0;
						h= " ";
						
					}
					else if(count > count2){
						count = 0;
						h= " ";
					}
				}
			}
			
			
		}
			catch(IOException e){
				System.out.println("error");
				e.printStackTrace();
			}
	
	System.out.println(h2);
}
}
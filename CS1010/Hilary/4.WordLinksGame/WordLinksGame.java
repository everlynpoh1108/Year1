/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5: 5]
- Comment: Method returns all read words as an array theDict.
- My method reads the words from the "words.txt" file. [Mark out of 5: 0]
- Comment: text file wouldn't load
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
- Comment: Returns contents as array of objects. Code would work if file can be read

2. readWordList
- I have the correct method definition [Mark out of 5: 5]
- Comment: Reads in the input string and stored in ArrayList of objects.
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
- Comment: Converts the string to ArrayList

3. isUniqueList
- I have the correct method definition [Mark out of 5: 5]
- Comment: Takes in an array and returns true if strings in array are unique.
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment: A nested for loop is used to compare every word in the array.
- Exits the loop when a non-unique word is found. [Mark out of 5: 5]
- Comment: If non-unique is found the method will return false.
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment: If words are all not equal, method returns true and false otherwise

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment: Method returns true if the word in user word list can be found in the array list of dictionary words and false otherwise.
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:0]
- Comment: I used the arraylist method contains to check if the words in respective arraylist matches.
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:0]
- Comment: Returns true if matches and false otherwise

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: A few nested for loops and while loops were used to compare two strings of words at a time and return true if 
           the size of words are the same and differ by one character.
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:0]
- Comment: Works for comparing characters of the same length but not with searching for one difference.

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment: calls isUniqueList, isEnglishWord and isDifferentByOne, if all are true, then method returns true
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
- Comment: Method calls all the other method but I printed the message in the readWord method

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures [Mark out of 10:5]
- Comment: I used a FileReader and a BufferedReader to read the text file but can't seem to load the txt file into my program.
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment: Program asks user for an input of words separated by commas.

 Total Mark out of 100 (Add all the previous marks): 75
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList ;
import java.util.Scanner ;

class Word {
	public String word ;
	public int index ;
	
	Word (String w, int i) {
		word = w ;
		index = i ;
	}
	
	public String toString() {
		return word;
	}
}
public class WordLinksGame {
	
		public static final int numberOfWordsInDict = 658964 ;
		 

		public static void main (String[]args) {
			boolean finished = false ;
			ArrayList<Word> theDictionary = new ArrayList<Word> () ;
			//Word[] theDict = new Word[numberOfWordsInDict] ;
			
			while (!finished)
			{
				System.out.print("Enter a comma separated list of words('quit' to exit) :") ;
				Scanner scanner = new Scanner(System.in) ;
				if (scanner.hasNext("quit")) 
				{
					finished = true ;
				}
				else
				{
					String wordList = scanner.nextLine() ;
					try {
						 ;
						readDictionary(theDictionary) ;
					} catch (IOException e) {
						e.printStackTrace();
					} 
					readWordList(wordList,theDictionary) ;
				}
			}
		}
		
		public static void readDictionary(ArrayList<Word>theDictionary) throws IOException {
			Word word ;
			String currentWord ;
			int index = 0 ;
			
			
			FileReader fileReader = new FileReader ("words.txt") ;
			BufferedReader bufferedReader = new BufferedReader (fileReader) ;
		
			while((currentWord=bufferedReader.readLine()) != null)
			{
				word = new Word(currentWord, index) ;
				//theDict[index] = word ;
				theDictionary.add(word) ;
				index = index+1 ;
				
			}
		}
		
		public static void readWordList(String wordList, ArrayList<Word>theDictionary) {
			 
			ArrayList<Word> wordListArrayList = new ArrayList<Word>() ;
			String[] wordListArray = wordList.split(", ") ;
			for (int i=0 ; i<wordListArray.length ; i++)
			{
				String currentWord = wordListArray[i] ;
				Word currentWord1 = new Word (currentWord, i) ;
				wordListArrayList.add(currentWord1) ;
			}
			boolean isWordChain = isWordChain(wordListArray, wordListArrayList,theDictionary) ;
			if (isWordChain)
			{
				System.out.println("Valid chain of words from Lewis Caroll's word-links game.");
			}
			else
			{
				System.out.println ("Not a valid chain of words from Lewis Caroll's word-links game.") ;
			}
		}
		
		public static boolean isUniqueList(String[] wordListArray) {
			for (int i=0 ; i<wordListArray.length ; i++)
			{
				String currentWord = wordListArray[i] ;
				for (int j=i+1 ; j<wordListArray.length ; j++)
				{
					String nextWord = wordListArray[j] ;
					if (currentWord == nextWord)
					{
						return false ;
					}
				}
			}
			return true ;
		}
		
		public static boolean isEnglishWord(ArrayList<Word> wordListArrayList, String[]wordListArray, ArrayList<Word>theDictionary) {
			boolean isWord = true ;
			for (int i=0 ; i<wordListArray.length ; i++)
			{
				if (theDictionary.contains(wordListArrayList.get(i))== false)
				{
					isWord = false ;
				}
				else isWord = true ;
			}
			return isWord ;
		}

		

		public static boolean isDifferentByOne(String[] wordListArray) {
			int k = 0;
			int l = 0;
			
	
			boolean finished = false ;
			boolean finished2 = false ;
		
			for (int i=0 ; i<wordListArray.length ; i++)
			{
				int diffCharCount = 0 ;
				char[]currentWordChar = wordListArray[i].toCharArray() ;
				
				while (k<currentWordChar.length && !finished )
				{
					char currentChar = currentWordChar[k] ;
					
					for (int j=i+1 ; j<wordListArray.length ; j++)
					{
						char[]nextWordChar = wordListArray[j].toCharArray() ;
						l = k ;
						
						while (l<nextWordChar.length && !finished2)
						{
							char nextChar = nextWordChar[l] ;
							if (currentChar == nextChar)
							{
								k++ ;
								l++ ;
								finished = true ;
							}
							else if (currentChar != nextChar)
							{
								l++ ;
								finished2 = true ;	
							}
						}
						diffCharCount++ ;
						k++ ;
						
						if (diffCharCount > 1 || (currentWordChar.length != nextWordChar.length))
						{
							return false ;
						}
						
						finished = true ;
					}	
				}	
			}
			return true ;
		}
		
		public static boolean isWordChain(String[] wordListArray, ArrayList<Word> wordListArrayList, ArrayList<Word>theDictionary) {
			if (isUniqueList(wordListArray)== true && isEnglishWord(wordListArrayList, wordListArray,theDictionary) == true 
					&& isDifferentByOne(wordListArray) == true)
			{
			 return true ;
			}
			else return false ;
		}
}

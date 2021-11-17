import java.util.*;

public class MasterMind 
{
  public static void main(String[] args)
  {
	ArrayList<Integer> comArray = new ArrayList<Integer>();
	ArrayList<Integer> comArrayCopy = new ArrayList<Integer>();
	ArrayList<Integer> userArray = new ArrayList<Integer>();
	ArrayList<Integer> pegArray = new ArrayList<Integer>();
	int userNum;
	int numOfGuesses = 0;
	int redPeg = 0;
	int whitePeg = 0;
	boolean gameOver = false;
	
	comArray = fillComArray();
	comArrayCopy = copyArray(comArray);
	
	while (!gameOver)
	{
	  Scanner keyboard = new Scanner(System.in);
	  System.out.println("Guess a 4 digit number with each digit being between 0-4.");
	  userNum = keyboard.nextInt();
	  userArray = userNumToArray(userNum);
	  pegArray = numOfRedPegs(comArrayCopy, userArray);
	  redPeg = pegArray.get(0);
	  whitePeg = pegArray.get(1);
	  System.out.println("You correctly got " + whitePeg + " number(s) but they arn't in the correct spot");
	  System.out.println("You correctly got " + redPeg + " in the correct spot");
	  comArrayCopy = copyArray(comArray);
	  
	  if(numOfGuesses > 6 || redPeg == 4)
	  {
	    gameOver = true;
	  }
		
	  redPeg = 0;
	  numOfGuesses++;
	  
	} // end while
	
	System.out.println("");
	System.out.print("The Correct numbers and order was ");
	
	for(int i=0; i < (comArray.size()); i++) 
	{
	  System.out.print(comArray.get(i));
	}
	
	
	System.out.println("");
  } // end main
  
  private static ArrayList<Integer> copyArray(ArrayList<Integer> comArray) 
  {
	  ArrayList<Integer> comArrayCopy = new ArrayList<Integer>();
	  
	  for(int i=0; i < comArray.size(); i++)
	  {
	    comArrayCopy.add(comArray.get(i));
	  }
	   
	  return comArrayCopy;
  }  // end copyArray

//**********************************************
  
  // Checks to see number of redPegs 
 
  private static ArrayList<Integer> numOfRedPegs(ArrayList<Integer> comArray, ArrayList<Integer> userArray) 
  {
    ArrayList<Integer> pegArray = new ArrayList<Integer>();
	  int redPeg = 0;
	  int whitePeg = 0;
	
	  for(int i=0; i < (userArray.size()); i++)
	  {
      if(comArray.get(i) == userArray.get(i))
      {   
	      redPeg++;
	      comArray.remove(i);
	      userArray.remove(i);
	      i--;
	    }
	  }
	
    whitePeg = numOfWhitePegs(comArray, userArray);
	
	  pegArray.add(redPeg);
	  pegArray.add(whitePeg);
	
    return pegArray;
  } // end numOfRedPegs

private static int numOfWhitePegs(ArrayList<Integer> comArray, ArrayList<Integer> userArray) 
{
	
	int whitePeg = 0;
	
	for(int i=0; i < userArray.size(); i++)
	{
	  for(int j=0; j < comArray.size(); j++)
	  {
	    if(comArray.get(j) == userArray.get(i))
		  {
		    whitePeg++;
		    comArray.remove(j);
		    break;
		  }  
	  }
	}
	
	return whitePeg;
}  //end numOfWhitePegs

//****************************************************
  
  // Fills comArray with the correct  number values user needs to enter
  
  private static ArrayList<Integer> fillComArray()
  {  
    ArrayList<Integer> comArray = new ArrayList<Integer>();
	  
    for(int i=0; i < 4; i++) 
    {
      comArray.add((int)(Math.random() * 5));
    }
		
    return comArray;
  } // end fillComArray

  //****************************************************

  // breaks down 4 digit number into single numbers and puts them in an array

  private static ArrayList<Integer> userNumToArray(int guess) 
  {
    int firstNum = guess/1000;
    int secondNum = (guess - (firstNum * 1000))/ 100;
    int thirdNum = ((guess-(secondNum * 100))- (firstNum * 1000))/10;
    int forthNum = (guess-(thirdNum * 10))- ((firstNum * 1000) + (secondNum * 100));
    ArrayList<Integer> userArray = new ArrayList<Integer>();
    
    userArray.add(firstNum);
    userArray.add(secondNum);
    userArray.add(thirdNum);
    userArray.add(forthNum);
    
    return userArray;
  } // end userNumToArray
} // end class MasterMind

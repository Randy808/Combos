package combos;

public class CrackCombo
{
	 private static Boolean found;//a Boolean that says whether the desired number has been found in the series of CrackCombos
	 private static int[] numbers; //set of numbers entered as input 
	 private int itr;//iterates through set of 'numbers'
	 private static int desiredValue; //holds the desired value 
	 private char symbol;//contains operation symbol performed the last iteration to get current value
	 private int value;//result of parameter symbol operation between the next number in the array and the current value
	 private CrackCombo next;//a pointer to it's parent operation
	 
	 
	 
	 CrackCombo(int desiredValue, int[] numbers)
	 {
		 //STATIC VARIABLES
		 this.found = false;
		 
		 //STATIC CONST VARIABLES
		 this.numbers = numbers;
		 this.desiredValue = desiredValue;
		 
		 //INITIAL VALUES
		 this.symbol = ' ';
		 this.value = numbers[0];
		 this.next = null;
		 
		 itr = 1;
		 
		 makeTree();
	 }
	 
	 CrackCombo(char symbol, int value,CrackCombo next, int itr) //For creating chained CrackCombo instances branching from first instance
	 {
		 
		 this.symbol = symbol;
		 this.value = value;
		 this.next = next;
		 this.itr = itr+1;
		 
		 
		 
		 found = checkValue();
		 
		 if(this.itr < numbers.length  && found == false)
		 {
			 makeTree();
		 }
		 else if(found)
		 {
			 showCrackCombos();
		 }
		 else
		 {
			 //showCrackCombos();//uncomment to see all operations performed and all values at terminal leaf nodes
			 
		 }
	 }
	 
	 Boolean checkValue()
	 {
		if(value == desiredValue)
			return true;
		else
			return false;
		 
	 }
	 
	 public void makeTree()
	 {

		 new CrackCombo('+',value + numbers[itr],this,itr);
		 new CrackCombo('-',value - numbers[itr],this,itr);
		 new CrackCombo('*',value * numbers[itr],this,itr);
		 new CrackCombo('/',value / numbers[itr],this,itr);
		
	 }
	 
	 private void showCrackCombos()
	 {
		 CrackCombo list;
		 list = this;
		 
		 int CrackComboResult = list.value;
		 String rCrackCombosPerformed = "";
		 
		 int numItr = numbers.length - 1;
		 
		 
		 for(int i = numItr ; i >= 0 ; i--)
		 {
			 if(numbers[i] > 9)
			 {
				 rCrackCombosPerformed += new StringBuilder(Integer.toString(numbers[i])).reverse().toString(); // fixes formatting problems
			 }
			 else
			 {
				 rCrackCombosPerformed +=(numbers[i]);
			 }
			 
			 if(list != null)
			 {
				 rCrackCombosPerformed +=list.symbol;
				 list = list.next;
			 }
		 }
		 
		 String CrackCombosPerformed = new StringBuilder(rCrackCombosPerformed).reverse().toString();
		 System.out.println(CrackCombosPerformed + " = " + CrackComboResult);
		 
		 
	 }
}

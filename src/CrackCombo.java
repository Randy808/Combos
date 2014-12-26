package combos;

public class CrackCombo
{
	 private static Boolean found;//a Boolean that says whether the desired number has been found in the series of CrackCombos
	 private static int[] numbers; //set of numbers entered as input *note* make const
	 private int itr;//iterates through set of 'numbers'
	 private static int desiredValue; //holds the desired value make const
	 private char symbol;
	 private int value;
	 private CrackCombo next;
	 
	 
	 
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
//		 System.out.println(symbol + "! ITR : " + this.itr + " !" + numbers[this.itr]);
		 
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
			 showCrackCombos();
			 System.out.println("Done");
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
		 //list = list.next;
		 
		 int numItr = numbers.length - 1;
		 
		 /*while(list != null)
		 {
			 System.out.println("|NUM|" + numItr);
			 rCrackCombosPerformed +=(numbers[numItr] + " " + list.symbol + " ");
			 list = list.next;
			 numItr--;
			 
		 }*/
		 
		 for(int i = numItr ; i >= 0 ; i--)
		 {
			 rCrackCombosPerformed +=(numbers[i]);
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

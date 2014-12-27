package combos;

public class CrackCombo
{
	 private static Boolean found;//a Boolean that says whether the desired number has been found in the series of CrackCombos
	 private static double[] numbers; //set of numbers entered as input 
	 private int itr;//iterates through set of 'numbers'
	 private static double desiredValue; //holds the desired value 
	 private char symbol;//contains operation symbol performed the last iteration to get current value
	 private double value;//result of parameter symbol operation between the next number in the array and the current value
	 private CrackCombo next;//a pointer to it's parent operation
	 private String operation;//shows numbers perfomed on and the accompanying operation
	 
	 
	 
	 CrackCombo(int desiredValue, double[] numbers)
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
		 operation = value + " + 0";
		 
		 itr = 1;
		 
		 makeTree();
	 }
	 
	 CrackCombo(char symbol, double value,CrackCombo next, int itr, String operation) //For creating chained CrackCombo instances branching from first instance
	 {
		 
		 this.symbol = symbol;
		 this.value = value;
		 this.next = next;
		 this.itr = itr+1;
		 this.operation = operation;
		 
		 
		 
		 found = checkValue();
		 
		 if(this.itr < numbers.length )//if it hasn't iterated through every number in the set
		 {
			 makeTree();//make more branches
		 }
		 else if(found)//if it has iterated through every number in the set and found is true
		 {
			 showCrackCombos();//show the accompanying operations
		 }
		 else if(this.value <= 18 && this.value > 15)
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

		 new CrackCombo('+',value + numbers[itr],this,itr,value + "+" + numbers[itr]);
		 new CrackCombo('*',value * numbers[itr],this,itr,value + "*" + numbers[itr]);
		 
		 new CrackCombo('-',value - numbers[itr],this,itr,value + "-" + numbers[itr]);
		 new CrackCombo('-',numbers[itr] - value,this,itr,numbers[itr] + "-" + value);
		 
		 if(numbers[itr] != 0) // stops the tree from creating a run time error
			 new CrackCombo('/',value / numbers[itr],this,itr,value + "/" + numbers[itr]);
		 if(value != 0) // stops the tree from creating a run time error
			 new CrackCombo('/',numbers[itr] / value,this,itr,numbers[itr] + "/" + value);
		
	 }
	 
	 private void showCrackCombos()
	 {
		 
		 CrackCombo list;
		 list = this;
		 
		 String operationList = "";
		 StringBuilder format = new StringBuilder(operationList);
		 while(list != null)
		 {
			 format.insert(0, "(" + list.operation + ") " + " = " + list.value + "\n" );
			 list = list.next;
		 }
		
		 System.out.println(format.toString());
		 
		 
	 }
}

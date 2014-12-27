package combos;
import java.util.*;

public class Combos {
	
	public static void main(String args[])
	{
		//Double[] testCase = {(double) 1, (double) 2, (double) 3};
		Integer [] testCase = {13, 18, 9, 9, 120};
		final int DESIRED_VALUE = 17;
	    
		//CrackCombo node = new CrackCombo( (Double)6.000, testCase);
		
		ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(testCase));
		ArrayList<Integer> realTest = new ArrayList<Integer>(test);
		CreateCombinations comboMaker = new  CreateCombinations(new ArrayList<Integer>(realTest),DESIRED_VALUE);
		
	}

}




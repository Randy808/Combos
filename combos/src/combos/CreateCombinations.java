package combos;

import java.util.ArrayList;

public class CreateCombinations {
	
	public static Integer[] currentCombo; //holds the combo created by each full iteration of createCombos
	public static int desiredValue;
	
	public CreateCombinations(ArrayList<Integer> inputArray,int desiredValue) {
		
		this.desiredValue = desiredValue;
		currentCombo = (Integer[]) inputArray.toArray(new Integer[inputArray.size()]);
		createCombos(inputArray);
	}
	public void createCombos (ArrayList<Integer> inputArray )
	{
		
		if(inputArray.size() > 0)
		{
			for(int i = 0 ; i < inputArray.size() ; i++)
			{
				currentCombo[currentCombo.length - inputArray.size()] = inputArray.get(i);

				//System.out.println(currentCombo[i]);
				ArrayList inputArray2 = new ArrayList(inputArray);
				inputArray2.remove(i);
				
				createCombos(inputArray2);
			}
		}
		else
		{
			Double[] testCase = new Double[currentCombo.length];
			for(int i = 0 ; i < currentCombo.length ; i++)
			{
				testCase[i] = currentCombo[i].doubleValue();
				//System.out.print(currentCombo[i] + " ");
			}
			//System.out.println();
			
			
			CrackCombo node = new CrackCombo( new Integer(desiredValue).doubleValue() , testCase );
		}
		
	}
}

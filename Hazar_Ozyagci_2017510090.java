import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Hazar_Ozyagci_2017510090 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = null;
		try {br = new BufferedReader(new FileReader("Blosum62.txt"));}
		catch(FileNotFoundException e) {System.out.println("Txt file is not found. Be sure with the file location");}
		
		String input = br.readLine();
		
		input = br.readLine();
		String[] coordinateTracker = input.split("  ");
		
		coordinateTracker[1] = "A"; 
		
		int[][] matrix = new int[24][24];
		
		String line[];
		
		int row = 1;
		
		while ((input = br.readLine()) != null) {
            line = input.split(" ");
            if(line[0].equalsIgnoreCase("*"))
            	break;
            int i = 1;
            int j = 1;
            while(j < matrix[0].length) {
            	if(!line[i].equals("")) {
            		matrix[row][j] = Integer.parseInt(line[i]);
            		j++;
            	}//if
            	i++;
			}//while end
            row++;
		}//while end.
		
		
		
		String firstInput = "MKTERPRPNTFIIRCLQWTTVIERTFHVETPEEREEWTTAIQTVADGLKKQEEEE";
		String secondInput = "CQLMKTERPRPNTFVIRCLQWTTVIERTFHVDSPDEREEWMRAIQMVANSLKQRGPG";
		
		ProteinSequence(matrix,coordinateTracker,firstInput,secondInput);
		
	}
	
	public static int ProteinSequence(int[][] matrix, String[] coordinateTracker,String firstInput, String secondInput)
	{
		int[][] optimal = new int[secondInput.length()+1][firstInput.length()+1]; 
		String[][]direction = new String[secondInput.length()+1][firstInput.length()+1];
		
		for (int i = 1; i < optimal[0].length; i++) {
			optimal[0][i] = i*5*-1;
		}
		for (int i = 1; i < optimal.length; i++) {
			optimal[i][0] = i*5*-1;
		}
		for (int i = 1; i < direction[0].length; i++) {
			direction[0][i] = "left";
		}
		for (int i = 1; i < direction.length; i++) {
			direction[i][0] = "up";
		}
		
		int crossPoint = 0;
		for (int i = 1; i < optimal.length; i++) {
			for (int j = 1; j < optimal[0].length; j++) {
				crossPoint = optimal[i-1][j-1] + findPoint(matrix,coordinateTracker,secondInput.charAt(i-1) + "",firstInput.charAt(j-1) +"");
				if(crossPoint >= optimal[i-1][j]-5 &&crossPoint >= optimal[i][j-1]-5) 
				{
					optimal[i][j] = crossPoint;
					direction[i][j] = "cross";
				}
				else if(optimal[i-1][j]-5>=optimal[i][j-1]-5) 
				{
					optimal[i][j] = optimal[i-1][j]-5;
					direction[i][j] = "up";
				}
				else
				{
					optimal[i][j] = optimal[i][j-1]-5;
					direction[i][j] = "left";
				}
			}
		}
		
		printAlignment(direction,firstInput,secondInput);
		return 0;
	}
	
	public static void printAlignment(String[][] direction,String firstInput,String secondInput){
		int row = direction.length-1;
		int column = direction[0].length-1;
		String st = "";
		String st2 = "";
		while(true)
		{
			if(direction[row][column] == null)
				break;
			else if(direction[row][column].equalsIgnoreCase("cross"))
			{
				st = firstInput.charAt(column-1) + st; 
				st2 = secondInput.charAt(row-1) + st2;
				row--;
				column--;
			}
			else if(direction[row][column].equalsIgnoreCase("up"))
			{
				st = "-" + st; 
				if(row!=0)
					st2 = secondInput.charAt(row-1) + st2;
				else
					st2 = secondInput.charAt(row) + st2;
				row--;
			}
			else if(direction[row][column].equalsIgnoreCase("left"))
			{
				if(column!=0)
					st = firstInput.charAt(column-1) + st;  
				else
					st = firstInput.charAt(column) + st;
				st2 = "-" + st2;
				column--;
			}
		}
		System.out.println(st);
		System.out.println(st2);
		
	}
	
	public static int findPoint(int[][] matrix, String coordinate[],String one,String two) {
		int row = -1;
		int column = -1;
		for (int i = 1; i < coordinate.length; i++) {
			if(coordinate[i].equalsIgnoreCase(one))
				row = i;
			if(coordinate[i].equalsIgnoreCase(two)) 
				column = i;
		}
		return matrix[row][column];		
	}
	
	public static void printArray(int optimal[][]) {
		for (int i = 0; i < optimal.length; i++) {
			for (int j = 0; j < optimal[0].length; j++) {
				System.out.print(optimal[i][j] + " ");
			}
			System.out.println();
		}
	}

}

import java.util.Scanner;
import java.io.*;

public class KnightsOnABoard{

public static void main(String[] args) throws Exception {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a file name");
	String fileName = sc.nextLine();
	
	File file = validateFile(fileName);
	
	//check whether data is correct in file
	boolean r = validateData(file);
	while(r == false) {
		System.out.println("Invalid Data in file");
		fileName = sc.nextLine();
		file = validateFile(fileName);
		
		r = validateData(file);
	}

	Scanner scnr = new Scanner(file);
	int[][] eight = populateBoard(file);
		
	System.out.println("The board looks as follows:");
	printBoard(eight);
	
	if(cannotCapture(eight) == false) {
		System.out.println("No knights can capture any other knights.");		
	}
	else {
		System.out.println("There is at least one knight which can capture another knight.");	
	}
	scnr.close();
	sc.close();
}

	//code to check if file exists.
	public static File validateFile(String inputFile) {
		Scanner sc = new Scanner(System.in);
		String hold = inputFile;
		File valid = new File(hold);
		
		while(!valid.exists()) {
			System.out.println("File doesn't exist, enter another.");	
			hold = sc.nextLine();
			valid = new File(hold);
		} 
		return valid;
	}

	
	//code to check if the data in the file is valid.
	public static boolean validateData(File inputFile) throws Exception {
		File check = inputFile;	
	
		Scanner s = new Scanner(check);			
		Scanner w = new Scanner(System.in);	
	
		int count = 0;
		int temp = 0;
		boolean valid = true;	

		// checks to see if the file is good in number. Need 64 ints
		while(s.hasNextInt()) {
			temp = s.nextInt();
			count++;		
		}
	
		if(count != 64) {	
			valid = false;
		}
		return valid;
		
	}
	

	//code to populate the board 
	public static int[][] populateBoard(File inputFile) throws Exception {
		
		//inputs all 64 numbers into array correctly
		int temp;
		boolean check1 = true;
		boolean check2 = true;
		int[][] arr = new int[8][8];
		File file1 = inputFile;
		Scanner scan = new Scanner(file1);
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				temp = scan.nextInt();
				if(temp > 1) {
					check1 = false;
					System.out.println("Changed Value greater than 1 to 1");
					arr[i][j] = 1;
				}
				else if(temp < 0){
					check2 = false;
					System.out.println("Changed Value less than 0 to 0");
					arr[i][j] = 0;	
				}
				else {
					arr[i][j] = temp;
				}
			}
		}
		return arr;
	}
	
	//print board
	public static void printBoard(int[][]chessBoard) {
		int count = 0;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				count++;
				if(count == 8) {	
					System.out.println(chessBoard[i][j] + " ");
					count = 0;
				}
				else {
					System.out.print(chessBoard[i][j] + " ");
				}
			}
		}
	}

	//knights code
	public static boolean cannotCapture(int[][] chessBoard) {
		boolean check = false;
		int row1 = 0;
		int col2 = 0;
		int row2 = 0;
		int col1 = 0;
		int col_1 = 0;
		int col_2 = 0;
		int row_1 = 0;
		int row_2 = 0;

		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(chessBoard[i][j] == 1) {
					row1 = i + 1;
					col2 = j + 2;
					row2 = i + 2;
					col1 = j + 1;
					row_1 = i - 1;
					col_1 = j - 1;
					row_2 = i - 2;
					col_2 = j - 2;
					
					if(row1 >= 0 && row1 < 8 && col2 >= 0 && col2 < 8) {
						if(chessBoard[row1][col2] == 1) {
							check = true;
						}
						
					}

					if(row2 >= 0 && row2 < 8 && col1 >= 0 && col1 < 8) {
						if(chessBoard[row2][col1] == 1) {
							check = true;
						}

					}
					
					if(row_2 >= 0 && row_2 < 8 && col_1 >= 0 && col_1 < 8) {
						if(chessBoard[row_2][col_1] == 1) {
							check = true;
						}

					}
					
					if(row_2 >= 0 && row_2 < 8 && col1 >= 0 && col1 < 8) {
						if(chessBoard[row_2][col1] == 1) {
							check = true;
						}

					}
					
					if(row2 >= 0 && row2 < 8 && col_1 >= 0 && col_1 < 8) {
						if(chessBoard[row2][col_1] == 1) {
							check = true;
						}

					}

					if(row_1 >= 0 && row_1 < 8 && col_2 >= 0 && col_2 < 8) {
						if(chessBoard[row_1][col_2] == 1) {
							check = true;
						}

					}
					
					if(row_1 >= 0 && row_1 < 8 && col2 >= 0 && col2 < 8) {
						if(chessBoard[row_1][col2] == 1) {
							check = true;
						}

					}
					
					if(row1 >= 0 && row1 < 8 && col_2 >= 0 && col_2 < 8) {
						if(chessBoard[row1][col_2] == 1) {
							check = true;
						}

					}
				}
			}
		} 
		return check;
	}

}
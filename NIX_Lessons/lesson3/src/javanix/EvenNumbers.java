package javanix;

import java.util.Random;

public class EvenNumbers {

	public static void main(String[] args) {
		
		int[] numbersArray = new int[10];
		
		randomInitArray(numbersArray);
		
		for(int x : numbersArray)
			if(x % 2 == 0)
				System.out.print(x + " ");

	}
	
	public static void printArray(int[] array) {
		
		for(int item : array)
			System.out.print(item + " ");
		
	}
	
	public static void randomInitArray(int[] array) {
		
		Random rand = new Random();
		
		for(int x = 0; x < array.length; x++)
			array[x] = rand.nextInt(-100, 101);

		
	}

}
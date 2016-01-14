package gameOfLife;

import java.util.Random;
import java.util.Scanner;

public class GameOfLife {
	static final int GENERATIONS=100;
	static Random rand = new Random();
	static boolean current[][] = new boolean[Life.ROWS][Life.COLS];
	static boolean next[][] = new boolean[Life.ROWS][Life.COLS];


	//make a random array of initial living cells
	static void gen(boolean a[][]){
		for(int i=0;i<Life.ROWS;++i){
			for(int j=0;j<Life.COLS;++j){
				if(rand.nextInt(100)<10)a[i][j]=true;
				else a[i][j]=false;
			}
		}
		return;
	}

	// check to see if two arrays are equal
	static boolean equal(final boolean a[][], final boolean b[][]) {
		int i, j;
		for (i = 0; i < Life.ROWS; ++i)
			for (j = 0; j < Life.COLS; ++j)
				if (a[i][j] != b[i][j])
					return false;
		return true;
	}

	//copy the b array into the a array
	static void copy(boolean a[][], final boolean b[][]) {
		for (int i = 0; i < Life.ROWS; ++i) {
			for (int j = 0; j < Life.COLS; ++j) {
				a[i][j] = b[i][j];
			}
		}
		return;
	}

	//print out the array
	static void print(final boolean a[][]) {
		for (int i = 0; i < Life.ROWS; ++i) {
			for (int j = 0; j < Life.COLS; ++j) {
				if (a[i][j]) {
					System.out.print('X');
				} else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
		return;
	}

	public static void main(String[] args) {

		int i=0;
		Scanner in = new Scanner(System.in);

		//initialze the cell array and print it out
		gen(current);
		print(current);

		while(i<GENERATIONS){
			Life life = new Life();
			//get a carriage return before the next generation
			//cin.get();
			in.nextLine();

			//give the current generation to life()
			//it puts the next generation into next
			life.life(current,next);

			//copy the next generation into the current
			copy(current,next);

			//print it out
			print(current);
			i++;
		}
		in.close();

	}

}

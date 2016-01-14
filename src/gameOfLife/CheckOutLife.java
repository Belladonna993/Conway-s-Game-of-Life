package gameOfLife;

import java.util.Random;

public class CheckOutLife {
	static final int GENERATIONS = 100;
	Random rand = new Random();
	Life life = new Life();

	// make a random array of initial living cells
	void gen(boolean[][] a) {
		for (int i = 0; i < Life.ROWS; ++i) {
			for (int j = 0; j < Life.COLS; ++j) {
				if (rand.nextInt(100) < 10)
					a[i][j] = true;
				else
					a[i][j] = false;
			}
		}
		return;
	}

	// check to see if two arrays are equal
	boolean equal(final boolean a[][], final boolean b[][]) {
		int i, j;
		for (i = 0; i < Life.ROWS; ++i)
			for (j = 0; j < Life.COLS; ++j)
				if (a[i][j] != b[i][j])
					return false;
		return true;
	}

	// copy the b array into the a array
	void copy(boolean a[][], final boolean b[][]) {
		for (int i = 0; i < Life.ROWS; ++i) {
			for (int j = 0; j < Life.COLS; ++j) {
				a[i][j] = b[i][j];
			}
		}
		return;
	}

	// print out the array
	void print(final boolean a[][]) {
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

	boolean test(boolean[][] in, boolean[][] expected) {
		boolean current[][] = new boolean[Life.ROWS][Life.COLS];
		boolean next[][] = new boolean[Life.ROWS][Life.COLS];
		copy(current, in);
		life.life(current, next);
		if (equal(next, expected)) {
			System.out.println("PASSED");
			return true;
		} else {
			System.out.println("FAILED");
			System.out.println("input: ");
			print(current);
			System.out.println("output: ");
			print(next);
			System.out.println("expected:");
			print(expected);
			return false;
		}
	}

	// block test
	boolean test01() {
		boolean[][] in = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,	false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,	false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,	false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,	false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,	false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,	false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,	false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,	false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,	false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,	false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,	false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,	false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,	false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false } };

		boolean expected[][] = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, true, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, true, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false } };

		System.out.println("Test 01:  block test.");
		return test(in, expected);

	}

	// beehive test
	boolean test02() {
		boolean in[][] = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, false, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, false, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false } };

		boolean expected[][] = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, false, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, false, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false } };

		System.out.println("Test 02:  beehive test.");
		return test(in, expected);

	}

	// loaf test
	boolean test03() {
		boolean in[][] = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, true, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, false, false, true, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, true, false, true, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, true, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false } };

		boolean expected[][] = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, true, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, false, false, true, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, true, false, true, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, true, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false } };

		System.out.println("Test 03:  loaf test.");
		boolean testResult = test(in, expected);
		return testResult;

	}

	// boat test
	boolean test04() {
		boolean in[][] = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, true, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, false, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false } };

		boolean expected[][] = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, true, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, false, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false } };

		System.out.print("Test 04:  boat test.\n");
		return test(in, expected);
	}

	// blinker test
	boolean test05() {
		boolean in[][] = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false } };

		boolean expected[][] = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, true, true, true, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false } };

		System.out.print("Test 05:  blinker test.\n");
		return test(in, expected);
	}

	// toad test
	boolean test06() {
		boolean in[][] = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, true, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, true, true, true, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false } };

		boolean expected[][] = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, true, false, false, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, true, false, false, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false } };

		System.out.print("Test 06:  toad test.\n");
		return test(in, expected);
	}

	// beacon test
	boolean test07() {
		boolean in[][] = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, true, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, true, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, true, true, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, true, true, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false } };

		boolean expected[][] = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, true, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, true, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, true, true, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false } };

		System.out.print("Test 07:  beacon test.\n");
		return test(in, expected);

	}

	// pulsar test
	boolean test08() {
		boolean in[][] = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, true, true, true, false, false, false, true, true, true, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, true, false, false, false, false, true, false, true, false, false, false, false,
						true, false, false, false, false, false, false, false, false, false },
				{ false, false, false, true, false, false, false, false, true, false, true, false, false, false, false,
						true, false, false, false, false, false, false, false, false, false },
				{ false, false, false, true, false, false, false, false, true, false, true, false, false, false, false,
						true, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, true, true, true, false, false, false, true, true, true, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, true, true, true, false, false, false, true, true, true, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, true, false, false, false, false, true, false, true, false, false, false, false,
						true, false, false, false, false, false, false, false, false, false },
				{ false, false, false, true, false, false, false, false, true, false, true, false, false, false, false,
						true, false, false, false, false, false, false, false, false, false },
				{ false, false, false, true, false, false, false, false, true, false, true, false, false, false, false,
						true, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, true, true, true, false, false, false, true, true, true, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false } };

		boolean expected[][] = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, true, true, true, false, false, false, true, true, true, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, true, false, false, false, false, true, false, true, false, false, false, false,
						true, false, false, false, false, false, false, false, false, false },
				{ false, false, false, true, false, false, false, false, true, false, true, false, false, false, false,
						true, false, false, false, false, false, false, false, false, false },
				{ false, false, false, true, false, false, false, false, true, false, true, false, false, false, false,
						true, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, true, true, true, false, false, false, true, true, true, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, true, true, true, false, false, false, true, true, true, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, true, false, false, false, false, true, false, true, false, false, false, false,
						true, false, false, false, false, false, false, false, false, false },
				{ false, false, false, true, false, false, false, false, true, false, true, false, false, false, false,
						true, false, false, false, false, false, false, false, false, false },
				{ false, false, false, true, false, false, false, false, true, false, true, false, false, false, false,
						true, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, true, true, true, false, false, false, true, true, true, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false } };

		boolean current[][] = new boolean[Life.ROWS][Life.COLS];
		boolean next[][] = new boolean[Life.ROWS][Life.COLS];

		System.out.print("Test 08:  pulsar test.\n");
		copy(current, in);
		life.life(current, next);
		copy(current, next);
		life.life(current, next);
		copy(current, next);
		life.life(current, next);
		if (equal(next, expected)) {
			System.out.print("PASSED\n");
			return true;
		} else {
			System.out.print("FAILED\n");
			System.out.print("input:\n");
			print(current);
			System.out.print("output:\n");
			print(next);
			System.out.print("expected:\n");
			print(expected);
			return false;
		}
	}

	// glider test
	boolean test09() {
		boolean in[][] = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, true, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, true, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false } };

		boolean expected[][] = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, true, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, true, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, true, true, true, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false } };

		boolean current[][] = new boolean[Life.ROWS][Life.COLS];
		boolean next[][] = new boolean[Life.ROWS][Life.COLS];

		System.out.print("Test 09:  glider test.\n");
		copy(current, in);
		life.life(current, next);
		copy(current, next);
		life.life(current, next);
		copy(current, next);
		life.life(current, next);
		copy(current, next);
		life.life(current, next);
		if (equal(next, expected)) {
			System.out.print("PASSED\n");
			return true;
		} else {
			System.out.print("FAILED\n");
			System.out.print("input:\n");
			print(current);
			System.out.print("output:\n");
			print(next);
			System.out.print("expected:\n");
			print(expected);
			return false;
		}
	}

	// lightweight spaceship test
	boolean test10() {
		boolean in[][] = {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, true, true, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, true, true, true, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, true, true, false, true, true, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, true, true, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false } };

		boolean expected[][] = {
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,true,true,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,true,true,true,true,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,true,true,false,true,true,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,true,true,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false}				
				 };

		boolean current[][] = new boolean[Life.ROWS][Life.COLS];
		boolean next[][] = new boolean[Life.ROWS][Life.COLS];

		System.out.print("Test 10:  lightweight spaceship test.\n");
		copy(current, in);
		life.life(current, next);
		copy(current, next);
		life.life(current, next);
		copy(current, next);
		life.life(current, next);
		copy(current, next);
		life.life(current, next);
		if (equal(next, expected)) {
			System.out.print("PASSED\n");
			return true;
		} else {
			System.out.print("FAILED\n");
			System.out.print("input:\n");
			print(current);
			System.out.print("output:\n");
			print(next);
			System.out.print("expected:\n");
			print(expected);
			return false;
		}
	}

	public static void main(String[] args) {
		CheckOutLife me = new CheckOutLife();
		if (!me.test01()) {
			System.out.println("checkout aborted at test 01");
			System.exit(1);
		}
		if (!me.test02()) {
			System.out.print("checkout aborted at test 02\n");
			System.exit(1);
		}
		if (!me.test03()) {
			System.out.print("checkout aborted at test 03\n");
			System.exit(1);
		}
		if (!me.test04()) {
			System.out.print("checkout aborted at test 04\n");
			System.exit(1);
		}
		if (!me.test05()) {
			System.out.print("checkout aborted at test 05\n");
			System.exit(1);
		}
		if (!me.test06()) {
			System.out.print("checkout aborted at test 06\n");
			System.exit(1);
		}
		if (!me.test07()) {
			System.out.print("checkout aborted at test 07\n");
			System.exit(1);
		}
		if (!me.test08()) {
			System.out.print("checkout aborted at test 08\n");
			System.exit(1);
		}
		if (!me.test09()) {
			System.out.print("checkout aborted at test 09\n");
			System.exit(1);
		}
		if (!me.test10()) {
			System.out.print("checkout aborted at test 10\n");
			System.exit(1);
		}

		System.out.println("\nPassed all tests.\n");

	}

}

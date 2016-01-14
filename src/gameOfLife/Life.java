package gameOfLife;

public class Life {
	public static final int ROWS = 25;
	public static final int COLS = 25;

	// The rules of the Game Of Life are as follows:
	//
	// 1. Any live cell with fewer than two live neighbours dies, as if
	// caused by under-population.
	//
	// 2. Any live cell with two or three live neighbours lives on to the
	// next generation.
	//
	// 3. Any live cell with more than three live neighbours dies, as if by
	// overcrowding.
	//
	// 4. Any dead cell with exactly three live neighbours becomes a live cell,
	// as if by reproduction.

	void life(boolean current[][], boolean next[][]) {
		//copy current to next
	    for (int i = 0; i < ROWS; i++) {
	        for (int j = 0; j < COLS; j++) {
	            next[i][j] = current[i][j];
	        }
	    }

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				int neighborCount = 0;
				// Count the upstairs neighbors
				if (i > 0) {
					if (j > 0) {
						if (current[i - 1][j - 1]) {
							neighborCount++;
						}
					}
					if (current[i - 1][j]) {
						neighborCount++;
					}
					if (j < COLS - 1) {
						if (current[i - 1][j + 1]) {
							neighborCount++;
						}
					}
				}
				// Count the downstairs neighbors
				if (i < ROWS - 1) {
					if (j > 0) {
						if (current[i + 1][j - 1]) {
							neighborCount++;
						}
					}
					if (current[i + 1][j]) {
						neighborCount++;
					}
					if (j < COLS - 1) {
						if (current[i + 1][j + 1]) {
							neighborCount++;
						}
					}
				}
				// Count the left next door neighbor
				if (j > 0) {
					if (current[i][j - 1]) {
						neighborCount++;
					}
				}
				// Count the right next door neighbor
				if (j < COLS - 1) {
					if (current[i][j + 1]) {
						neighborCount++;
					}
				}
				// Kill the live ones
				if (current[i][j]) {
					// Kill the friendless ones
					if (neighborCount < 2) {
						next[i][j] = false;
					}
					// Kill the suffocating ones
					if (neighborCount > 3) {
						next[i][j] = false;
					}
				}
				// Birth the babies
				else if (!current[i][j] && neighborCount == 3) {
					next[i][j] = true;
				}
			}
		}
	}
}

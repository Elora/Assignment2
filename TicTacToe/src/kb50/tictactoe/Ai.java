package kb50.tictactoe;

import java.util.Random;

public class Ai {
	boolean medium;
	String[] btns = new String[9];

	// ai is circel
	// speler is kruis

	public Ai(String[] temp, boolean medium) {
		medium = medium;
		btns = temp;

	}

	public int move() {
		return winningMove();

	}

	private int winningMove() {
		// Rule 1: If I have a winning move, take it.

		for (int i = 0; i < 9; i++) {
			if (btns[i]==null) {
				btns[i] = "";
			}
		}

		// top row
		if (btns[0].equals("circle") && btns[1].equals("circle") && btns[2].equals("")) {
			return 2;
		}  if (btns[1].equals("circle") && btns[2].equals("circle") && btns[0].equals("")) {
			return 0;
		}  if (btns[0].equals("circle") && btns[2].equals("circle") && btns[1].equals("")) {
			return 1;
		}
		// second row
		if (btns[3].equals("circle") && btns[4].equals("circle") && btns[5].equals("")) {
			return 5;
		} if (btns[4].equals("circle") && btns[5].equals("circle") && btns[3].equals("")) {
			return 3;
		} if (btns[3].equals("circle") && btns[5].equals("circle") && btns[4].equals("")) {
			return 4;
		}
		// 3e row
		if (btns[6].equals("circle") && btns[7].equals("circle") && btns[8].equals("")) {
			return 8;
		} if (btns[7].equals("circle") && btns[8].equals("circle") && btns[6].equals("")) {
			return 6;
		} if (btns[6].equals("circle") && btns[8].equals("circle") && btns[7].equals("")) {
			return 7;
		}

		// vert 0 3 6
		if (btns[0].equals("circle") && btns[3].equals("circle") && btns[6].equals("")) {
			return 6;
		} if (btns[0].equals("circle") && btns[6].equals("circle") && btns[3].equals("")) {
			return 3;
		} if (btns[3].equals("circle") && btns[6].equals("circle") && btns[0].equals("")) {
			return 0;
		}

		// vert 1 4 7
		if (btns[1].equals("circle") && btns[4].equals("circle") && btns[7].equals("")) {
			return 7;
		} if (btns[1].equals("circle") && btns[7].equals("circle") && btns[4].equals("")) {
			return 4;
		} if (btns[4].equals("circle") && btns[7].equals("circle") && btns[1].equals("")) {
			return 1;
		}
		// vert 2 5 8
		if (btns[2].equals("circle") && btns[5].equals("circle") && btns[8].equals("")) {
			return 8;
		} if (btns[2].equals("circle") && btns[8].equals("circle") && btns[5].equals("")) {
			return 5;
		} if (btns[5].equals("circle") && btns[8].equals("circle") && btns[2].equals("")) {
			return 2;
		} else {
			return blockWinningMove();
		}

	}

	private int blockWinningMove() {
		// Rule 2: If the opponent has a winning move, block it.
		// top row
		if (btns[0].equals("cross") && btns[1].equals("cross") && btns[2].equals("")) {
			return 2;
		} if (btns[1].equals("cross") && btns[2].equals("cross") && btns[0].equals("")) {
			return 0;
		} if (btns[0].equals("cross") && btns[2].equals("cross") && btns[1].equals("")) {
			return 1;
		}
		// second row
		if (btns[3].equals("cross") && btns[4].equals("cross") && btns[5].equals("")) {
			return 5;
		} 
		if (btns[4].equals("cross") && btns[5].equals("cross") && btns[3].equals("")) {
			return 3;
		}
		if (btns[3].equals("cross") && btns[5].equals("cross") && btns[4].equals("")) {
			return 4;
		}
		// 3e row
		if (btns[6].equals("cross") && btns[7].equals("cross") && btns[8].equals("")) {
			return 8;
		}  if (btns[7].equals("cross") && btns[8].equals("cross") && btns[6].equals("")) {
			return 6;
		} if (btns[6].equals("cross") && btns[8].equals("cross") && btns[7].equals("")) {
			return 7;
		}

		// vert 0 3 6
		if (btns[0].equals("cross") && btns[3].equals("cross") && btns[6].equals("")) {
			return 6;
		} if (btns[0].equals("cross") && btns[6].equals("cross") && btns[3].equals("")) {
			return 3;
		} if (btns[3].equals("cross") && btns[6].equals("cross") && btns[0].equals("")) {
			return 0;
		}

		// vert 1 4 7
		if (btns[1].equals("cross") && btns[4].equals("cross") && btns[7].equals("")) {
			return 7;
		} if (btns[1].equals("cross") && btns[7].equals("cross") && btns[4].equals("")) {
			return 4;
		} if (btns[4].equals("cross") && btns[7].equals("cross") && btns[1].equals("")) {
			return 1;
		}
		// vert 2 5 8
		if (btns[2].equals("cross") && btns[5].equals("cross") && btns[8].equals("")) {
			return 8;
		} if (btns[2].equals("cross") && btns[8].equals("cross") && btns[5].equals("")) {
			return 5;
		} if (btns[5].equals("cross") && btns[8].equals("cross") && btns[2].equals("")) {
			return 2;
		} else {
			if (medium = true) {
				return moveMedium();
			} else {
				return moveHard();
			}
		}

	}

	private int moveMedium() {
		while (true) {
			int ran = new Random().nextInt(9);
			if (btns[ran] == "") {
				return ran;
			}
		}

	}

	private int moveHard() {
		return 0;
		/*
		 * Rule 3: If I can create a fork (two winning ways) after this move, do
		 * it. Rule 4: Do not let the opponent creating a fork after my move.
		 * (Opponent may block your winning move and create a fork.) Rule 5:
		 * Place in the position such as I may win in the most number of
		 * possible ways.
		 * 
		 * Rule 1 and 2 can be programmed easily. Rule 3 is harder. Rule 4 is
		 * even harder because you need to lookahead one opponent move, after
		 * your move. For rule 5, you need to count the number of possible
		 * winning ways.
		 * 
		 * Rule-based strategy is only applicable for simple game such as
		 * Tic-tac-toe and Othello.
		 */
	}
}

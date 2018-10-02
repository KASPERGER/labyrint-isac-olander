package labyrint;

import java.util.ArrayList;

import Blocks.Block;
import Blocks.ClosedBlock;
import Blocks.GoalBlock;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MapSolver {

	Map map;

	boolean vinst = false;

	ArrayList<Block> visitedblock = new ArrayList<Block>();
	ArrayList<Circle> path = new ArrayList<Circle>();

	MapSolver(int startX, int startY, Map map) {

		this.map = map;

		solvish(startX, startY, 1);
		visitedblock.clear();
		solvish(startX, startY, 2);
		solvish(startX, startY, 3);
		solvish(startX, startY, 4);
	}

	private void solvish(int x, int y, int dir) {

		switch (dir) {
		case 1: // 1 upp
			y++;
			break;
		case 2: // 2 höger
			x++;
			break;
		case 3: // 3 ner
			y--;
			break;
		case 4: // 4 vänster
			x--;
			break;

		default:
			break;
		}

		Block blocke = map.getBlock(x, y);

		if (visitedblock.contains(blocke)) {

			return;

		}

		else {

			visitedblock.add(blocke);

		}

		if (blocke instanceof GoalBlock) {

			vinst = true;
			return;

		}

		if (blocke instanceof ClosedBlock || blocke == null || vinst) {

			return;

		}

		double cirkelStorlek = Block.SIZE / 2;

		path.add(
				new Circle(x * Block.SIZE + cirkelStorlek, y * Block.SIZE + cirkelStorlek, cirkelStorlek, Color.PURPLE));

		if (dir == 1) {

			solvish(x, y, 4);
			solvish(x, y, 2);
			solvish(x, y, 1);
		}

		if (dir == 2) {

			solvish(x, y, 2);
			solvish(x, y, 1);
			solvish(x, y, 3);
		}

		if (dir == 3) {

			solvish(x, y, 3);
			solvish(x, y, 4);
			solvish(x, y, 2);
		}

		if (dir == 4) {

			solvish(x, y, 4);
			solvish(x, y, 1);
			solvish(x, y, 3);
		}

		if (!vinst) {

			path.remove(path.get(path.size() - 1));
		}

	}
}

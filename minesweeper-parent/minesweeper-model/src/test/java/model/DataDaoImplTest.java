package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DataDaoImplTest {

	private static Data[][] generateBoard(int xTiles, int yTiles) {
		Data board[][] = new Data[xTiles][yTiles];
		for (int y = 0; y < yTiles; y++) {
			for (int x = 0; x < xTiles; x++) {
				Data filled = new Data(x, y, Math.random() < 0.1);
				board[x][y] = filled;
			}
		}
		return board;
	}

	@Test
	public void testDataDaoImpl() {
		DataDao daoImpl = new DataDaoImpl();
		assertNotNull(daoImpl);
	}

	@Test
	public void testIsValidTile() {
		DataDaoImpl daoImpl = new DataDaoImpl();
		daoImpl.setxTiles(10);
		daoImpl.setyTiles(10);
		assertEquals(daoImpl.isValidTile(9, 9), true);
		assertEquals(daoImpl.isValidTile(0, 0), true);
		assertEquals(daoImpl.isValidTile(10, 10), false);
	}

	@Test
	public void testIsDone() {
		DataDaoImpl daoImpl = new DataDaoImpl();
		daoImpl.setxTiles(10);
		daoImpl.setyTiles(10);
		Data board[][] = generateBoard(daoImpl.getxTiles(), daoImpl.getyTiles());
		assertFalse(daoImpl.isDone(board));
		for (int i = 0; i < daoImpl.getxTiles(); i++) {
			for (int j = 0; j < daoImpl.getyTiles(); j++) {
				if (board[i][j].isMine()) {
					board[i][j].setFlagged(true);
					continue;
				}
				if (!board[i][j].isRevealed()) {
					board[i][j].setRevealed(true);
				}
			}
		}
		assertTrue(daoImpl.isDone(board));
	}

	@Test
	public void testGetNeighbours() {
		DataDaoImpl dataDaoImpl = new DataDaoImpl();
		dataDaoImpl.setxTiles(5);
		dataDaoImpl.setyTiles(5);
		Data board[][] = generateBoard(5, 5);
		assertEquals(8, dataDaoImpl.getNeighbours(board[2][2], board).size());
		assertFalse(7 == dataDaoImpl.getNeighbours(board[2][2], board).size());
		assertEquals(3, dataDaoImpl.getNeighbours(board[0][0], board).size());
		assertFalse(8 == dataDaoImpl.getNeighbours(board[4][4], board).size());
	}

	@Test
	public void testGetxTiles() {
		DataDaoImpl daoImpl = new DataDaoImpl();
		daoImpl.setxTiles(5);
		assertEquals(5, daoImpl.getxTiles());
		daoImpl.setxTiles(4);
		assertFalse(daoImpl.getxTiles() == 3);
		assertEquals(4, daoImpl.getxTiles());
	}

	@Test
	public void testSetxTiles() {
		DataDaoImpl daoImpl = new DataDaoImpl();
		daoImpl.setxTiles(5);
		assertEquals(5, daoImpl.getxTiles());
		daoImpl.setxTiles(4);
		assertFalse(daoImpl.getxTiles() == 3);
		assertEquals(4, daoImpl.getxTiles());
	}

	@Test
	public void testGetyTiles() {
		DataDaoImpl daoImpl = new DataDaoImpl();
		daoImpl.setyTiles(234);
		assertEquals(234, daoImpl.getyTiles());
		assertFalse(daoImpl.getyTiles() == 3);
		daoImpl.setyTiles(4);
		assertEquals(4, daoImpl.getyTiles());

	}

	@Test
	public void testSetyTiles() {
		DataDaoImpl daoImpl = new DataDaoImpl();
		daoImpl.setyTiles(234);
		assertEquals(234, daoImpl.getyTiles());
		assertFalse(daoImpl.getyTiles() == 3);
		daoImpl.setyTiles(4);
		assertEquals(4, daoImpl.getyTiles());

	}

}

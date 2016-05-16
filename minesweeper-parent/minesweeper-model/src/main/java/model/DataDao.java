package model;

import java.util.List;

/**
 * 
 * Az adatok kezelését leíró interfész.
 *
 */
public interface DataDao {

	/**
	 * Visszaadja, hogy a paraméterként kapott {@code x} és {@code y} koordináta
	 * rajta van-e a táblán.
	 * 
	 * @param x
	 *            a mező x koordinátája
	 * @param y
	 *            a mező y koordinátája
	 * 
	 * @return {@code true}, ha a {@code x} és {@code y} koordináta rajta van a
	 *         táblán, egyébként {@code false}
	 */
	boolean isValidTile(int x, int y);

	/**
	 * Visszaadja, hogy a paraméterként kapott {@link model.Data} típusú
	 * {@code board} mátrix sikeresen meg lett-e oldva.
	 * 
	 * @param board a paraméterként kapott {@link model.Data} mátrix
	 * 
	 * @return {@code true}, ha a {@code board} jól lett megoldva, egyébként
	 *         {@code false}
	 */
	boolean isDone(Data[][] board);

	/**
	 * Visszaadja az elmentett játékok {@link model.Game#getId()} id-jait.
	 * 
	 * @return egy {@link java.util.List} objektum
	 */
	public List<String> getSavedGameIds();

	/**
	 * Betölti az elmentett játékok adatbázisát.
	 * 
	 * @return egy {@link model.Games} objektum
	 */
	public Games loadMines();

	/**
	 * Elmenti a paraméterként kapott {@link model.Data} típusú {@code board}
	 * mátrixot.
	 * 
	 * @param board
	 *            a paraméterként kapott {@link model.Data} mátrix
	 */
	public void saveMines(Data board[][]);

	/**
	 * Visszaadja a paraméterként kapott mező szomszédait, a paraméterként
	 * kapott mátrixból.
	 * 
	 * @param tile
	 *            a paraméterként kapott mező
	 * @param board
	 *            a paraméterként kapott {@link model.Data} mátrix
	 * @return egy {@link java.util.List} objektum, a paraméterként kapott mező
	 *         szomszédai
	 */
	List<Data> getNeighbours(Data tile, Data[][] board);

}

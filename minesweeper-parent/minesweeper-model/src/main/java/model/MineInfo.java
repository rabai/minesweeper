package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Egy mező értékeit reprezentáló osztály, melyet az adatbázis használ.
 *
 */
@XmlRootElement(name = "field")
@XmlType(propOrder = { "x", "y", "mine", "revealed", "minesNear", "flagged" })
public class MineInfo {

	/**
	 * A mező x koordinátája.
	 */
	private int x;
	/**
	 * A mező y koordinátája.
	 */
	private int y;
	/**
	 * A mező bomba-e.
	 */
	private boolean isMine;
	/**
	 * A mező megjelenítésre került-e.
	 */
	private boolean isRevealed;
	/**
	 * Az aknák száma a mező körül.
	 */
	private int minesNear;
	/**
	 * A mezőt aknának megjelölte-e a felhasználó.
	 */
	private boolean isFlagged;

	/**
	 * Paraméter nélküli konstruktor egy MineInfo objektum létrehozására.
	 */
	public MineInfo() {
	}

	/**
	 * Hat paraméteres konstruktor egy MineInfo objektum létrehozására.
	 * 
	 * @param x
	 *            a mező x koordinátája
	 * @param y
	 *            a mező y koordinátája
	 * @param isMine
	 *            a mező bomba-e
	 * @param isRevealed
	 *            a mező megjelenítésre került-e
	 * @param minesNear
	 *            az aknák száma a mező körül
	 * @param isFlagged
	 *            az mezőt aknának jelölte-e a felhasználó
	 */
	public MineInfo(int x, int y, boolean isMine, boolean isRevealed, int minesNear, boolean isFlagged) {
		super();
		this.x = x;
		this.y = y;
		this.isMine = isMine;
		this.isRevealed = isRevealed;
		this.minesNear = minesNear;
		this.isFlagged = isFlagged;
	}

	/**
	 * Visszaadja a mező x koordinátáját.
	 * 
	 * @return a mező x koordinátája
	 */
	public int getX() {
		return x;
	}

	/**
	 * Beállítja a mező x koordinátáját.
	 * 
	 * @param x
	 *            a mező x koordinátája
	 */
	@XmlElement
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Visszaadja a mező y koordinátáját.
	 * 
	 * @return a mező y koordinátája
	 */
	public int getY() {
		return y;
	}

	/**
	 * Beállítja a mező y koordinátáját.
	 * 
	 * @param y
	 *            a mező y koordinátája
	 */
	@XmlElement
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Visszaadja, hogy a mező akna-e.
	 * 
	 * @return a mező akna-e
	 */
	public boolean isMine() {
		return isMine;
	}

	/**
	 * Beállítja, hogy a mező akna-e.
	 * 
	 * @param isMine
	 *            a mező akna-e
	 */
	@XmlElement
	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}

	/**
	 * Visszaadja, hogy az adott mező megjelenítésre került-e már.
	 * 
	 * @return az adott mező megjelenítésre került-e már
	 */
	public boolean isRevealed() {
		return isRevealed;
	}

	/**
	 * Beállítja az adott mező megjelenítését.
	 * 
	 * @param isRevealed
	 *            az adott mező megjelenítése
	 */
	@XmlElement
	public void setRevealed(boolean isRevealed) {
		this.isRevealed = isRevealed;
	}

	/**
	 * Visszaadja, hogy hány darab akna van a mező körül.
	 * 
	 * @return aknák száma a mező körül
	 */
	public int getMinesNear() {
		return minesNear;
	}

	/**
	 * Beállítja, hogy hány darab akna van a mező körül.
	 * 
	 * @param minesNear
	 *            aknák száma a mező körül
	 */
	@XmlElement
	public void setMinesNear(int minesNear) {
		this.minesNear = minesNear;
	}

	/**
	 * Visszaadja, hogy a mezőt aknának jelölte-e a felhasználó.
	 * 
	 * @return a mezőt aknának jelölte-e a felhasználó
	 */
	public boolean isFlagged() {
		return isFlagged;
	}

	/**
	 * Beállítja, hogy a mezőt aknának jelölte-e a felhasználó.
	 * 
	 * @param isFlagged
	 *            a mezőt aknának jelölte-e a felhasználó
	 */
	@XmlElement
	public void setFlagged(boolean isFlagged) {
		this.isFlagged = isFlagged;
	}

	@Override
	public String toString() {
		return "MineInfo [x=" + x + ", y=" + y + ", isMine=" + isMine + ", isRevealed=" + isRevealed + ", minesNear="
				+ minesNear + ", isFlagged=" + isFlagged + "]";
	}

}

package model;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Egy mező értékeit reprezentáló osztály, melyet a felület használ.
 */
public class Data extends StackPane {

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
	 * A mezőt aknának jelölte-e a felhasználó.
	 */
	private boolean isFlagged;
	/**
	 * A mező felületen való reprezentálására szolgáló {@link Rectangle}
	 * objektum.
	 */
	private Rectangle tile;
	/**
	 * A mező szövegének felületen való reprezentálására szolgáló {@link Text}
	 * objektum.
	 */
	private Text text;
	/**
	 * A mező grafikus {@link ImageView} képe.
	 */
	private ImageView picture;

	/**
	 * Paraméter nélküli konstruktor egy Data objektum létrehozására.
	 */
	public Data() {
	}

	/**
	 * Három paraméteres konstruktor egy Data objektum létrehozásásra.
	 * 
	 * @param x
	 *            a mező x koordinátája
	 * @param y
	 *            a mező y koordinátája
	 * @param isMine
	 *            a mező akna-e
	 */
	public Data(int x, int y, boolean isMine) {
		this.x = x;
		this.y = y;
		this.isMine = isMine;
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
	public void setMine(boolean isMine) {
		this.isMine = isMine;
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
	public void setMinesNear(int minesNear) {
		this.minesNear = minesNear;
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
	public void setRevealed(boolean isRevealed) {
		this.isRevealed = isRevealed;
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
	public void setFlagged(boolean isFlagged) {
		this.isFlagged = isFlagged;
	}

	/**
	 * Visszaadja a mező felületen való reprezentálására szolgáló
	 * {@link javafx.scene.shape.Rectangle} objektumot.
	 * 
	 * @return a mező felületen való reprezentálására szolgáló
	 *         {@link javafx.scene.shape.Rectangle} objektum
	 */
	public Rectangle getTile() {
		return tile;
	}

	/**
	 * Beállítja a mező felületen való reprezentálására szolgáló
	 * {@link javafx.scene.shape.Rectangle} objektumot.
	 * 
	 * @param tile
	 *            a mező felületen való reprezentálására szolgáló
	 *            {@link javafx.scene.shape.Rectangle} objektum
	 */
	public void setTile(Rectangle tile) {
		this.tile = tile;
	}

	/**
	 * Visszaadja a mező szövegének felületen való reprezentálására szolgáló
	 * {@link javafx.scene.text.Text} objektumot.
	 * 
	 * @return a mező szövegének felületen való reprezentálására szolgáló
	 *         {@link javafx.scene.text.Text} objektum
	 */
	public Text getText() {
		return text;
	}

	/**
	 * Beállítja a mező szövegének felületen való reprezentálására szolgáló
	 * {@link javafx.scene.text.Text} objektumot.
	 * 
	 * @param text
	 *            a mező szövegének felületen való reprezentálására szolgáló
	 *            {@link javafx.scene.text.Text} objektum
	 */
	public void setText(Text text) {
		this.text = text;
	}

	/**
	 * Visszaadja a mező grafikus {@link javafx.scene.image.ImageView} képét.
	 * 
	 * @return a mező grafikus {@link javafx.scene.image.ImageView} képe
	 */
	public ImageView getPicture() {
		return picture;
	}

	/**
	 * Beállítja a mező grafikus {@link javafx.scene.image.ImageView} képét.
	 * 
	 * @param picture
	 *            a mező grafikus {@link javafx.scene.image.ImageView} képe
	 */
	public void setPicture(ImageView picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Data [x=" + x + ", y=" + y + ", isMine=" + isMine + ", minesNear=" + minesNear + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isMine ? 1231 : 1237);
		result = prime * result + minesNear;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (isMine != other.isMine)
			return false;
		if (minesNear != other.minesNear)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}

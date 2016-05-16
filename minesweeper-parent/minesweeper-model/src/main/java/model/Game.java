package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Egy játékállást reprezentáló osztály.
 */
@XmlRootElement(name = "game")
public class Game {

	/**
	 * Egy {@link java.util.List}, mely {@link model.MineInfo} típusú
	 * objektumokat tartalmaz.
	 */
	private List<MineInfo> fields;

	/**
	 * A játékállás egyedi azonosítója.
	 */
	private String id;

	/**
	 * Paraméter nélküli konstruktor egy Game objektum létrehozására.
	 */
	public Game() {
		this.fields = new ArrayList<>();
	}

	/**
	 * Két paraméteres konstruktor egy Game objektum létrehozásásra.
	 * 
	 * @param mines
	 *            a játék mezői
	 * @param id
	 *            a játék egyedi azonosítója
	 */
	public Game(List<MineInfo> mines, String id) {
		this.fields = mines;
		this.id = id;
	}

	/**
	 * Visszaadja a játék egyedi azonosítóját.
	 * 
	 * @return a játék egyedi azonosítója
	 */
	@XmlAttribute
	public String getId() {
		return id;
	}

	/**
	 * Beállítja a játék egyedi azonosítóját.
	 * 
	 * @param id
	 *            a játék egyedi azonosítója
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Visszaadja a játék mezőinek listáját.
	 * 
	 * @return a játék mezőinek listája
	 */
	public List<MineInfo> getMines() {
		return fields;
	}

	/**
	 * Beállítja a játék mezőinek listáját.
	 * 
	 * @param mines
	 *            a játék mezőinek listája
	 */
	@XmlElement(name = "mine")
	public void setMines(List<MineInfo> mines) {
		this.fields = mines;
	}

	@Override
	public String toString() {
		return "Game [fields=" + fields + ", id=" + id + "]";
	}

}

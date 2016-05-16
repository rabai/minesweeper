package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Ősosztály, mely az adatbázis gyökér eleme.
 */
@XmlRootElement(name = "games")
public class Games {

	/**
	 * Egy {@link java.util.List}, mely {@link model.Game} típusú objektumokat
	 * tartalmaz, ami a játékok listája.
	 */
	private List<Game> games;

	/**
	 * Paraméter nélküli konstruktor egy Games objektum létrehozására.
	 */
	public Games() {
		this.games = new ArrayList<>();
	}

	/**
	 * Egy paraméteres konstruktor egy Games objektum létrehozására.
	 * 
	 * @param games
	 *            a játékok listája
	 */
	public Games(List<Game> games) {
		this.games = games;
	}

	/**
	 * Visszaadja a játékok listáját.
	 * 
	 * @return a játékok listája
	 */
	public List<Game> getGames() {
		return games;
	}

	/**
	 * Beállítja a játékok listáját.
	 * 
	 * @param games
	 *            a játékok listája
	 */
	@XmlElement(name = "game")
	public void setGames(List<Game> games) {
		this.games = games;
	}

	@Override
	public String toString() {
		return "Games [games=" + games + "]";
	}

}

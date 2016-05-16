package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * A {@link model.DataDao} interfész implementálása.
 *
 */
public class DataDaoImpl implements DataDao {

	/**
	 * A képernyőn megjelenítésre kerülő aknakereső szélességéhez használt
	 * érték.
	 */
	private static int xTiles;
	/**
	 * A képernyőn megjelenítésre kerülő aknakereső hosszúságához használt
	 * érték.
	 */
	private static int yTiles;

	private static final Logger logger = LoggerFactory.getLogger(DataDaoImpl.class);

	/**
	 * Paraméter nélküli konstruktor egy DataDaoImpl objektum létrehozására.
	 */
	public DataDaoImpl() {
	}

	/**
	 * Visszaadja, hogy a paraméterként kapott {@code x} és {@code y} koordináta
	 * rajta van-e a táblán.
	 * 
	 * @param x
	 *            a mező x koordinátája
	 * @param y
	 *            a mező y koordinátája
	 * 
	 * @return {@code true}, ha az {@code x} és {@code y} koordináta rajta van a
	 *         táblán, egyébként {@code false}
	 */
	@Override
	public boolean isValidTile(int x, int y) {
		if (x >= 0 && x < xTiles && y >= 0 && y < yTiles) {
			return true;
		}
		return false;
	}

	/**
	 * Visszaadja, hogy a paraméterként kapott {@link model.Data} típusú
	 * {@code board} mátrix sikeresen meg lett-e oldva.
	 * 
	 * @return {@code true}, ha a {@code board} jól lett megoldva, egyébként
	 *         {@code false}
	 */
	@Override
	public boolean isDone(Data[][] board) {

		int revealed = 0;
		int mines = 0;
		for (int i = 0; i < xTiles; i++) {
			for (int j = 0; j < yTiles; j++) {
				if (board[i][j].isRevealed()) {
					revealed++;
				}
				if (board[i][j].isMine() && board[i][j].isFlagged()) {
					mines++;
				}
			}
		}
		return xTiles * yTiles - revealed == mines;

	}

	/**
	 * Visszaadja az elmentett játékok {@link model.Game#getId()} id-jait.
	 * 
	 * @return savedGameIds egy {@link java.util.List} objektum, az elmentett
	 *         játékok {@link model.Game#getId()} id-jaival
	 */
	@Override
	public List<String> getSavedGameIds() {
		Games games;
		List<String> savedGameIds = null;
		games = loadMines();
		if(games == null){
			games = new Games();
			logger.info("INFO - Nem volt még elmentett játékállás.");
		}
		savedGameIds = new ArrayList<>(games.getGames().size());
		for (Game game : games.getGames()) {
			logger.debug("DEBUG - Hozzáadva a return listához: {}", game.getId());
			savedGameIds.add(game.getId());
		}
		return savedGameIds;
	}

	/**
	 * Betölti az elmentett játékok adatbázisát.
	 * 
	 * @return readGames a betöltött játékok
	 */
	@Override
	public Games loadMines() {
		File file = new File(System.getProperty("user.home") + "/mineSweeperApp", "/db.xml");
		file.mkdir();
		JAXBContext jaxbContext;
		Games readGames = null;
		try {
			jaxbContext = JAXBContext.newInstance(Games.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			readGames = (Games) jaxbUnmarshaller.unmarshal(file);
			logger.info("INFO - Sikeresen betöltve az adatbázis.");
		} catch (JAXBException e) {
			logger.error("ERROR - {}", e);
		}
		return readGames;
	}

	/**
	 * Elmenti a paraméterként kapott {@link model.Data} típusú {@code board}
	 * mátrixot.
	 * 
	 * @param board
	 *            a paraméterként kapott {@link model.Data} mátrix
	 */
	@Override
	public void saveMines(Data board[][]) {

		File file = null;
		JAXBContext jaxbContext = null;
		Marshaller jaxbMarshaller = null;
		try {
			File theDir = new File(System.getProperty("user.home"), "mineSweeperApp");
			theDir.mkdir();
			file = new File(theDir, "db.xml");
			jaxbContext = JAXBContext.newInstance(Games.class);
			jaxbMarshaller = jaxbContext.createMarshaller();
			Game game = new Game();
			String uniqueID = UUID.randomUUID().toString();
			game.setMines(new ArrayList<>());
			game.setId(uniqueID);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			for (int y = 0; y < yTiles; y++) {
				for (int x = 0; x < xTiles; x++) {
					MineInfo field = new MineInfo(board[x][y].getX(), board[x][y].getY(), board[x][y].isMine(),
							board[x][y].isRevealed(), board[x][y].getMinesNear(), board[x][y].isFlagged());
					game.getMines().add(field);
					logger.debug("DEBUG - A következő mező {} hozzáadva a játékhoz.", field);
				}
			}
			if (file.exists()) {
				Games games = this.loadMines();
				games.getGames().add(game);
				jaxbMarshaller.marshal(games, file);
				logger.trace("TRACE - XML-hez hozzáadva: {}", game);
			} else {
				Games games = new Games();
				logger.debug("DEBUG - Új adatbázis XML létrehozva: {} - elérési útvonala: {}", games, file.getAbsolutePath());
				games.getGames().add(game);
				jaxbMarshaller.marshal(games, file);
				logger.trace("TRACE - XML-hez hozzáadva: {}", game);
			}

		} catch (JAXBException e) {
			logger.error("ERROR - {}", e);
		}
	}

	/**
	 * Visszaadja a paraméterként kapott mező szomszédait, a paraméterként
	 * kapott mátrixból.
	 * 
	 * @param tile
	 *            a paraméterként kapott mező
	 * @param board
	 *            a paraméterként kapott {@link model.Data} mátrix
	 * @return neighbours egy {@link java.util.List} objektum, a paraméterként
	 *         kapott mező szomszédai
	 */
	@Override
	public List<Data> getNeighbours(Data tile, Data[][] board) {
		List<Data> neighbours = new ArrayList<>();

		// 8 darab szomszédja van
		int[] points = new int[] { -1, -1, // BF
				-1, 0, // B
				-1, 1, // BL
				0, -1, // F
				0, 1, // L
				1, -1, // JF
				1, 0, // J
				1, 1 // JL
		};

		for (int i = 0; i < points.length; i++) {
			int dx = points[i];
			int dy = points[++i];

			int newX = tile.getX() + dx;
			int newY = tile.getY() + dy;

			if (isValidTile(newX, newY)) {
				neighbours.add(board[newX][newY]);
			}
		}

		return neighbours;
	}

	/**
	 * Visszaadja a képernyőn megjelenítésre kerülő aknakereső szélességéhez
	 * használt értéket.
	 * 
	 * @return a képernyőn megjelenítésre kerülő aknakereső szélességéhez
	 *         használt érték
	 */
	public int getxTiles() {
		return xTiles;
	}

	/**
	 * Beállítja a képernyőn megjelenítésre kerülő aknakereső szélességéhez
	 * használt értéket.
	 * 
	 * @param xTiles
	 *            a képernyőn megjelenítésre kerülő aknakereső szélességéhez
	 *            használt érték
	 */
	public void setxTiles(int xTiles) {
		DataDaoImpl.xTiles = xTiles;
	}

	/**
	 * Visszaadja a képernyőn megjelenítésre kerülő aknakereső hosszúságához
	 * használt értéker.
	 * 
	 * @return a képernyőn megjelenítésre kerülő aknakereső hosszúságához
	 *         használt érték
	 */
	public int getyTiles() {
		return yTiles;
	}

	/**
	 * Beállítja a képernyőn megjelenítésre kerülő aknakereső hosszúságához
	 * használt értéket.
	 * 
	 * @param yTiles
	 *            a képernyőn megjelenítésre kerülő aknakereső hosszúságához
	 *            használt érték
	 */
	public void setyTiles(int yTiles) {
		DataDaoImpl.yTiles = yTiles;
	}

}

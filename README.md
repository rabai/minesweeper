# Aknakereső

Ez az alkalmazás egy aknakereső játék egyszerű megvalósítása. A játékban elérhető funkciók a következők: 
  - Új játék: 25-50-100-150-225 mezővel *(aknák generálása ezek alapján)*
  - Mentett állás betöltése *(id alapján, ami a mentés ideje)*

### Használt technológiák:
----
Egy multimodulos maven alkalmazás, mely a következő technológiákat használja:

* [Maven] - Multi modul használatával készül el az alkalmazás.
* [JavaFX] - A megjelenítési keretrendszer.
* [JAXB] - Az adatbázis kezeléséért felelős technológia.

### Telepítés
----
Az alkalmazás előfeltétele a [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)-as, vagy későbbi verziója. Valamint a [Maven](https://maven.apache.org/) automatizáló szoftver.

A Maven segítségével történik *(A projekt fő könyvtárában állva)*:

```sh
mvn clean install
```
Ez el fogja készíteni a futtatható állományt, amit futtatni a következőképp tudunk:
```sh
cd minesweeper-view/target
java -jar minesweeper-view-1.0-jar-with-dependencies.jar
```
Ezzel el is indul a kezdőképernyő és kezdődhet a játék!

### Site
----
Az alkalmazás site-ját a következőképp lehet elkészíteni *(A projekt fő könyvtárában állva)*:
```sh
mvn site
```
Ez elkészíti az aggregált report, javadoc oldalakat a szülő oldalának megnyitásához: 
```sh
cd target/staging
index.xhtml
```
Így be fog jönni a szülő projekt kezdőoldala.

### License
----
[GNU GPLv3](http://www.gnu.org/licenses/gpl-3.0.html)


   [Maven]: <https://maven.apache.org/>
   [git-repo-url]: <https://github.com/rabai/minesweeper.git>
   [JavaFX]: <http://docs.oracle.com/javase/8/javafx/get-started-tutorial/jfx-overview.htm>
   [JAXB]: <http://www.oracle.com/technetwork/articles/javase/index-140168.html>

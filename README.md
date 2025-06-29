# PowtórzenieGUI
## Pakiet _server_
W pakiecie _server_ znajduje się implementacja serwera obsługującącego wielu klientów jednocześnie. Serwer dla każdego klienta tworzy obiekt klasy _ClientHandler_ (wątek), który ma obsługiwać jednego podłączonego klienta. W ten sposób obsługa każdego klienta oddelegowana jest do oddzienego wątku, a serwer może przyjmować w tym czasie kolejnych klientów.

_Server_ przechowuje listę podłączonych klientów: _clients_ &mdash; typu _CopyOnWriteArrayList<>_, żeby prawidłowo obsłużyć dostęp wielu wątków klienckich (aby uniknąć _ConcurrentModificationException_).
Obsługuje też połączenie z przykładową bazą danych z przykładowymi operacjami SQL. 
## Pozostałe pliki
Klasa _ClientThread_ służy do połączenia się aplikacji klienckiej z serwerem. Klasa _CircleApplication_ to punkt wejściowy aplikacji klienta. Klasa _Controller_ odpowiada za obsługę widoku _app-view.fxml_.
# Site
Projekt skupiający się na połączeniu aplikacji z bazą danych. Klasa _DatabaseConnection_ odpowiada za podstawowe połączenie się z bazą danych. Bardziej interesująca jest klasa _Account_, która prezentuje różne operacje, które można wykonać na bazie danych z poziomu kodu Java. Operacje typu _INSERT_ oraz _UPDATE_ wymagają zazwyczaj użycia _PreparedStatement_ z parametrami (patrz: metoda _register_). Operacje typu _SELECT_ zwracają wynik po wykonaniu zapytania w postaci obiektu _ResultSet_ (patrz: metoda _authenticate_). 

Do obsługi bazy danych (SQLite) wymagane jest <ins>dodanie zależności w pliku _pom.xml_</ins> &mdash; artifactId: _sqlite-jdbc_, groupId: _org.xerial_. Plik _*.db_ najlepiej umieścić w folderze głównym projektu (obok _pom.xml_ i katalogu _src_).
# Shop
Projekt skupiający się na testach. Warto zajrzeć do katalogu _src/test_. Przykładowe, proste testy są w pliku _PlaylistTest.java_.

Do testów wymagane jest <ins>dodanie zależności w pliku _pom.xml_</ins> &mdash; artifactId: _junit-jupiter_, groupId: _org.junit.jupiter_.

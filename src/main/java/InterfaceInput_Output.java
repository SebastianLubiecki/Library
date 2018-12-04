import java.nio.file.Path;
import java.nio.file.Paths;

public interface InterfaceInput_Output {

     static Path pathToBookArchives() {
        Path path = Paths.get("C:\\Users\\User\\IdeaProjects\\WypożyczalniaFilmów\\src\\main\\java\\ListOfBooks.csv");
        return path;
    }

    static Path pathTClientArchives() {
        Path path = Paths.get("C:\\Users\\User\\IdeaProjects\\WypożyczalniaFilmów\\src\\main\\java\\ListOfClients.csv");
        return path;
    }

}

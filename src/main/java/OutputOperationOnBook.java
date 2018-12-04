import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OutputOperationOnBook implements BookOperation {


    public static void showListOfBook() throws IOException {
        Path path = Paths.get("C:\\Users\\User\\IdeaProjects\\WypożyczalniaFilmów\\src\\main\\java\\ListOfBooks.csv");
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static List<Book> returnListOfBook() throws IOException {
        Path path = Paths.get("C:\\Users\\User\\IdeaProjects\\WypożyczalniaFilmów\\src\\main\\java\\ListOfBooks.csv");
        List<String> lines = Files.readAllLines(path);

        List<Book> books = lines.stream()
                .map(x -> {
                    String[] splited = x.split(",");
                    Book bookObject = new Book();
                    bookObject.setTitle(splited[0]);
                    bookObject.setId(Integer.parseInt(splited[1]));
                    bookObject.setStatus(Boolean.parseBoolean(splited[2]));
                    return bookObject;
                })
                .collect(Collectors.toList());
        return books;
    }
}

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class OutputOperationOnBook implements InterfaceOfBook {


    public static void showListOfBook() throws IOException {

        List<String> lines = Files.readAllLines(InterfaceInput_Output.pathToBookArchives());
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static List<Book> returnListOfBook() throws IOException {

        List<String> lines = Files.readAllLines(InterfaceInput_Output.pathToBookArchives());
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

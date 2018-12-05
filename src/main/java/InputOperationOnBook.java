import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class InputOperationOnBook implements InterfaceOfBook {


    public static Book addNewBookToLibrary() {

        Book book = new Book(InterfaceOfBook.getNameOfBook(), InterfaceOfBook.getIdOfBook(), true);
        return book;
    }

    public static void savingBookToFile() throws IOException {


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

        try (PrintWriter printWriter = new PrintWriter(String.valueOf(InterfaceInput_Output.pathToBookArchives()))) {
            books.add(InputOperationOnBook.addNewBookToLibrary());
            for (Book book : books) {
                printWriter.print(book + "\n");
            }
        }
    }

    public static void savingBookToFile(List<Book> bookList) throws IOException {

        try (PrintWriter printWriter = new PrintWriter(String.valueOf(InterfaceInput_Output.pathToBookArchives()))) {
            for (Book book : bookList) {
                printWriter.print(book + "\n");
            }
        }
    }

}

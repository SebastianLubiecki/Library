import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputOperationOnBook implements BookOperation{


    public static void addNewBookToLibrary(List<Book> listOfBook) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type name of the book");
        String nameOfTheBook = scanner.nextLine();
        System.out.println("Type id of the book");
        int idOFTheBook = scanner.nextInt();
        Book book = new Book(nameOfTheBook, idOFTheBook, true);
        listOfBook.add(book);
    }

    public static void savingBookToFile() throws IOException {
        System.out.println("List of book you can lend from library: ");

        Path path = Paths.get("C:\\Users\\User\\IdeaProjects\\WypożyczalniaFilmów\\src\\main\\java\\ListOfBooks.csv");
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            System.out.println(line);
        }
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

        try (PrintWriter printWriter = new PrintWriter(String.valueOf(path))) {
            InputOperationOnBook.addNewBookToLibrary(books);
            for (Book book : books) {
                printWriter.print(book + " \n");
            }
        }
    }

    public static void savingBookToFile(List<Book> bookList) throws IOException {

        Path path = Paths.get("C:\\Users\\User\\IdeaProjects\\WypożyczalniaFilmów\\src\\main\\java\\ListOfBooks.csv");

        try (PrintWriter printWriter = new PrintWriter(String.valueOf(path))) {
            for (Book book : bookList) {
                printWriter.print(book + " \n");
            }
        }
    }

}

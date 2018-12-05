import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public interface InterfaceOfBook {



    static int getIndexOfBook() throws IOException {
        Scanner scanner = new Scanner(System.in);
        showListOfBook();
        System.out.println("Type index of book: ");
        int bookIndex = scanner.nextInt();
        return bookIndex;
    }


    static String getNameOfBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type name of the book");
        String nameOfTheBook = scanner.nextLine();
        return nameOfTheBook;
    }

    static int getIdOfBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type id of the book");
        int idOFTheBook = scanner.nextInt();
        return idOFTheBook;
    }

    static void showListOfBook() throws IOException {

        List<String> lines = Files.readAllLines(InterfaceInput_Output.pathToBookArchives());
        for (String line : lines) {
            System.out.println(line);
        }
    }

    static List<Book> returnListOfBook() throws IOException {

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




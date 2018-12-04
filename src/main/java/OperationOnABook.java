import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OperationOnABook {
    public static void addNewBookToLibrary(List <Book> listOfBook) {
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
        for (String line: lines){
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
            OperationOnABook.addNewBookToLibrary(books);
            for (Book book : books) {
                printWriter.print(book + " \n");
            }
        }
    }

    public static List<Book> showListOfBook() throws IOException {
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
        return books;
    }

    public static void lendBookFromLibrary(List<Client> client, List<Book> book) throws IOException {// nie zmienia sie status ksiazki do poprawy
        Scanner scanner = new Scanner(System.in);
        System.out.println(client); //wyswietla liste klientow
        System.out.println("Type index of Client: ");
        int clientIndex = scanner.nextInt();
        System.out.println(book); // wyswietla liste ksiazek
        System.out.println("Type index of book: ");
        int bookIndex = scanner.nextInt();
        OperationOnABook.lendABook(client.get(clientIndex),book.get(bookIndex));
        Menu.startingMenu(client, book);
        //brakuje na nowo zapisania do pliku
        // potrzeba otworzyc plik znalezc ksiazke wywolac metode lendABook na konkretnej ksiazce tak zeby zmienil sie jej status i na nowo zapisac
    }

    public static void returnBookToLibrary(List<Client> client, List<Book> book) throws IOException {//brak zmiany statusu ksiazki
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's make return: ");
        System.out.println(client);
        System.out.println("Type index of client: ");
        int clientIndex = scanner.nextInt();
        System.out.println(book);
        System.out.println("Type index of book: ");
        int bookIndex = scanner.nextInt();
        OperationOnABook.returnBook(client.get(clientIndex), book.get(bookIndex));
        Menu.startingMenu(client, book);
        savingBookToFile();
        //brakuje na nowa zapisania do pliku
    }

    public static void lendABook(Client client, Book book) throws IOException { //brak pelnego algorytmu brak LocalDate daty zwrotu, problem ze zmiana statusu ksiazki
        if (book.isStatus()) {
            book.setStatus(false);
        } else {
            System.out.println("You can't lend this book.");
        }
    }

    public static void returnBook(Client client, Book book) { //brak pelnego algorytmu
        if (!book.isStatus()) {
            book.setStatus(true);
        } else {
            System.out.println("You can't return book if the book is in library");
        }
    }


}

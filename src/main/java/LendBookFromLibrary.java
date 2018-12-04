import java.io.IOException;
import java.util.List;

public class LendBookFromLibrary implements BookOperation {  //brak pelnego algorytmu, powiazania go z klientem

    public static void lendBook(List<Client> client, List<Book> book) throws IOException {

        LendBookFromLibrary.changeStatus(client, book);
        InputOperationOnBook.savingBookToFile(book);
        Menu.startingMenu();
    }

    public static void changeStatus(List<Client> clientList, List<Book> bookList) throws IOException {

        int indexOfClient = BookOperation.getIndexOfClient();
        int indexOfABook = BookOperation.getIndexOfBook();
        if (bookList.get(indexOfABook).isStatus()) {
            bookList.get(indexOfABook).setStatus(false);
        } else {
            System.out.println("You can't lend this book.");
        }
    }

}

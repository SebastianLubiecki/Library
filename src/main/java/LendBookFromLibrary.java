import java.io.IOException;
import java.util.List;

public class LendBookFromLibrary implements InterfaceOfBook {

    public static void changeStatus(List<Client> clientList, List<Book> bookList) throws IOException {

        int indexOfClient = InterfaceOfClient.getIndexOfClient();
        int indexOfABook = InterfaceOfBook.getIndexOfBook();
        if (bookList.get(indexOfABook).isStatus()) {
            bookList.get(indexOfABook).setStatus(false);
            InputOperationOnBook.savingGivenBookListToFile(bookList);  //zapisuje na nowo z nowym Statusem
            InputOperationOnLend.savingLendOperationToFile();
        } else {
            System.out.println("You can't lend this book.");
        }
    }

    public static void lendBook(List<Client> client, List<Book> book) throws IOException {
// metoda raczej do wywalenia byla posrednia do changeStatus ale nie wykonuje nic konkretnego
        LendBookFromLibrary.changeStatus(client, book);
        Menu.startingMenu();
    }

}

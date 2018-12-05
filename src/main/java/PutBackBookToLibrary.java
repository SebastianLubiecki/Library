import java.io.IOException;
import java.util.List;


public class PutBackBookToLibrary implements InterfaceOfBook {

    public static void changeStatus(List<Client> clientList, List<Book> bookList) throws IOException {

        int indexOfABook = InterfaceOfBook.getIndexOfBook();
        if (!bookList.get(indexOfABook).isStatus()) {
            bookList.get(indexOfABook).setStatus(true);
            InputOperationOnBook.savingGivenBookListToFile(bookList);
            InterfaceOfLend.removeLendOperationFromFile();
        } else {
            System.out.println("You can't lend this book. Book is not in library or you type wrong index of book.");
        }
        Menu.startingString();
    }

    public static void putBackBookToLibrary(List<Client> client, List<Book> book) throws IOException {
//metoda posrednia do changeStatus nie wykonuje nic konretnego wiec do wywalenia raczej
        PutBackBookToLibrary.changeStatus(client, book);
        Menu.startingString();
    }


}

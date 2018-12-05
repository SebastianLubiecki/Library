import java.io.IOException;
import java.util.List;


public class PutBackBookToLibrary implements InterfaceOfBook {

    public static void putBackBookToLibrary(List<Client> client, List<Book> book) throws IOException {

        PutBackBookToLibrary.changeStatus(client, book);
        InputOperationOnBook.savingBookToFile(book);
        Menu.startingString();
    }

    public static void changeStatus(List<Client> clientList, List<Book> bookList) throws IOException {
        //brak pelnego algorytmu, brak powiazania z klientem
        int indexOfABook = InterfaceOfBook.getIndexOfBook();
        if (!bookList.get(indexOfABook).isStatus()) {
            bookList.get(indexOfABook).setStatus(true);
            OutputOperaqtionOnLend.removeLendOperationfromFile();
        } else {
            System.out.println("You can't lend this book.");
        }
    }


}

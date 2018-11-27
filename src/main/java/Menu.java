import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void startingString() {
        System.out.println("Hello! " +
                "\n\tWelcome to Lubieckis Library! " +
                "\nLet's start adventure! " +
                "\n\tYou can choose following options: " +
                "\nD: adding new position to the list of book" +
                "\nW: Show list of all clients" +
                "\nR: Make reservation  " +
                "\nL: LEND SOME BOOK!" +
                "\nZ: Return book" +
                "\nB: Show list of all books" +
                "\nC: Adding new Client to the list" +
                "\nexit: exit the program");
    }

    public static void startingMenu(List<Client> listOfClients, List<Book> listOfBooksFromLibrary) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String valueTypingByOperator = "";
        System.out.print("Let's type your commend: ");
        while (!valueTypingByOperator.equals("exit")) {
            valueTypingByOperator = scanner.nextLine();
            //Dodawanie nowych pozycji
            if (valueTypingByOperator.equals("D")) {
                System.out.println("Add new book to the list");
                OperationOnABook.savingBookToFile();
            }
            //Wyswietlanie klientow
            if (valueTypingByOperator.equals("W")) {
                System.out.println(OperationOnAClient.showListOfAllClient());
            }
            //Dokonywanie rezerwacji
            if (valueTypingByOperator.equals("R")) { //tu brakuje calosci brak pomyslu moze nowy boolean czy jest rezerwacja? ale skomplikuje to mocno reszte kodu
                System.out.println("R");
            }
            //Wypożyczenie
            if (valueTypingByOperator.equals("L")) {
                OperationOnABook.lendBookFromLibrary(OperationOnAClient.showListOfAllClient(), OperationOnABook.showListOfBook());
            }
            //Zwrot
            if (valueTypingByOperator.equals("Z")) {
                OperationOnABook.returnBookToLibrary(OperationOnAClient.showListOfAllClient(), OperationOnABook.showListOfBook());
            }
            //Lista Książek
            if (valueTypingByOperator.equals("B")) {
                OperationOnABook.showListOfBook();
            }
            //Dodawanie nowego klienta
            if (valueTypingByOperator.equals("C")) {
                OperationOnAClient.savingClientToFile();
            }
        }
    }
}

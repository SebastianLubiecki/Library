import java.io.IOException;
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

    public static void startingMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String valueTypingByOperator = "";


        while (!valueTypingByOperator.equals("exit")) {//Wiem ze tyle if'ow brzydko wyglada ale jak ogarne picocli to to zmienie
            System.out.print("Let's type your commend: ");
            valueTypingByOperator = scanner.nextLine();
            //Dodawanie nowych pozycji
            if (valueTypingByOperator.equals("D")) {
                System.out.println("Add new book to the list");
                InputOperationOnBook.savingBookToFile();
            }
            //Wyswietlanie klientow
            if (valueTypingByOperator.equals("W")) {
                OutputOperationOnClient.showListOfAllClient();
            }
            //Dokonywanie rezerwacji
            if (valueTypingByOperator.equals("R")) {
                //tu brakuje calosci brak pomyslu moze nowy boolean czy jest rezerwacja?
                System.out.println("R");
            }
            //Wypożyczenie
            if (valueTypingByOperator.equals("L")) {
                LendBookFromLibrary.lendBook(OutputOperationOnClient.returnListOfClient(),
                        OutputOperationOnBook.returnListOfBook());
            }
            //Zwrot
            if (valueTypingByOperator.equals("Z")) {
                PutBackBookToLibrary.putBackBookToLibrary(OutputOperationOnClient.returnListOfClient(),
                        OutputOperationOnBook.returnListOfBook());
            }
            //Lista Książek
            if (valueTypingByOperator.equals("B")) {
                OutputOperationOnBook.showListOfBook();
            }
            //Dodawanie nowego klienta
            if (valueTypingByOperator.equals("C")) {
                InputOperationOnClient.savingClientToFile();
            }
        }
    }
}

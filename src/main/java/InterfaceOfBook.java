import java.io.IOException;
import java.util.Scanner;

public interface InterfaceOfBook {



    static int getIndexOfBook() throws IOException {
        Scanner scanner = new Scanner(System.in);
        OutputOperationOnBook.showListOfBook();
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

}




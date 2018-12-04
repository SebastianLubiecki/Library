import java.io.IOException;
import java.util.Scanner;

public interface BookOperation {

    static int getIndexOfClient() throws IOException {
        Scanner scanner = new Scanner(System.in);
        OperationOnAClient.showListOfAllClient();
        System.out.println("Type index of Client: ");
        int clientIndex = scanner.nextInt();
        return clientIndex;
    }

    static int getIndexOfBook() throws IOException {
        Scanner scanner = new Scanner(System.in);
        OutputOperationOnBook.showListOfBook();
        System.out.println("Type index of book: ");
        int bookIndex = scanner.nextInt();
        return bookIndex;
    }

}

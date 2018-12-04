import java.io.IOException;
import java.util.Scanner;

public interface InterfaceOfClient {

    static int getIndexOfClient() throws IOException { // interfejs klienta ?
        Scanner scanner = new Scanner(System.in);
        OutputOperationOnClient.showListOfAllClient();
        System.out.println("Type index of Client: ");
        int clientIndex = scanner.nextInt();
        return clientIndex;
    }
}

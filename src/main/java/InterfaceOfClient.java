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

    static String getFirstNameOfClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type first name of the Client");
        String firstName = scanner.nextLine();
        return firstName;
    }
    static String getLastNameOfClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type lastName name of the Client");
        String lastName = scanner.nextLine();
        return lastName;
    }
    static String getIdfClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type id of the Client");
        String idOFTheClient = scanner.nextLine();
        return idOFTheClient;
    }
}



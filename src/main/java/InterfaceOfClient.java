import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public interface InterfaceOfClient {

    static int getIndexOfClient() throws IOException { // interfejs klienta ?
        Scanner scanner = new Scanner(System.in);
        showListOfAllClient();
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

    static List <Client> returnListOfClients() throws IOException {
        List<String> lines = Files.readAllLines(InterfaceInput_Output.pathTClientArchives());
        List<Client> clients = lines.stream()
                .map(x -> {
                    String[] splited = x.split(",");
                    Client client = new Client();
                    client.setFirstName(splited[0]);
                    client.setLastName(splited[1]);
                    client.setClientId(splited[2]);
                    return client;
                })
                .collect(Collectors.toList());
        return clients;
    }

    static void showListOfAllClient() throws IOException {

        List<String> lines = Files.readAllLines(InterfaceInput_Output.pathTClientArchives());
        for (String line : lines) {
            System.out.println(line);
        }
    }
}



import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OperationOnAClient {

    public static List<Client> showListOfAllClient() throws IOException {
        Path path = Paths.get("C:\\Users\\User\\IdeaProjects\\WypożyczalniaFilmów\\src\\main\\java\\ListOfClients.csv");
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            System.out.println(line);
        }
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
        return clients; // jak bedzie return clients to zwraca ladnie wszystkich clientow z petli for i pozniej brzydko liste. Problem do rozwiazania
    }

    public static void savingClientToFile() throws IOException {
        Path path = Paths.get("C:\\Users\\User\\IdeaProjects\\WypożyczalniaFilmów\\src\\main\\java\\ListOfClients.csv");
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            System.out.println(line);
        }
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

        PrintWriter printWriter = new PrintWriter(String.valueOf(path));
        OperationOnAClient.addNewClientToLibrary(clients); // jako paramter metode showListOfAllClient (?) i mozliwe jest wtedy skasowanie kodu
        try {
            for (Client client : clients) {
                printWriter.print(client + " \n"); // \n nic chyba nie daje, do przerobienia
            }
            printWriter.close();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

    public static Client addNewClientToLibrary(List<Client> listOfClient) {// moze sety zamiast stringow?
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type first name of the Client");
        String firstName = scanner.nextLine();
        System.out.println("Type lastName name of the Client");
        String lastName = scanner.nextLine();
        System.out.println("Type id of the Client");
        String idOFTheClient = scanner.nextLine();
        Client client= new Client(firstName, lastName, idOFTheClient);
        listOfClient.add(client);
        return (client);
    }

}

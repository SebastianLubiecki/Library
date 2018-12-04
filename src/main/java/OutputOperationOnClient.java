import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class OutputOperationOnClient {

    public static void showListOfAllClient() throws IOException {
        Path path = Paths.get("C:\\Users\\User\\IdeaProjects\\WypożyczalniaFilmów\\src\\main\\java\\ListOfClients.csv");
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            System.out.println(line);
        }

    }

    public static List<Client> returnListOfClient() throws IOException {
        Path path = Paths.get("C:\\Users\\User\\IdeaProjects\\WypożyczalniaFilmów\\src\\main\\java\\ListOfClients.csv");
        List<String> lines = Files.readAllLines(path);

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
}

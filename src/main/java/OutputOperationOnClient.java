import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class OutputOperationOnClient {

    public static void showListOfAllClient() throws IOException {

        List<String> lines = Files.readAllLines(InterfaceInput_Output.pathTClientArchives());
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static List<Client> returnListOfClient() throws IOException {

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
        return clients; // jak bedzie return clients to zwraca ladnie wszystkich clientow z petli for i pozniej brzydko liste. Problem do rozwiazania
    }
}

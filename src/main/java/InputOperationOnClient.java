import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class InputOperationOnClient {

    public static void savingClientToFile() throws IOException {

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

        PrintWriter printWriter = new PrintWriter(String.valueOf(InterfaceInput_Output.pathTClientArchives()));
        InputOperationOnClient.addNewClientToLibrary(clients);
        try {
            for (Client client : clients) {
                printWriter.print(client + "\n"); // \n nic chyba nie daje, do przerobienia
            }
            printWriter.close();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

    public static Client addNewClientToLibrary(List<Client> listOfClient) {// moze sety zamiast stringow?

        Client client = new Client(InterfaceOfClient.getFirstNameOfClient(), InterfaceOfClient.getLastNameOfClient(),
                InterfaceOfClient.getIdfClient());
        listOfClient.add(client);
        return (client);
    }

}

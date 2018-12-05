import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class InputOperationOnClient {

    public static void savingClientToFile() throws IOException {

        PrintWriter printWriter = new PrintWriter(String.valueOf(InterfaceInput_Output.pathTClientArchives()));
        InputOperationOnClient.addNewClientToLibrary(InterfaceOfClient.returnListOfClients());
        try {
            for (Client client : InterfaceOfClient.returnListOfClients()) {
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

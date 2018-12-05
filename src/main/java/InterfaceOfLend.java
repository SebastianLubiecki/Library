import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public interface InterfaceOfLend {

    static List<Lend> returnListOfLend() throws IOException {

        List<String> lines = Files.readAllLines(InterfaceInput_Output.pathToLendArchives());
        List<Lend> lends = lines.stream()
                .map(x -> {
                    String[] splited = x.split(",");
                    Lend lend = new Lend();
                    lend.setBookId(Integer.parseInt(splited[0]));
                    lend.setClientId(splited[1]);
                    lend.setDateOfLend(LocalDate.parse(splited[2]));
                    lend.setDateOfReturn(LocalDate.parse(splited[3]));
                    return lend;
                })
                .collect(Collectors.toList());
        return lends;
    }

    static void removeLendOperationFromFile() throws IOException {

        PrintWriter printWriter = new PrintWriter(String.valueOf(InterfaceInput_Output.pathToLendArchives()));
        returnListOfLend().remove(InterfaceOfBook.getIndexOfBook());
        try {
            for (Lend lend : returnListOfLend()) {
                printWriter.print(lend + "\n"); // \n nic chyba nie daje, do przerobienia
            }
            printWriter.close();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }

    }

}

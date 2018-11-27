import java.io.IOException;

public class Main {

    public  static void main(String[] args) throws IOException {

        Menu.startingString();
        Menu.startingMenu(OperationOnAClient.showListOfAllClient(), OperationOnABook.showListOfBook());
    }
}

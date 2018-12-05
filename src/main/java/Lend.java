import java.time.LocalDate;

public class Lend {

    int bookId;
    String clientId;
    private LocalDate dateOfLend;
    private LocalDate dateOfReturn;

    public Lend() {

    }

    public Lend(int bookId, String clientId, LocalDate dateOfLend, LocalDate dateOfReturn) {

        this.bookId = bookId;
        this.clientId = clientId;
        this.dateOfLend = dateOfLend;
        this.dateOfReturn = dateOfReturn;
    }

    public LocalDate getDateOfLend() {
        return dateOfLend;
    }

    public void setDateOfLend(LocalDate dateOfLend) {
        this.dateOfLend = dateOfLend;
    }

    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getClient() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}

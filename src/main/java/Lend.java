import java.time.LocalDate;

public class Lend {

    Book book;
    Client client;
    private LocalDate dateOfLend;
    private LocalDate dateOfReturn;


    public Lend(Book book, Client client, LocalDate dateOfLend, LocalDate dateOfReturn) {

        this.book = book;
        this.client = client;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

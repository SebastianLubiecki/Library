public class Client {

    private String firstName;
    private String lastName;
    private String ClientId;

    public Client() {
    }

    public Client(String firstName, String lastName, String ClientId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ClientId = ClientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getClientId() {
        return ClientId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setClientId(String clientId) {
        ClientId = clientId;
    }

    @Override
    public String toString() {
        return firstName + "," + lastName + "," + ClientId;
    }
}
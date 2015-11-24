package SDK;

/**
 * Created by alexanderlindkjaer on 27/10/15.
 */
public class User {

    //creating variables
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String status;
    private String email;
    private String type;

    //TODO: Kan slettes?! Bruges ikke i wrapperen længere


    public User () {}

    //creating get and set method for all the variables, so they can be used by other classes


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
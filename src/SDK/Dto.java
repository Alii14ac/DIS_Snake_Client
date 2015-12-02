package SDK;

/**
 * Created by alexanderlindkjaer on 01/12/2015.
 */
public class Dto {

    public User currentUser; // skal holde styr på hvem der er logget ind




    /**
     * Getter for currentuser
     * @return currentUser
     */
    public User getCurrentUser()
    {
        return currentUser;
    } //metode slut

    /**
     * Set currentuser
     * @param currentUser
     */
    public void setCurrentUser(User currentUser)
    {
        this.currentUser = currentUser;
    } //metode slut


}

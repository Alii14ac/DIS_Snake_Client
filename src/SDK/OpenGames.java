package SDK;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by alexanderlindkjaer on 06/12/2015.
 */
public class OpenGames {

    public SimpleIntegerProperty id = new SimpleIntegerProperty();
    public SimpleStringProperty host = new SimpleStringProperty();


    public OpenGames(Integer id, String host) {
        this.id = new SimpleIntegerProperty(id);
        this.host = new SimpleStringProperty(host);

    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getHost() {
        return host.get();
    }


    public void setHost(String host) {
        this.host.set(host);
    }
}

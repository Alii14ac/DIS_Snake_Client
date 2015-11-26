package GUI;

/**
 * Created by alexanderlindkjaer on 26/11/2015.
 */
public interface ControlledScreen {

    //This method will allow the injection of the Parent ScreenPane
    public void setScreenParent(Logic.ScreensController screenPage);
}
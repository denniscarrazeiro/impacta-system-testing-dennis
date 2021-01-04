package pages;

import support.BaseSteps;
import support.DriverQA;

public class HomePage extends BasePage {

    private String url = "http://agapito-server.herokuapp.com/";

    public HomePage (DriverQA stepsDriver){ super(stepsDriver);}

    public void open(){
        driver.openURL(url);
    }

}

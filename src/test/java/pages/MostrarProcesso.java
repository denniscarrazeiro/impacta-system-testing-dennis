package pages;

import support.DriverQA;

public class MostrarProcesso extends BasePage{

    private String url = "http://agapito-server.herokuapp.com/";

    public MostrarProcesso(DriverQA stepsDriver){
        super(stepsDriver);
    }

    public String getNotice(){
        return driver.getText("notice");
    }

}

package pages;

import support.BaseSteps;
import support.DriverQA;

public class MenuAgapito extends BasePage {

    public MenuAgapito(DriverQA stepsDriver){
        super(stepsDriver);
    }

    public void clickUsers(){
        driver.click("users");
    }

    public void clicarProcessos(){
        driver.click("#processos","css");
    }

}

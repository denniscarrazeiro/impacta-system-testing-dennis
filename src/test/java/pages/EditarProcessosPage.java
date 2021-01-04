package pages;

import support.DriverQA;

public class EditarProcessosPage extends BasePage{

    public EditarProcessosPage(DriverQA stepsDriver){
        super(stepsDriver);
    }

    public void preencherCampoVara(String valor){
        driver.sendKeys(valor,"processo_vara");
    }

    public void clickSalvar(){
        driver.click("btn-save");
    }

    public String getNotice(){
        return driver.getText("notice");
    }
}

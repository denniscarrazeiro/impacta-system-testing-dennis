package pages;

import support.DriverQA;

public class ListarProcessos extends BasePage{

    public ListarProcessos(DriverQA stepDriver) {
        super(stepDriver);
    }

    public void clicarNovo(){
        driver.click("#btn-novo","css");
    }

    public void clicarMostrar(String id){
        driver.click("#btn-show_"+id,"css");
    }

    public void clicarEditar(String id){
        driver.click("#btn-edit_"+id,"css");
    }

    public void clicarApagar(String id){
        driver.click("#btn-delete_"+id,"css");
    }

}

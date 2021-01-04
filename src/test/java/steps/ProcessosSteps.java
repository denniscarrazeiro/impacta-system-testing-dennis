package steps;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import pages.*;
import support.*;

import java.util.ArrayList;

public class ProcessosSteps extends BaseSteps {

    private HomePage homePage = new HomePage(driver);
    private MenuAgapito menuAgapito = new MenuAgapito(driver);
    private ProcessosPage processosPage = new ProcessosPage(driver);
    private MostrarProcesso mostrarProcesso = new MostrarProcesso(driver);
    private ListarProcessos listarProcessos = new ListarProcessos(driver);
    private EditarProcessosPage editarProcessos = new EditarProcessosPage(driver);
    private String id;
    private ArrayList arrayEmpty = new ArrayList();

    @Dado("^que o usuário está na página inicial$")
    public void queOUsuarioEstaNaPaginaInicial() {
        homePage.open();
    }

    @E("^que o usuário clicar no menu processos$")
    public void queOUsuarioClicarNoMenuProcessos() {
        menuAgapito.clicarProcessos();
    }

    @E("^que o usuário clicar no botão novo processo$")
    public void queOUsuarioClicarNoBotaoNovoProcesso() {
        listarProcessos.clicarNovo();
    }

    @E("^que o usuário preenche o campo \"([^\"]*)\" com o valor \"([^\"]*)\" no cadastro de processos$")
    public void queOUsuarioPreencheOCampoComOValorNoCadastroDeProcessos(String campo, String valor){
        processosPage.preecherCampos(campo,valor);
    }

    @Quando("^o usuário clicar no botão salvar no cadastro de processos$")
    public void oUsuarioClicarNoBotaoSalvarNoCadastroDeProcessos() {
        processosPage.clicarSalvar();
        id = driver.getText("#codigo","css");
    }

    @Entao("^o usuário deveria ver a mensagem \"([^\"]*)\" no cadastro de processos$")
    public void oUsuarioDeveriaVerAMensagemNoCadastroDeProcessos(String message){
        Assert.assertEquals(message,mostrarProcesso.getNotice());
    }

    @Quando("^o usuário clicar no botão mostrar$")
    public void oUsuarioClicarNoBotaoMostrar() {
        listarProcessos.clicarMostrar(id);
    }

    @Entao("^usuário deve obter o código$")
    public void usuarioDeveObterOCodigo() {
        Assert.assertEquals(driver.getText("codigo"),id);
    }

    @Quando("^o usuário clicar no botão apagar e confirmar mensagem$")
    public void oUsuarioClicarNoBotaoApagarEConfirmarMensagem() {
        listarProcessos.clicarApagar(id);
        driver.ChooseOkOnNextConfirmation();
    }

    @Entao("^o usuário não verá mais o processo na lista$")
    public void oUsuarioNaoVeraMaisOProcessoNaLista() {
        Assert.assertEquals( arrayEmpty,driver.getElements("#btn-show_"+id,"css"));
    }

    @Quando("^o usuário clicar no botão editar$")
    public void oUsuárioClicarNoBotãoEditar() {
        listarProcessos.clicarEditar(id);
    }

    @E("^o usuário preenche o campo vara com o valor \"([^\"]*)\" no editar processos$")
    public void oUsuarioPreencheOCampoComOValorNoEditarProcessos(String valor){
       editarProcessos.preencherCampoVara(valor);
    }

    @Quando("^o usuário clicar em salvar$")
    public void oUsuárioClicarEmSalvar() {
        editarProcessos.clickSalvar();
    }

    @Entao("^o usuário deveria ver a mensagem \"([^\"]*)\" no editar processos$")
    public void oUsuarioDeveriaVerAMensagemNoEditarProcessos(String mensagem){
        Assert.assertEquals(mensagem,editarProcessos.getNotice());
    }
}

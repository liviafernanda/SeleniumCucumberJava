package stepsDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PreenchimentoFormularioSteps {
	
	WebDriver driver; 
	
	@Given("navegador aberto em formulario do Google")
	public void navegador_aberto_em_formulario_do_google() {
	    System.out.println("navegador aberto no formulario");
	    String caminhoChromedriver = System.getProperty("user.dir");
	    System.setProperty("webdriver.chrome.driver", caminhoChromedriver+"/src/test/resources/Drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    
	    driver.navigate().to("https://docs.google.com/forms/d/e/1FAIpQLSeCmVn9-CF1qNsTlfhi5mytMv15YnS7BGu3dTyzftAtUiRuKA/viewform?vc=0&c=0&w=1&flr=0");
	}

	@When("usuario preenche o nome")
	public void usuario_preenche_o_nome() throws InterruptedException {
	    //System.out.println("Preenche com Livia Fernanda");
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".freebirdFormviewerViewNumberedItemContainer:nth-child(1) .quantumWizTextinputPaperinputInput"))).click();
		driver.findElement(By.cssSelector(".freebirdFormviewerViewNumberedItemContainer:nth-child(1) .quantumWizTextinputPaperinputInput")).sendKeys("Lívia");

		Thread.sleep(2000);
	}
	
	@And("preenche o email")
	public void preenche_o_email() throws InterruptedException {
	    //System.out.println("Preenche com liviafernanda@gmail.com");
		
		driver.findElement(By.cssSelector(".freebirdFormviewerViewNumberedItemContainer:nth-child(2) .quantumWizTextinputPaperinputInput")).click();  
		driver.findElement(By.cssSelector(".freebirdFormviewerViewNumberedItemContainer:nth-child(2) .quantumWizTextinputPaperinputInput")).sendKeys("liviafernanda@gmail.com");

		Thread.sleep(2000);
	}

	@And("preenche o assunto")
	public void preenche_o_assunto() throws InterruptedException{
		//System.out.println("Preenche com Teste de Aceitacao");
		driver.findElement(By.cssSelector(".freebirdFormviewerViewNumberedItemContainer:nth-child(3) .quantumWizTextinputPaperinputInput")).click(); 
		driver.findElement(By.cssSelector(".freebirdFormviewerViewNumberedItemContainer:nth-child(3) .quantumWizTextinputPaperinputInput")).sendKeys("Teste de aceitacao");

		Thread.sleep(2000);
	}

	@And("preenche a mensagem")
	public void preenche_a_mensagem() throws InterruptedException {
	    //System.out.println("Preenche com execucao de teste de aceitacao com Cucumber e Selenium");
		driver.findElement(By.cssSelector(".quantumWizTextinputPapertextareaInput")).click();
	    driver.findElement(By.cssSelector(".quantumWizTextinputPapertextareaInput")).sendKeys("Teste de aceitacao utilizando cucumber e selenium");
	 
	    Thread.sleep(2000);
	}

	@And("envia o formulario")
	public void envia_o_formulario() {
	    //System.out.println("Clicar no botao Enviar");
		driver.findElement(By.cssSelector(".appsMaterialWizButtonPaperbuttonFilled > .appsMaterialWizButtonPaperbuttonContent")).click();
		  
	}

	@Then("o formulario deve ser enviado com sucesso")
	public void o_formulario_deve_ser_enviado_com_sucesso() throws InterruptedException {
	    System.out.println("O formulario deve ser enviado");
	    
	    driver.getPageSource().contains("Sua resposta foi registrada");
	    
	    Thread.sleep(2000);
	    
	    driver.close();
	    driver.quit();
	}

}

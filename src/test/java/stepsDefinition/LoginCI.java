package stepsDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import recordingVideos.MyScreenRecorder;

public class LoginCI {
	
	WebDriver driver;
	
	@Given("navegador aberto")
	public void navegador_aberto() throws Exception {
		//MyScreenRecorder.startRecording("navegador_aberto");
	    System.out.println("abrir Chrome");
	    
	    String caminhoDriver = System.getProperty("user.dir");
	    System.setProperty("webdriver.chrome.driver", caminhoDriver+("/src/test/resources/Drivers/chromedriver.exe"));
	    
	    driver = new ChromeDriver();
	    driver.manage().window().setPosition(new Point(0,0));
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}

	@And("logado na central de interpretes") 
	public void logado_na_central_de_interpretes() throws InterruptedException {
	    System.out.println("Entrar em 200.137.197.197");
	    
	    driver.navigate().to("http://200.137.197.197/index.php/Login");
	    
	    Thread.sleep(2000);
	}

	@When("Usuario assiste ao video sinalizando o preenchimento do email")
	public void usuario_assiste_ao_video_sinalizando_o_preenchimento_do_email() throws InterruptedException {
	    System.out.println("Assistindo ao primeiro video");
	    
	    driver.findElement(By.id("username-video")).click();
	    
	    Thread.sleep(4000);
	    
	}

	@And("preenche o campo com o email")
	public void preenche_o_campo_com_o_email() throws InterruptedException {
		System.out.println("Preenche o email");
		
		driver.findElement(By.id("email")).sendKeys("coordenador@gmail.com");
		
		Thread.sleep(2000);
	}

	@And("assiste ao video sinalizando o preenchimento da senha")
	public void assiste_ao_video_sinalizando_o_preenchimento_da_senha() throws InterruptedException {
		System.out.println("Assistindo ao segundo video");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.id("password-video")).click();
		
		Thread.sleep(4000);
	}

	@And("preenche o campo com senha")
	public void preenche_o_campo_com_senha() throws InterruptedException {
		System.out.println("Preenche a senha");
		
		driver.findElement(By.id("password")).sendKeys("123");
		
		Thread.sleep(2000);
		
	}

	@And("clica no botao Entrar")
	public void clica_no_botao_entrar() throws InterruptedException {
		//System.out.println("Clica no botao");
		
		driver.findElement(By.id("submitLogin")).click();
		
		Thread.sleep(2000);
	}

	@Then("sistema entra na tela inicial")
	public void sistema_entra_na_tela_inicial() throws InterruptedException, Exception {
		System.out.println("Entra na tela inicial");
		
		driver.getCurrentUrl().contains("http://200.137.197.197/index.php/Main/boasVindas?lang=pt");
		
		driver.close();
		
		driver.quit();
		
		//MyScreenRecorder.stopRecording();
		
		
	}


}

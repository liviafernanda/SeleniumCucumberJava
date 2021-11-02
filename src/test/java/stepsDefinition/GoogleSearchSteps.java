package stepsDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import recordingVideos.MyScreenRecorder;

public class GoogleSearchSteps {
	
	WebDriver driver = null;
	
	@Given("navegador esta aberto")
	public void navegador_esta_aberto() throws Exception {
		MyScreenRecorder.startRecording("navegador_esta_aberto");
	    System.out.println("navegador aberto");
	    String caminho = System.getProperty("user.dir");
	    System.setProperty("webdriver.chrome.driver", caminho+"/src/test/resources/Drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    
	    //driver.manage().window().maximize();
	    
	}

	@And("usuario esta na pagina inicial do Google")
	public void usuario_esta_na_pagina_inicial_do_google() {
	    System.out.println("página inicial do google");
	    
	    driver.navigate().to("https://google.com");
	}

	@When("usuario digita um texto na caixa de pesquisa")
	public void usuario_digita_um_texto_na_caixa_de_pesquisa() throws InterruptedException {
	    System.out.println("digitando um texto para pesquisa");
	    
	    driver.findElement(By.name("q")).sendKeys("Teste de Aceitação");
	    
	    Thread.sleep(2000);
	}

	@And("pressiona a tecla Enter")
	public void pressiona_a_tecla_enter() throws InterruptedException {
	    System.out.println("apertando o enter");
	    
	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(2000);
	}

	@Then("usuario e direcionado para os resultados da pesquisa")
	public void usuario_e_direcionado_para_os_resultados_da_pesquisa() throws Exception {
	    System.out.println("resultados de busca");
	    
	    driver.getPageSource().contains("Conceito: Teste de Aceitação - CIn UFPE");
	    
	    driver.close();
	    driver.quit();
	    MyScreenRecorder.stopRecording();
	}

}

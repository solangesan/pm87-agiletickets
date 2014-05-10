package br.com.caelum.agiletickets.acceptance.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReservaPage {
	private static final String BASE_URL = "http://localhost:8080";
	private final WebDriver driver;
	
	public ReservaPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void abrirSessao(int totalIngressos, int quantidadeIngressosVendidos){
		
	}
	
	public void reservarIngresso(Integer quantidade) {
		WebElement form = form();
		form.findElement(By.name("reserva.qtd")).sendKeys(quantidade.toString());
		form.submit();
	}
	
	private WebElement form() {
		return driver.findElement(By.id("addForm"));
	}

}

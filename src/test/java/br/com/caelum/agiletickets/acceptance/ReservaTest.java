package br.com.caelum.agiletickets.acceptance;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.caelum.agiletickets.acceptance.page.ReservaPage;

public class ReservaTest {
	
	private WebDriver browser;
	private ReservaPage reserva;
	
	@Before
	public void setUP() throws Exception {
		browser = new FirefoxDriver();
		reserva = new ReservaPage(browser);
	}
	
	@After
	public void tearDown() {
		browser.close();
	}
	
	@Test
	public void aumentarEm10PorcentoOPrecoDosUltimosIngressos(){
		reserva.abrirSessao(100, 95);
		reserva.reservarIngresso(1);
	}

}

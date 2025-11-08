package br.com.desafiotecnico;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


@DisplayName("Testes Automatizados da Funcionalidade de Gerador de Dados ")
public class Cpf {
    @Test
    @DisplayName("Cpf")
    public void gerarCPF () throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();

        navegador.get("https://www.4devs.com.br/gerador_de_cpf");
        navegador.findElement(By.id("pontuacao_nao")).click();

        String inicio = "0";

        while (!inicio.startsWith("7")) {
            navegador.findElement(By.id("bt_gerar_cpf")).click();
            navegador.findElement(By.id("texto_cpf")).click();
            Thread.sleep(2000);
            WebElement campoCpf = navegador.findElement(By.id("texto_cpf")); // exemplo de id
            String cpfGerado = campoCpf.getText();
            inicio = cpfGerado.substring(0,1);

            System.out.println("CPF gerado: " + cpfGerado);
            System.out.println("Inicio: " + inicio);


        }
    }
}



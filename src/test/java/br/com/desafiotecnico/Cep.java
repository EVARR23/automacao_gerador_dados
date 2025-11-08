package br.com.desafiotecnico;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@DisplayName("Testes Automatizados da Funcionalidade de Gerador de Dados ")
public class Cep {
    @Test
    @DisplayName("Cep")
    public void gerarCEP () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();
        navegador.get("https://www.4devs.com.br/gerador_de_cep");
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(5));


        WebElement selectElementEstado = wait.until(ExpectedConditions.elementToBeClickable(By.id("cep_estado")));
        Select selectEstado = new Select(selectElementEstado);
        selectEstado.selectByValue("AM");
        Thread.sleep(2000);

        WebElement selectElementCidade = wait.until(ExpectedConditions.elementToBeClickable(By.id("cep_cidade")));
        Select selectCidade = new Select(selectElementCidade);
        selectCidade.selectByValue("243");
        Thread.sleep(2000);

        Map<String, Integer> contadorBairros = new HashMap<>();
        for (int i = 0; i < 25 ; i++) {
            WebElement botaoGerar = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn_gerar_cep")));
            botaoGerar.click();

            Thread.sleep(2000);
            WebElement bairro = navegador.findElement(By.id("bairro")); // exemplo de id
            String bairroGerado = bairro.getText();

            contadorBairros.put(bairroGerado, contadorBairros.getOrDefault(bairroGerado, 0) + 1);
        }


        String bairroMaisFrequente = null;
        int max = 0;

        for (Map.Entry<String, Integer> entry : contadorBairros.entrySet()) {
            if (entry.getValue() > max) {
                bairroMaisFrequente = entry.getKey();
                max = entry.getValue();
            }
        }

        System.out.println("\n=== RESULTADO FINAL ===");
        System.out.println("Bairro mais frequente: " + bairroMaisFrequente + " (" + max + " vezes)");

        navegador.quit();

    }
}
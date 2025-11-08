
# Automação de Gerador de CPF e CEP

Este projeto realiza testes automatizados na plataforma [4Devs](https://www.4devs.com.br/gerador_de_cpf), gerando CPFs e CEPs e analisando os resultados de forma automatizada usando Selenium.

---

## Funcionalidades

O fluxo automatizado realiza as seguintes ações:

1. Acessar a página do **Gerador de CPF**:  
   [https://www.4devs.com.br/gerador_de_cpf](https://www.4devs.com.br/gerador_de_cpf)

2. Marcar a opção para **não gerar a pontuação** do CPF.

3. Clicar no botão **GERAR CPF** repetidamente até gerar um CPF que **inicie com ‘7’**.

4. Navegar até a aba **Gerador de CEP**.

5. Selecionar o estado **AM** (Amazonas).

6. Selecionar a cidade **Manaus**.

7. Gerar CEPs **25 vezes**.

8. Verificar **quais bairros aparecem mais de uma vez** durante a execução.

---

## Pré-requisitos

- Java JDK 21
- Maven
- Selenium WebDriver
- ChromeDriver ou outro driver compatível

---

## Como rodar

1. Clonar o repositório:

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio


<img width="1395" height="781" alt="image" src="https://github.com/user-attachments/assets/b75eadd0-41a7-4b23-8638-c69bd5b1b329" />
<img width="1340" height="774" alt="image" src="https://github.com/user-attachments/assets/9fa0b323-a40a-4f6d-b10d-561fa5e15396" />

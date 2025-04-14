# 🧪 DummyJSON API Testes Automatizados

Este repositório contém testes automatizados para a [DummyJSON API](https://dummyjson.com/), utilizando **JavaScript**, **Jest** e geração de relatórios com **Allure Report**. Serviu como base de estudos para aprender sobre padrão de projetos, e integração continua.

---

## 🚀 Tecnologias

- [Java](https://www.oracle.com/java/technologies/downloads/)
- [Junit 5](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine)
- [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)
- [Jackson Databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.18.3)
- [Allure Report](https://allurereport.org/)
- [GitHub Actions](https://docs.github.com/pt/actions) para CI/CD

---

## 📦 Instalação

1. Clone o projeto:
   ```bash
   git clone https://github.com/Allysr/dummyjson-api-test.git
   cd dummyjson-api-test
   ```

2. Instale as dependências:
   ```bash
   mvn clean test
   ```

Os resultados dos testes serão salvos na pasta `allure-results`.

3. Gerar o relatório:
   ```bash
   mvn allure:generate
   ```

4. Abrir o relatório:
   ```bash
   mvn allure:serve
   ```


---

## 🌐 Acesse o relatório online (GitHub Pages)

Acesse o relatório Allure gerado automaticamente após os testes:

👉 [Ver Relatório Allure](https://allysr.github.io/dummyjson-api-test/)

> O relatório é atualizado automaticamente via GitHub Actions após cada execução.








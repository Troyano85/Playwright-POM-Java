# Playwright Java Framework

Este repositorio contiene un framework de automatización de pruebas de interfaz de usuario , construido con Java y la potente biblioteca Playwright de Microsoft. El framework ha sido diseñado siguiendo el patrón de diseño Page Object Model (POM) para asegurar una **alta mantenibilidad, reutilización de código y claridad en las pruebas**.

Este framework está configurado para realizar pruebas en la página web de ejemplo: **[https://www.saucedemo.com](https://www.saucedemo.com)**.

Además de la integración con Playwright, el framework incluye soporte para la generación de **informes de prueba detallados y visualmente atractivos con Allure Report**, logging con Log4j 2 para un seguimiento efectivo de la ejecución, y la capacidad de generar **datos de prueba realistas con DataFaker**.


## Tecnologías Utilizadas

* **Java**: Lenguaje de programación principal.
* **Maven**: Herramienta de gestión de dependencias y construcción.
* **Playwright**: Biblioteca de automatización de navegadores desarrollada por Microsoft.
* **JUnit 5**: Framework de pruebas unitarias y de integración para la ejecución de pruebas.
* **Allure Report**: Framework para la generación de informes de pruebas detallados.
* **Log4j 2**: Framework de logging para Java.
* **DataFaker**: Biblioteca para la generación de datos de prueba aleatorios.
* **AspectJ**: Extensión del lenguaje Java que permite la programación orientada a aspectos (utilizado aquí principalmente para la integración con Allure).

## Dependencias

Las dependencias principales se gestionan a través de Maven y se listan a continuación:

* `com.microsoft.playwright:playwright:1.50.0`
* `org.junit.jupiter:junit-jupiter-api:5.x.x` (implícito por Allure JUnit 5)
* `io.qameta.allure:allure-junit5:2.29.1`
* `org.apache.logging.log4j:log4j-api:2.24.3`
* `org.apache.logging.log4j:log4j-core:2.24.3`
* `net.datafaker:datafaker:2.4.2`
* `org.slf4j:slf4j-api:2.0.17`
* `org.slf4j:slf4j-simple:2.0.17`
* `org.aspectj:aspectjweaver:1.9.7`

## Configuración

1.  **Clonar el repositorio:**
    ```bash
    git clone < https://github.com/Troyano85/Playwright-POM-Java.git>
   
2.  **Asegurarse de tener Java y Maven instalados.**

3.  **Ejecutar las pruebas:**
    Para ejecutar las pruebas(con anotación @Regression), puedes usar el siguiente comando de Maven:
    ```bash
     mvn clean test -Dgroups="regression"

    ```

4.  **Generar el reporte de Allure:**
    Después de ejecutar las pruebas, puedes generar el informe de Allure con el siguiente comando:
    ```bash
    mvn allure:report
    ```
    Para abrir el informe en tu navegador:
    ```bash
    mvn allure:serve
    ```



Los resultados de las pruebas se reportan utilizando Allure Framework, generando informes HTML interactivos y detallados que incluyen pasos, adjuntos y otra información relevante sobre la ejecución de las pruebas.


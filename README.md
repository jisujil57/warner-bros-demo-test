# Проект по автоматизации тестирования web-сервиса www.warnerbros.com

## **Содержание:**

* <a href="#tools">Технологии и инструменты</a>
* <a href="#cases">Примеры автоматизированных тест-кейсов</a>
* <a href="#runner">Запуск автотестов</a>

<a id="tools"></a>
## <a name="Технологии и инструменты">**Технологии и инструменты:**</a>

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="readme/icons/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="readme/icons/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://gradle.org/"><img src="readme/icons/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://junit.org/junit5/"><img src="readme/icons/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://selenide.org/"><img src="readme/icons/Selenide.svg" width="50" height="50"  alt="Selenide"/></a> 
<a href="https://aerokube.com/selenoid/"><img src="readme/icons/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
<a href="ht[images](images)tps://github.com/allure-framework/allure2"><img src="readme/icons/Allure.svg" width="50" height="50"  alt="Allure"/></a> 
<a href="https://qameta.io/"><img src="readme/icons/Allure2.svg" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="readme/icons/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://www.atlassian.com/ru/software/jira/"><img src="readme/icons/Jira.svg" width="50" height="50"  alt="Jira"/></a>  
</p>

<a id="cases"></a>
## <a name="Примеры автоматизированных тест-кейсов">**Примеры автоматизированных тест-кейсов:**</a>

- Успешный поиск по ключевому слову
- Наличие ошибки при отсутствии результатов поиска
- Наличие списка разделов сайта в бургер меню при разрешении 1280x800
- Закрытие меню при разрешении 1280x800
- Переход в раздел Movies через меню

<a id="runner"></a>
## Запуск автотестов
**Локальный запуск:**
```bash  
gradle clean test
```

**Удалённый запуск через Jenkins (Build with Parameters):**

<details>
<summary>Параметры</summary>

- `${BASE_URL}` - базовый URL тестируемого сайта  
- `${BROWSER_NAME}` - название браузера  
- `${BROWSER_VERSION}` - версия браузера  
- `${BROWSER_SIZE}` - разрешение браузера  
- `${SELENOID_URL}` - базовый URL контейнера Selenoid  

</details>


```bash  
test
-DbaseUrl=${BASE_URL}
-Dbrowser=${BROWSER_NAME}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DselenoidUrl=${SELENOID_URL}
```

<a id="allure"></a>
## <img alt="Allure" height="25" src="readme/icons/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure report с историей</a>

### Overview
<details>
<summary>Скриншот</summary>
<p align="left">  
<img title="Allure Overview Dashboard" src="readme/images/allure_overview.png">  
</p> 
</details>

### Suites
<details>
<summary>Скриншот</summary>
<p align="left">  
<img title="Allure Tests" src="readme/images/allure_sutes.png">  
</p>
</details>

### Graphs
<details>
<summary>Скришноты</summary>

<p align="left">
  <img title="Allure Graphics" src="readme/images/allure_metrics1.png">
  <img title="Allure Graphics" src="readme/images/allure_metrics2.png">
</p>
</details>


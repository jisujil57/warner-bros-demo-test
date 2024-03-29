# Проект по автоматизации тестирования web-сервиса Warner Bros.

Проект по автоматизации тестирования web-сервиса www.warnerbros.com использует современные технологии и инструменты, такие как IntelliJ IDEA, Java, Gradle, JUnit 5, Selenide, Selenoid, Allure и Jenkins.  
<br>
Примеры автоматизированных тест-кейсов включают успешный поиск по ключевому слову, обработку ошибок при отсутствии результатов поиска, проверку наличия списка разделов сайта в бургер меню и другие. Запуск автотестов осуществляется через Gradle с возможностью настройки параметров, а также удалённо через Jenkins с использованием параметров сборки.  
<br>
Отчёты Allure предоставляют подробную информацию об общем обзоре, наборах тестов и графиках, обеспечивая прозрачность истории тестирования.</font>


## **Содержание:**

* <a href="#tools">Технологии и инструменты</a>
* <a href="#cases">Примеры автоматизированных тест-кейсов</a>
* <a href="#local_build">Запуск автотестов</a>
* <a href="#jenkins_build">Параметризированная сборка Jenkins</a>
* <a href="#telegram">Уведомление об упавших тестах в Telegram</a>
<br><br>


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
<br><br>


<a id="cases"></a>
## <a name="Примеры автоматизированных тест-кейсов">**Примеры автоматизированных тест-кейсов:**</a>

- Успешный поиск по ключевому слову
- Наличие ошибки при отсутствии результатов поиска
- Наличие списка разделов сайта в бургер меню при разрешении 1280x800
- Закрытие меню при разрешении 1280x800
- Переход в раздел Movies через меню
<br><br>


<a id="local_build"></a>
## Запуск автотестов
**Запуск через Gradle:**
  
```bash  
gradle clean test
```



**Запуск через Gradle с кастомными параметрами:**

```bash  
gradle clean test
-DbaseUrl=${BASE_URL}
-Dbrowser=${BROWSER_NAME}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DselenoidUrl=${SELENOID_URL}
```

<details>
<summary>Параметры</summary>

- `${BASE_URL}` - базовый URL тестируемого сайта  
- `${BROWSER_NAME}` - название браузера  
- `${BROWSER_VERSION}` - версия браузера  
- `${BROWSER_SIZE}` - разрешение браузера  
- `${SELENOID_URL}` - базовый URL контейнера Selenoid  

</details>



<a id="jenkins_build"></a>
## </a> <a name="Allure"></a>Запуск в Jenkins (Build with Parameters): </a> <img alt="Telegram" height="25" src="readme/icons/Jenkins.svg" width="25"/>
<img title="Allure Overview Dashboard" src="readme/images/jenkins_parametr.png"> 




```bash  
test
-DbaseUrl=${BASE_URL}
-Dbrowser=${BROWSER_NAME}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DselenoidUrl=${SELENOID_URL}
```



<a id="allure"></a>
## </a> <a name="Allure"></a>Allure report с историей: </a> <img alt="Allure" height="25" src="readme/icons/Allure.svg" width="25"/>

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
<summary>Скриншоты</summary>

<p align="left">
  <img title="Allure Graphics" src="readme/images/allure_metrics1.png">
  <img title="Allure Graphics" src="readme/images/allure_metrics2.png">
</p>
</details>

## <a name="Telegram"></a>Уведомление об упавших тестах в Telegram</a> <img alt="Telegram" height="25" src="readme/icons/Telegram.svg" width="25"/></a> 

<img title="Allure Graphics" src="readme/images/telegram_notifications.png">


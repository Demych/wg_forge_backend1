# wg_forge_backend1
1) Открываем папку в которую хотим скачать проект.
  Вызываем git bash.
  Вводим команду
 
  git clone https://github.com/Demych/wg_forge_backend1.git

2) Создать БД в Postgresql

3) В файле application.properties конфигурируется подключение к БД (название БД, пользователь и пароль) 

  spring.datasource.url=jdbc:postgresql://localhost:5432/wg_force_db
  spring.datasource.username=postgres
  spring.datasource.password=root

4) Собрать проект с помощью maven:
    1) Зайти в корень проекта
    2) Открыть консоль
    3) Ввести команду mvn clean install
  
    Гайд для установки maven, если его нет https://github.com/Flibberty-GEA/blog/wiki/03.a-%D0%9A%D0%B0%D0%BA-  %D1%83%D1%81%D1%82%D0%B0%D0%BD%D0%BE%D0%B2%D0%B8%D1%82%D1%8C-Maven-%D0%BD%D0%B0-Windows-10 .
  
 5) Файл инициализации БД  wg_forge_init.sql в папке wg_forge_backend1/src/main/resources/.
    (В таблице cats_stat: добавлено поле id как Primery key,
    убраны колонки  tail_length_mode integer[], whiskers_length_mode integer[], т.к не написал код их вычисления).
    
 6) В папке target открываем консоль и запускаем проект с помощью команды java -jar WOT-1.0-SNAPSHOT.jar (если ничего не менялось,      название WOT-1.0-SNAPSHOT должно остаться)

  7) Скрестив пальцы, вспомнив все хорошое,  ждать волшебной фразы "!!!!Всем привет, я поднялся!!!!"

========================================================================================================================================

Запросы на сервер:
GET http://localhost:8080/ping  - вернет строку "Cats Service. Version 0.1"

GET http://localhost:8080/cats - вернет всех котов из БД. 

GET http://localhost:8080/cats?attribute=tailLength?order=asc/desc  вернет котов отсортированных по указанному аттрибуту. ASC- по возрастанию, desc - по убыванию.
Параметры offer и limit не реализовывал. Валидация в данном задании тоже не сделана.

POST http://localhost:8080/cat сохраняет кота в БД. 
Тело запроса {

        "name": "Asya",  //не может быть пустым
       
        "color": "black", // может быть только: 'black', 'white','black & white','red','red & white','red & black & white'
        
        "tailLength": 10, // не можеть быть меньше нуля или равно нулю
        
        "whiskersLength": 10 // не может быть меньше нуля или равно нулю
        
    }
Возможные исключения валидации: ValidateNameException("Name can not be empty");

                            ValidateColorException("Color can not be empty");
                            
                            ValidateColorException("ValidationImpl error. There is no such color");
                            
                            ValidateTailException("The length of the tail can not be less than 0 or equal");
                            
                            ValidateWhiskersException("The length of the whiskers can not be less than 0 or equal");
                            
                            
Если указать неверный формат JSON, то выкенется исключение JSON parse error

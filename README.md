# wg_forge_backend1
1) Открываем папку в которую хотим скачать проект.
  Вызываем git bash.
  Вводим команду
 
  git clone https://github.com/Demych/wg_forge_backend1.git

2) Создать БД в Postgresql

3) В файле application.properties конфигурируется подключение к БД (название БД, пользователь и пароль) 
  # JDBC URL of the database.
  spring.datasource.url=jdbc:postgresql://localhost:5432/wg_force_db
  # Login username of the database.
  spring.datasource.username=postgres
  # Login password of the database.
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

Если где-то будет ломаться, звоните/пишите!) 

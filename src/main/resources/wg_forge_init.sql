CREATE TYPE cat_color AS ENUM (
    'black',
    'white',
    'black & white',
    'red',
    'red & white',
    'red & black & white'
);

/* Создаем таблицу котов*/

CREATE TABLE cats (
    name varchar,
    color cat_color,
    tail_length int,
    whiskers_length int,
    PRIMARY KEY (name)
);

/* Заполняем таблицу котов*/
INSERT INTO cats (name, color, tail_length, whiskers_length) VALUES
('Tihon', 'red & white', 15, 12),
('Marfa', 'black & white', 13, 11),
('Asya', 'black', 10, 10),
('Amur', 'black & white', 20, 11),
('Hustav', 'red & white', 12, 12),
('Dina', 'black & white', 17, 12),
('Gass', 'red & white', 15, 13),
('Vika', 'black', 14, 10),
('Clod', 'red & white', 12, 15),
('Neo', 'red', 11, 13),
('Nord', 'red & black & white', 19, 12),
('Kelly', 'red & white', 26, 11),
('Ost', 'white', 14, 12),
('Tayson', 'red & white', 18, 13),
('Lesya', 'black & white', 12, 15),
('Foma', 'black', 15, 18),
('Odett', 'red & white', 17, 13),
('Cesar', 'black & white', 18, 14),
('Shurik', 'red & white', 17, 13),
('Flora', 'black & white', 12, 15),
('Tara', 'red & white', 17, 12),
('Yasha', 'red & white', 18, 12),
('Chlo', 'black', 14, 13),
('Snow', 'white', 19, 14),
('Sam', 'black & white', 15, 15),
('Ula', 'red & white', 16, 14),
('Nemo', 'red & white', 17, 13)
;

/* Создаем таблицу статистики*/
CREATE TABLE cats_stat (
    id int, 
    tail_length_mean numeric,
    tail_length_median numeric,
    whiskers_length_mean numeric,
    whiskers_length_median numeric,
    PRIMARY KEY (id)
);



/* Заполняем строку в таблице статистики начальными данными */
insert into cats_stat(id,tail_length_mean, tail_length_median, whiskers_length_mean, whiskers_length_median) 
                      values (1,
                      (select avg(tail_length) from cats),
                      (select percentile_cont(0.5) within group (order by tail_length) from cats),
                      (select avg(whiskers_length) from cats),
                      (select percentile_cont(0.5) within group (order by whiskers_length) from cats));


/* Создаем таблицу статистики количества окраса*/
CREATE TABLE cat_colors_info (
    color cat_color UNIQUE,
    count int
);

/* Заполняем таблицу статистики количества окраса*/
insert into cat_colors_info(color, count) values ('black', (select count(color) from cats where color = 'black')),
						('white', (select count(color) from cats where color = 'white')),
						('black & white', (select count(color) from cats where color = 'black & white')),
						('red', (select count(color) from cats where color = 'red')),
						('red & white', (select count(color) from cats where color = 'red & white')),
						('red & black & white', (select count(color) from cats where color = 'red & black & white'));
						
/* Создаем триггерную функию для расчета и обновления полей таблицы статистики  */
CREATE OR REPLACE FUNCTION public."calc_AVG_median"()
  RETURNS trigger AS
$BODY$begin
update cats_stat
set tail_length_mean = (select avg(tail_length) from cats), 
    whiskers_length_mean = (select avg(whiskers_length) from cats),
    tail_length_median = (select percentile_cont(0.5) within group (order by tail_length) from cats),
    whiskers_length_median = (select percentile_cont(0.5) within group (order by whiskers_length) from cats)
where id = 1;
return NEW;
end;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION public."calc_AVG_median"()
  OWNER TO postgres;



/*Создаем триггер для обнавления таблицы статистики при обновлении таблицы котов  */
  CREATE TRIGGER "calculate_AVG_median"
  AFTER INSERT OR UPDATE OR DELETE
  ON public.cats
  FOR EACH ROW
  EXECUTE PROCEDURE public."calc_AVG_median"();


/* Создаем триггерную функию для расчета и обновления полей таблицы cat_colors_info  */
CREATE OR REPLACE FUNCTION public.calc_colors_info()
  RETURNS trigger AS
$BODY$begin
update cat_colors_info
set count = (select count(color) from cats where color = 'black')
where color = 'black';
update cat_colors_info
set count = (select count(color) from cats where color = 'white')
where color = 'white';
update cat_colors_info
set count = (select count(color) from cats where color = 'black & white')
where color = 'black & white';
update cat_colors_info
set count = (select count(color) from cats where color = 'red')
where color = 'red';
update cat_colors_info
set count = (select count(color) from cats where color = 'red & white')
where color = 'red & white';
update cat_colors_info
set count = (select count(color) from cats where color = 'red & black & white')
where color = 'red & black & white';
return NEW;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION public.calc_colors_info()
  OWNER TO postgres;


/*Создаем триггер для расчета и обновления полей таблицы cat_colors_info   */
CREATE TRIGGER calculate_colors_info_trigger
  AFTER INSERT OR UPDATE OR DELETE
  ON public.cats
  FOR EACH ROW
  EXECUTE PROCEDURE public.calc_colors_info();





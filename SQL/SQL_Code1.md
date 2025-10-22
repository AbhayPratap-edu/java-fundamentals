## Schema SQL (v8)
```sql
CREATE TABLE person
(person_id SMALLINT UNSIGNED AUTO_INCREMENT,
 fname VARCHAR(20),
 lname VARCHAR(20),
 eye_color ENUM('BR','BL','GR'),
 birth_date DATE,
 street VARCHAR(30),
 city VARCHAR(20),
 state VARCHAR(20),
 country VARCHAR(20),
 postal_code VARCHAR(20),
 CONSTRAINT pk_person PRIMARY KEY (person_id)
 );
 
 
CREATE TABLE favorite_food
(person_id SMALLINT UNSIGNED,
 food VARCHAR(20),
 CONSTRAINT pk_favorite_food PRIMARY KEY (person_id, food),
 CONSTRAINT fk_fav_food_person_id FOREIGN KEY (person_id)
 REFERENCES person (person_id)
 );
 
 INSERT INTO person
 (person_id, fname, lname, eye_color, birth_date)
 VALUES (null, 'William', 'Turner', 'BR', '1972-05-27');
 INSERT INTO person
 (person_id, fname, lname, eye_color, birth_date,
  street, city, country, postal_code)
  VALUES (null, 'susan', 'smith', 'BL', '1975-11-21',
          '23 Maple st. ', 'Arligton', 'USA', '20220');
          
 INSERT INTO favorite_food (person_id, food)
 VALUES (1, 'pizza');
 INSERT INTO favorite_food (person_id, food)
 VALUES (1, 'cookies');
 INSERT INTO favorite_food (person_id, food)
 VALUES (1, 'nachos');
 
 /*Updating Data*/
 UPDATE person
 SET street = '1225 Tremont St. ',
 city = 'Boston',
 state = 'MA',
 country = 'USA',
 postal_code = '02138'
 WHERE person_id = 1;
 
 UPDATE person
 SET birth_date = str_to_date('DEC-21-1980', '%b-%d-%Y')
 WHERE person_id = 1;
 
 /* Deleting Data */
 DELETE FROM person
 WHERE person_id = 2;
```
 ## Query SQL
 ```sql
desc person;

SELECT person_id, fname, lname, eye_color, birth_date
 FROM person
 WHERE person_id = 1;
 
 SELECT person_id, fname, lname, birth_date
 FROM person
 WHERE lname = 'Turner';
 
 SELECT food
 FROM favorite_food
 WHERE person_id = 1
 ORDER BY food;
```
## Results


**Query #1**

| Field       | Type                 | Null | Key | Default | Extra          |
| ----------- | -------------------- | ---- | --- | ------- | -------------- |
| person_id   | smallint unsigned    | NO   | PRI |  null   | auto_increment |
| fname       | varchar(20)          | YES  |     |  null   |                |
| lname       | varchar(20)          | YES  |     |  null   |                |
| eye_color   | enum('BR','BL','GR') | YES  |     |  null   |                |
| birth_date  | date                 | YES  |     |  null   |                |
| street      | varchar(30)          | YES  |     |  null   |                |
| city        | varchar(20)          | YES  |     |  null   |                |
| state       | varchar(20)          | YES  |     |  null   |                |
| country     | varchar(20)          | YES  |     |  null   |                |
| postal_code | varchar(20)          | YES  |     |  null   |                |

**Query #2**

| person_id | fname   | lname  | eye_color | birth_date |
| --------- | ------- | ------ | --------- | ---------- |
| 1         | William | Turner | BR        | 1980-12-21 |

**Query #3**

| person_id | fname   | lname  | birth_date |
| --------- | ------- | ------ | ---------- |
| 1         | William | Turner | 1980-12-21 |

**Query #4**

| food    |
| ------- |
| cookies |
| nachos  |
| pizza   |

 
 
 

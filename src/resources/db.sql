CREATE database IF NOT exists meals;
use meals;

drop table if exists meal_dish;
drop table if exists dish_stats;
drop table if exists dish;
drop table if exists meal;

create table meal(
	id int(10) not null auto_increment,
	primary key(id)
);
create table dish(
	id int(10) not null auto_increment, 
	dish_name varchar(20) not null,
	dish_type varchar(20) not null,
	primary key(id)
);
create table meal_dish(
	meal_id int(10) not null,
	dish_id int(10) not null,
	foreign key(meal_id) references meal(id),
	foreign key(dish_id) references dish(id) 
);
CREATE TABLE dish_stats(
	id int(10) NOT NULL,
	dish_id int(10) NOT NULL,
	count int(10) NOT NULL,
	FOREIGN key(dish_id) REFERENCES dish(id)
);

CREATE database IF NOT exists meals;
use meals;

drop table if exists meal_dish;
drop table if exists dish_stats;
drop table if exists dish;
drop table if exists meal;

create table meal(
	id int(10) not null auto_increment,
	meal_type varchar(20) NOT NULL,
	primary key(id)
);
create table dish(
	id int(10) not null auto_increment, 
	dish_name varchar(20) not null,
	dish_type varchar(20) not null,
	primary key(id)
);
insert into dish
	(dish_name, dish_type)
	values ("Cereal", "MAIN"),
		("Pizza", "MAIN"),
		("Lasagna", "MAIN"),
		("Peas", "SIDE"),
		("Corn", "SIDE"),
		("Fries", "SIDE");
create table meal_dish(
	meal_id int(10) not null,
	dish_id int(10) not null,
	foreign key(meal_id) references meal(id),
	foreign key(dish_id) references dish(id) 
);
CREATE TABLE dish_stats(
	id int(10) NOT NULL auto_increment,
	dish_id int(10) NOT NULL,
	count int(10) NOT NULL,
	PRIMARY KEY(id),
	FOREIGN key(dish_id) REFERENCES dish(id) ON DELETE CASCADE
);

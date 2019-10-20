CREATE database IF NOT exists meals;
use meals;

drop table if exists meal_dish;
drop table if exists dish;
drop table if exists plan;
drop table if exists meal;

create table meal(
	id int(10) not null auto_increment,
	main_dish_id int(10) not null,
	side_dish_id int(10) not null, 
	meal_time date not null,
	primary key(id)
);
create table dish(
	id int(10) not null auto_increment, 
	dish_name varchar(20) not null,
	type varchar(20) not null,
	primary key(id)
);
create table meal_dish(
	meal_id int(10) not null,
	dish_id int(10) not null,
	foreign key(meal_id) references meal(id),
	foreign key(dish_id) references dish(id) 
);
create table plan(
	id int(10) not null auto_increment,
	meal_id int(10) not null,
	schedule_start int(4),
	schedule_end int(4),
	primary key(id),
	foreign key(meal_id) references meal(id)	
);
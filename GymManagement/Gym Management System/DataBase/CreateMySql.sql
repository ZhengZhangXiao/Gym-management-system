create database ABCFitnessDao;

use ABCFitnessDao;
create table user_info(usertype int,name varchar(50) ,password varchar(50),email varchar(50), cellPhone varchar(50),  homeClub varchar(50));


insert into user_info(usertype,name,password,email,cellPhone, homeClub)
values (0,"Amy","12345","Amy@gmail.com","2078732563","club1"),
(0,"Bob","12345","Bob@gmail.com","207932063","club2"),
(1,"Kim","212345","Kim@gmail.com","2028752560","club1"),
(1,"Jack","013365","Jack@gmail.com","1024752570","club2"),
(1,"Rose","102545","Rose@gmail.com","2048567860","club1"),
(1,"Sophie","813462","Sophie@gmail.com","6754752570","club2"),
(1,"Tom","457305","Tom@gmail.com","2029775291","club1"),
(1,"Mary","093469","Mary@gmail.com","2029757531","club2");

use ABCFitnessDao;

create table class_info(classNo int auto_increment primary key,className varchar(50),time varchar(50),teacher varchar(50));

insert into class_info(className,time ,teacher)
values ("Yoga","Monday","Jim"),("Cycle","Tuesday","Mariah"),("Zumba","Wednesday","Brandon"),("Zumba","Thursday","Natalie"),("Yoga","Friday","Avery");







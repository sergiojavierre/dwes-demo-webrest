create database cine;

use cine;

create table directores(
	nombre varchar(100) primary key
);

create table generos(
	nombre varchar(50) primary key
);

create table peliculas(
	titulo varchar(100),
	año year,
	director varchar(100),
	genero varchar(50),
	primary key (titulo,año),
	foreign key (director) references directores(nombre),
	foreign key (genero) references generos(nombre)
);
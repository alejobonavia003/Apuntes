set search_path = part2;

create table municipios (
	"municipio" varchar(50) primary key not null unique,
	"provincia" varchar(50) not null
);

create table vacunas(
	"cod_vacuna" varchar(50) primary key not null unique,
	"nombre" varchar(50) not null
);

create table personas (
	"dni" varchar(50) primary key not null unique,
	"nombre" varchar(50),
	"edad" integer,
	"municipio" varchar(50),
	constraint fk_persona_municipio
		foreign key (municipio) 
		references part2.municipios (municipio)
);

create table contagios (
	"dni" varchar(50) not null unique,
	"cepa" varchar(50) primary key not null unique,
	constraint cf_contagios_personas
		foreign key (dni)
		references part2.personas (dni)
);

create table vacunados (
	"dni" varchar(50) not null unique,
	"cod_vacuna" varchar(50) not null ,
	primary key (dni, cod_vacuna)
);


create domain tipoVacuna as varchar(50)
	check (value in('COVID','FIEBRE', 'AMARILLA', 'DENGUE', 'SARAMPION'));



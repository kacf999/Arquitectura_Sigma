CREATE DATABASE seguros_parq_origen;

USE seguros_parq_origen;

CREATE TABLE Cliente(

    nombre varchar(30),
    primerApellido varchar(30),
    segundoApellido varchar(30),
    fechaNacimiento varchar(10),
    domicilio varchar(100),
    curp varchar(20)
);
-- drop database if exists passreminder;

Create database PassReminder;
Use PassReminder;

Create table usuario(
	id_usuario int auto_increment primary key not null,
    email_user varchar(150) unique not null,
    password_U varchar(265) not null
);

Create table pass(
	id_pass int auto_increment primary key not null,
    pagina_pass varchar(250) not null,
    nombre_pass varchar(250) not null,
    pass varchar(265) not null,
    id_usuario_FK int not null
);

ALTER TABLE pass
ADD CONSTRAINT pass_usuario
FOREIGN KEY (id_usuario_FK)
REFERENCES usuario (id_usuario) ON UPDATE CASCADE ON DELETE CASCADE;

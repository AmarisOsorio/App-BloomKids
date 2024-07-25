Base de datos terminada 

```Sql Developer 


Create table tbEnfermedad( 
UUId_Enfermedad varchar2(64) Primary key, 
Nombre_Enfermedad varchar2 (20) 
)

drop table tbPaciente
Create table tbPaciente( 
UUID_PACIENTE varchar2(64) Primary key, 
Nombres_Paciente varchar2 (40),
Apellidos_Paciente varchar2 (40), 
Edad number )

drop table tbNumCamas
Create table tbNumCamas( 
UUID_NUMEROCAMA varchar2(64) Primary key, 
NumeroCama number )

drop table tbHabitaciones
Create table tbHabitaciones( 
UUID_numHabitaciones varchar2(64) primary key, 
numeroHabitacion number )

Create table tbMedicamentos( 
UUID_MEDICAMENTOS varchar2(64) Primary key,
Nombre_Medicamento varchar2(30) )

drop table tbTipo_Enfermedad
Create table tbDetallesPacientes(
Hora_Aplicacion_Medicamento varchar2(30), 
UUID_MEDICAMENTOS varchar2(64), 
UUID_numHabitaciones varchar2(64),
UUId_Enfermedad varchar2(64),
UUID_PACIENTE varchar2(64),
UUID_NUMEROCAMA varchar2(64),
Constraint fK_UUID_NUMEROCAMA
FOREIGN KEY (UUID_NUMEROCAMA) 
REFERENCES tbNumCamas (UUID_NUMEROCAMA), 
CONSTRAINT Fk_UUId_Enfermedad
FOREIGN KEY (UUId_Enfermedad)
References tbEnfermedad (UUId_Enfermedad), 
Constraint Fk_UUID_MEDICAMENTOS 
FOREIGN KEY (UUID_MEDICAMENTOS)
REFERENCES tbMedicamentos (UUID_MEDICAMENTOS),
Constraint Fk_UUID_numHabitaciones 
FOREIGN KEY (UUID_numHabitaciones) 
References tbHabitaciones (UUID_numHabitaciones), 
Constraint Fk_UUID_PACIENTE 
FOREIGN KEY (UUID_PACIENTE) 
REFERENCES tbPaciente (UUID_PACIENTE) )


Insert all into tbEnfermedad (UUId_Enfermedad, Nombre_Enfermedad) values ('1','Dengue') 
into tbEnfermedad (UUId_Enfermedad, Nombre_Enfermedad) values ('2','Gripe') 
into tbEnfermedad (UUId_Enfermedad, Nombre_Enfermedad) values ('3','Calentura')
into tbEnfermedad (UUId_Enfermedad, Nombre_Enfermedad) values ('5','Diabetes') 
into tbEnfermedad (UUId_Enfermedad, Nombre_Enfermedad) values ('4','Migraña') 
select * from dual;

Insert all into tbPaciente (UUID_PACIENTE, Nombres_Paciente, Apellidos_Paciente, Edad) values ('1','Juan', 'Dominguez',18 ) 
into tbPaciente (UUID_PACIENTE, Nombres_Paciente, Apellidos_Paciente, Edad) values ('2','Marlon', 'Guzman', 25) 
into tbPaciente (UUID_PACIENTE, Nombres_Paciente, Apellidos_Paciente, Edad) values ('3','Bryan', 'Cornejo', 20) 
into tbPaciente (UUID_PACIENTE, Nombres_Paciente, Apellidos_Paciente, Edad) values ('5','Abigail', 'Morales', 27)
into tbPaciente (UUID_PACIENTE, Nombres_Paciente, Apellidos_Paciente,Edad) values ('4','Gerson', 'Navarro',30)
select * from dual;

Insert all into tbNumCamas (UUID_NUMEROCAMA, NumeroCama) values ('1', 12) 
into tbNumCamas (UUID_NUMEROCAMA, NumeroCama) values ('2', 3)
into tbNumCamas (UUID_NUMEROCAMA, NumeroCama) values ('3', 2) 
into tbNumCamas (UUID_NUMEROCAMA, NumeroCama) values ('4', 25) 
into tbNumCamas (UUID_NUMEROCAMA, NumeroCama) values ('5', 14) 
select * from dual;

Insert all into tbHabitaciones (UUID_numHabitaciones, numeroHabitacion)values ('1', 1) 
into tbHabitaciones (UUID_numHabitaciones, numeroHabitacion) values ('2', 2)
into tbHabitaciones (UUID_numHabitaciones, numeroHabitacion) values ('3', 3)
into tbHabitaciones (UUID_numHabitaciones, numeroHabitacion) values ('4', 4)
into tbHabitaciones (UUID_numHabitaciones, numeroHabitacion) values ('5', 5) 
select * from dual;

Insert all into tbMedicamentos (UUID_MEDICAMENTOS, Nombre_Medicamento) values ('1', 'Acetaminofen') 
into tbMedicamentos (UUID_MEDICAMENTOS, Nombre_Medicamento) values ('2', 'Ibuprofeno')
into tbMedicamentos (UUID_MEDICAMENTOS, Nombre_Medicamento) values ('3', 'Naproxceno')
into tbMedicamentos (UUID_MEDICAMENTOS, Nombre_Medicamento) values ('4', 'Suero') 
into tbMedicamentos (UUID_MEDICAMENTOS, Nombre_Medicamento) values ('5', 'Simeticona') 
select * from dual;

```

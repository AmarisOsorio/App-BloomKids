Base de datos(pegarla aquí)


Create table tbTipo_Enfermedad(
UUId_Enfermedad number Primary key,
Nombre_Enfermedad varchar2 (20)
)

Create table tbPaciente(
UUID_PACIENTE number Primary key,
Nombres_Paciente varchar2 (40),
Apellidos_Paciente varchar2 (40),
Edad number
)

Create table tbNumCamas(
UUID_NUMEROCAMA number Primary key,
NumeroCama number
)

Create table tbHabitaciones(
UUID_numHabitaciones number primary key,
numeroHabitacion number
)

Create table tbMedicamentos(
UUID_MEDICAMENTOS number Primary key,
Nombre_Medicamento varchar2(30)
)

Create table tbDetallesPacientes(
Hora_Aplicacion_Medicamento number,
UUID_MEDICAMENTOS number,
UUID_numHabitaciones number,
UUId_Enfermedad number,
UUID_PACIENTE number,
UUID_NUMEROCAMA number,
Constraint fK_UUID_NUMEROCAMA
FOREIGN KEY (UUID_NUMEROCAMA)
REFERENCES tbNumCamas (UUID_NUMEROCAMA),
CONSTRAINT Fk_UUId_Enfermedad
FOREIGN KEY (UUId_Enfermedad)
References tbTipo_Enfermedad (UUId_Enfermedad),
Constraint Fk_UUID_MEDICAMENTOS
FOREIGN KEY (UUID_MEDICAMENTOS)
REFERENCES tbMedicamentos (UUID_MEDICAMENTOS),
Constraint Fk_UUID_numHabitaciones
FOREIGN KEY (UUID_numHabitaciones)
References tbHabitaciones (UUID_numHabitaciones),
Constraint  Fk_UUID_PACIENTE
FOREIGN KEY (UUID_PACIENTE)
REFERENCES tbPaciente (UUID_PACIENTE)
)

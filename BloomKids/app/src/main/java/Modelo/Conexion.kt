package Modelo

import java.sql.Connection
import java.sql.DriverManager

class Conexion {
        fun cadenaConexio(): Connection? {
            try {
                val ip = "jdbc:oracle:thin:@192.168.1.2:1521:xe"
                val usuario = "Amaris_Developer"
                val contrasena = "Chalateca_1006"

                val conexion = DriverManager.getConnection(ip, usuario, contrasena)
                return conexion
            }catch (e: Exception){
                println("El error es este: $e")
                return null
            }
        }

    }

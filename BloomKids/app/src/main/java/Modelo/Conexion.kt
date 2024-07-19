package Modelo

import java.sql.Connection
import java.sql.DriverManager

class Conexion {
        fun cadenaConexion(): Connection? {
            try {
                val ip = "jdbc:oracle:thin:@192.168.92.126:1521:xe"
                val usuario = "BloomKids"
                val contrasena = "BlommKinds1"

                val conexion = DriverManager.getConnection(ip, usuario, contrasena)
                return conexion
            }catch (e: Exception){
                println("El error es este: $e")
                return null
            }
        }

    }

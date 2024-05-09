package com.danielsapplication.app

import java.io.Serializable

data class Emocion(val emocion: String,
                   val intensidad: Int,
                   val img: Int,
                   val descripcion: String,
                   val fecha: String): Serializable {
    constructor():this("",-1,-1,"", "")
}
package com.danielsapplication.app

data class Usuario(val id:String,
                   val username:String,
                   val emociones: ArrayList<Emocion>){
    constructor():this("","", ArrayList())
}
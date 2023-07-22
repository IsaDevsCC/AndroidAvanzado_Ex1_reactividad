package com.example.androidavanzado.model

data class Model(
    val name : String,
    val photo : String
){
    companion object {
        fun dummy() : Model {
            return Model(name = "Homer Simpson", photo = "https://static.wikia.nocookie.net/esfuturama/images/f/f2/PhilipJ.Fry.png/revision/latest?cb=20120825055147")
        }
    }
}



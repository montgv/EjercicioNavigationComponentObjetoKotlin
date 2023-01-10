package com.example.ejercicionavigationcomponentobjetokotlin

import android.os.Parcel
import android.os.Parcelable

//Definimos la clase Persona
class Persona (var nombre: String?, var apellidos: String?, var telefono: Int) : Parcelable{
    //Sirve para leer los atributos del objeto Persona
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    //Aplana el objeto Persona en una parcela, escribir el objeto en una parcela
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(apellidos)
        parcel.writeInt(telefono)
    }

    //Parcelable tiene que tener un campo estatico no nulo
    companion object CREATOR : Parcelable.Creator<Persona> {
        override fun createFromParcel(parcel: Parcel): Persona {
            return Persona(parcel)
        }

        override fun newArray(size: Int): Array<Persona?> {
            return arrayOfNulls(size)
        }
    }
}
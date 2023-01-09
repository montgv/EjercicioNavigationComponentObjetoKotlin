package com.example.ejercicionavigationcomponentobjetokotlin

import android.os.Parcel
import android.os.Parcelable

class Persona (var nombre: String?, var apellidos: String?, var telefono: Int) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(apellidos)
        parcel.writeInt(telefono)
    }

    companion object CREATOR : Parcelable.Creator<Persona> {
        override fun createFromParcel(parcel: Parcel): Persona {
            return Persona(parcel)
        }

        override fun newArray(size: Int): Array<Persona?> {
            return arrayOfNulls(size)
        }
    }
}
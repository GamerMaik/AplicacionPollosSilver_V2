package com.example.aplicacionpollossilver.Domain

import android.os.Parcel
import android.os.Parcelable

data class PedidosDomain(
    var title: String,
    var cantidad: Int,
    var description: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeInt(cantidad)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PedidosDomain> {
        override fun createFromParcel(parcel: Parcel): PedidosDomain {
            return PedidosDomain(parcel)
        }

        override fun newArray(size: Int): Array<PedidosDomain?> {
            return arrayOfNulls(size)
        }
    }
}
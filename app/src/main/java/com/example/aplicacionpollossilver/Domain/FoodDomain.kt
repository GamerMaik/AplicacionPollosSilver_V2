package com.example.aplicacionpollossilver.Domain

import android.graphics.ImageFormat
import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class FoodDomain(
    var title: String,
    var pic: Int,
    var fee: Double,
    var cantidad: Int,
    var description: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeInt(pic)
        parcel.writeDouble(fee)
        parcel.writeInt(cantidad)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FoodDomain> {
        override fun createFromParcel(parcel: Parcel): FoodDomain {
            return FoodDomain(parcel)
        }

        override fun newArray(size: Int): Array<FoodDomain?> {
            return arrayOfNulls(size)
        }
    }
}
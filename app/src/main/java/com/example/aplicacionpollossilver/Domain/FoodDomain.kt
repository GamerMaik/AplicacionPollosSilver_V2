package com.example.aplicacionpollossilver.Domain

import android.graphics.ImageFormat
import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class FoodDomain(
    var title: String,
    var pic: Int,
    var fee: Double
) : Parcelable {
    constructor(parcel: Parcel?) : this(
        parcel?.readString() ?: "",
        parcel!!.readInt(),
        parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, p1: Int) {
        parcel.writeString(title)
        parcel.writeInt(pic)
        parcel.writeDouble(fee)
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<FoodDomain> {
        override fun createFromParcel(parcel: Parcel?): FoodDomain {
            return FoodDomain(parcel)
        }
        override fun newArray(size: Int): Array<FoodDomain?> {
            return arrayOfNulls(size)
        }
    }
}
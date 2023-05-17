package com.example.aplicacionpollossilver.Domain

import java.io.Serializable

class FoodDomain(
    var title:String,
    var pic: String,
    var description: String,
    var fee: Double,
    var numberInCart: Int ):Serializable {

}
package com.example.aplicacionpollossilver.Domain

class CategoryDomain(private var title: String, private var pic: String) {
    fun getTitle(): String {
        return title
    }
    fun setTitle(title: String) {
        this.title = title
    }

    fun getPic(): String {
        return pic
    }

    fun setPic(pic: String) {
        this.pic = pic
    }
}
package com.marcheilla.appmarcheilla.data.model

data class NewsList (
    val articles : List<News> = arrayListOf(),
    val totalResults : Int = 0,
    val status : String = ""

)
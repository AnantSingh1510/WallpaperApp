package com.musicapp.wallpaper.Models

data class Category(
    val name : String,
    val description: String,
    val coverUrl: String,
    val wallpapers: List<String>
){
    constructor(): this("", "", "", emptyList())
}

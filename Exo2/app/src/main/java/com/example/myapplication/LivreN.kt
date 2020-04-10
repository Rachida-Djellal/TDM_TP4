package com.example.myapplication

class LivreN {
    private val payName: String
   private val  image_name:String
    private val image :Int

    constructor(movieName: String,image:Int,image_name:String){
        //code
        this.payName = movieName
        this.image=image
        this.image_name=image_name
    }

    fun getAnimalName(): String {
        return this.payName
    }
    fun getImageName(): String {
        return this.image_name
    }
    fun getImage(): Int {
        return this.image
    }
}
package com.example.myapplication

class LivreN {
   val payName: String
 var  image_name:String
    val image :Int

    constructor(payName: String,image:Int,image_name:String){
        //code
        this.payName = payName
        this.image=image
        this.image_name=image_name
    }

    fun setimageName(pos:String) {
      this.image_name = pos
    }


}
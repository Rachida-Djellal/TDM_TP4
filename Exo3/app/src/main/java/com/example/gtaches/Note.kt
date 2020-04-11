package com.example.gtaches

import java.util.*

class Note {

    var date:Date?=null
    var note:String?=null
    var id:Int=0

    constructor( date:Date,note:String,id:Int){
        this.date=date
        this.note=note
        this.id=id
    }
}
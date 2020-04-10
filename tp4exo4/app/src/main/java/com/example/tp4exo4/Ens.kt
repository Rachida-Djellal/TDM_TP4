package com.example.tp4exo4

class Ens {
    private val Name: String
    private val  Prenom:String
    private val  Adresse:String
    private val Age: String
    private val  Diplome:String
    private val  Telephone:String


    constructor(Name: String,name:String,s:String,d:String,k:String,l:String){
        //code
        this.Name= Name

        this.Prenom=name
        this.Adresse=s
        this.Age=d
        this.Diplome=k
        this.Telephone=l
    }

    fun getName(): String {
        return this.Name
    }
    fun getPrenom(): String {
        return this.Prenom
    }
    fun getAdresse(): String {
        return this.Adresse
    }

    fun getAge(): String {
        return this.Age
    }

    fun getTelephne(): String {
        return this.Telephone
    }
    fun getDeplome(): String {
        return this.Diplome
    }
}
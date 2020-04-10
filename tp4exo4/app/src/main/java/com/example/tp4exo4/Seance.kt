package com.example.tp4exo4

class Seance {
    private val NameM: String
    private val  DateS:String
    private val  Salle:String
    private val Enseignant: String
    private val  DureeTotal:String
    private val  Intitule:String


    constructor(Name: String,name:String,s:String,d:String,k:String,l:String){
        //code
        this.NameM = Name

        this.DateS=name
        this.Salle=s
        this.Enseignant=d
        this.DureeTotal=k
        this.Intitule=l
    }

    fun getNameM(): String {
        return this.NameM
    }
    fun getDateS(): String {
        return this.DateS
    }
    fun getSalle(): String {
        return this.Salle
    }

    fun getEnseignant(): String {
        return this.Enseignant
    }

    fun getDureeTotal(): String {
        return this.DureeTotal
    }
    fun getIntitule(): String {
        return this.Intitule
    }


}
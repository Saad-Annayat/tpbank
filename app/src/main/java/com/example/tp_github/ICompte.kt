package com.example.tp_github

interface ICompte {
    fun verse(montant: Double): Boolean
    fun retire(montant: Double)
    fun virement(montant: Double, compte: Compte)
    fun ConsulterSolde(): Double
    fun totalVersement(): Double
    fun totalRetirement(): Double
}
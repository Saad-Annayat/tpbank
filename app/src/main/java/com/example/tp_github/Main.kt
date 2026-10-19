package com.example.tp_github

fun main() {

    val c1 = CompteCourant(101, 5000.0, StatusDeCompte.CREATED, 1000.0)

    println("Solde Initial : ${c1.ConsulterSolde()} DHS")

    c1.verse(2000.0)
    println("Solde après versement : ${c1.ConsulterSolde()} DHS")

    c1.retire(7000.0)
    println("Solde après retrait : ${c1.ConsulterSolde()} DHS")
    println("Total Retiré : ${c1.totalRetirement()} DHS")

    val c2 = CompteEpargne(102, 3000.0, StatusDeCompte.CREATED, 0.05) // 5% d'intérêt

    c1.virement(500.0, c2) // Virement normal
    println("Solde du Compte Courant après virement : ${c1.ConsulterSolde()} DHS")
    println("Solde du Compte Épargne après virement : ${c2.ConsulterSolde()} DHS")

    c2.calculInteret()
    println("Solde Épargne après application des intérêts : ${c2.ConsulterSolde()} DHS")

    c1.afficherHistorique()
    c2.afficherHistorique()
}

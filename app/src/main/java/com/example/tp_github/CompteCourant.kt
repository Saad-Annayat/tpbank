package com.example.tp_github

class CompteCourant(
    code: Int,
    solde: Double,
    status: StatusDeCompte,
    val decouvert: Double
) : Compte(code, solde, status) {

    override fun verifierSoldeSufisant(montant: Double): Boolean {
        return montant <= solde + decouvert
    }
    override fun retire(montant: Double) {
        if (montant <= solde + decouvert) {
            solde -= montant
            totalRetire += montant
        }
    }
}
package com.example.tp_github

class CompteEpargne(
    code: Int,
    solde: Double,
    status: StatusDeCompte,
    val tauxInteret: Double
) : Compte(code, solde, status) {

    // L-retrait dyal l-Epargne khass l-solde ykoun kafi nichan (bla decouvert)
    override fun retire(montant: Double) {
        if (montant <= solde) {
            solde -= montant
            totalRetire += montant
        }
    }

    // Fonction bch n-calculiw l-interet w n-zidouh f s-solde (Q6)
    fun calculInteret() {
        val interet = solde * tauxInteret
        solde += interet
        totalVerse += interet // n-3tabroha b7al versement f l-total
    }
}
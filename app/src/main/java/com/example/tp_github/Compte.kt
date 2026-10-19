package com.example.tp_github
import java.util.Date

abstract class Compte(
    val code: Int,
    var solde: Double,
    var status: StatusDeCompte
) : ICompte {

    var totalVerse = 0.0
    var totalRetire = 0.0

    val operations = mutableListOf<Operation>()

    companion object {
        private var compteurOp = 1
        fun genererNumeroOp(): Int {
            return compteurOp++
        }
    }

    override fun verse(montant: Double): Boolean {
        if (montant > 0) {
            solde += montant
            totalVerse += montant
            operations.add(Versement(genererNumeroOp(), Date(), montant))
            return true
        }
        return false
    }

    open fun verifierSoldeSufisant(montant: Double): Boolean {
        return montant <= solde
    }

    open override fun retire(montant: Double) {
        if (verifierSoldeSufisant(montant)) {
            solde -= montant
            totalRetire += montant
            operations.add(Retrait(genererNumeroOp(), Date(), montant))
        } else {
            println("Erreur: Solde insuffisant pour effectuer le retrait de $montant DHS sur le compte $code")
        }
    }

    override fun virement(montant: Double, compte: Compte) {
        if (verifierSoldeSufisant(montant)) {
            this.solde -= montant
            this.totalRetire += montant
            this.operations.add(Retrait(genererNumeroOp(), Date(), montant))

            compte.solde += montant
            compte.totalVerse += montant
            compte.operations.add(Versement(genererNumeroOp(), Date(), montant))
            println("virement effectuee")
        } else {
            println("Erreur: Solde insuffisant pour effectuer le virement de $montant DHS")
        }
    }

    override fun ConsulterSolde(): Double {
        return this.solde
    }

    override fun totalVersement(): Double {
        return totalVerse
    }

    override fun totalRetirement(): Double {
        return totalRetire
    }

    fun afficherHistorique() {
        println("\n Historique des opérations du compte N°$code ")
        if (operations.isEmpty()) {
            println("Aucune opération effectuée sur ce compte.")
        } else {
            for (op in operations) {
                val typeOp = if (op is Versement) "VERSEMENT" else "RETRAIT"
                println("Opération N°${op.numero} | Type : $typeOp | Montant : ${op.montant} DHS | Date : ${op.date}")
            }
        }
    }
}

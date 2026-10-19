package com.example.tp_github

import java.util.Date

class Versement(
    numero: Int,
    date: Date,
    montant: Double
) : Operation(numero, date, montant)
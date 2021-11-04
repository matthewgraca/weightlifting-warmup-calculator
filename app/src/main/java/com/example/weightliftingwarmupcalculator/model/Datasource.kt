package com.example.weightliftingwarmupcalculator.model

import com.example.weightliftingwarmupcalculator.R
import com.example.weightliftingwarmupcalculator.data.Pound
import com.example.weightliftingwarmupcalculator.data.Scheme

class Datasource {

    fun loadSets(): List<SetScheme>{
        return listOf<SetScheme>(
            SetScheme(R.string.set_1),
            SetScheme(R.string.set_2),
            SetScheme(R.string.set_3),
            SetScheme(R.string.set_4)
        )
        /*
        val scheme = Scheme(4,300, Pound())
        val sets = scheme.getWeightScheme()
        return sets.toList()

         */
    }
}
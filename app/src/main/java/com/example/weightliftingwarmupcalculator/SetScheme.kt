package com.example.weightliftingwarmupcalculator

import java.lang.IllegalArgumentException

class SetScheme(private val sets: Int, private val workingWeight: Int, private val unit: String) {
    private val barWeight: Int
    private var scheme: IntArray

    /**
     * Properly initializes workingWeight, unit, and sets. Also initializes set scheme
     */
    init{
        // arg check workingWeight and unit
        when (unit) {
            "kilograms" -> {
                barWeight = 20
                if (workingWeight < 20){
                    throw IllegalArgumentException("Working weight must be >= 20")
                }
            }
            "pounds" -> {
                barWeight = 45
                if (workingWeight < 45){
                    throw IllegalArgumentException("Working weight must be >= 45")
                }
            }
            else -> {
                throw IllegalArgumentException("Unit must be either in kilograms or pounds")
            }
        }

        // arg check sets
        if (sets < 1){
            throw IllegalArgumentException("Sets must be greater than 0")
        }

        // initialize set scheme immediately
        scheme = calculateScheme()
    }

    /**
     * Getter for workingWeight
     * @return  working weight
     */
    public fun getWorkingWeight(): Int{
        return workingWeight
    }

    /**
     * Getter for unit
     * @return  the unit (in kilograms or pounds)
     */
    public fun getUnit(): String{
        return unit
    }

    /**
     * Getter for barWeight
     * @return  the weight of the bar, determined by kilograms (20) or pounds (45)
     */
    public fun getBarWeight(): Int{
        return barWeight
    }

    /**
     * Getter for scheme
     * @return  the set scheme to be used by the lifter, as an array
     */
    public fun getScheme(): IntArray{
        return scheme
    }

    /**
     * Helper function that calculates the set scheme the lifter follows
     * @return  the set scheme the lifter follows, as an array
     */
    private fun calculateScheme(): IntArray{
        /*val scheme = IntArray(sets)
        val incrementWeight = (workingWeight - barWeight) / sets
        var subtotal = barWeight
        var i = 0
        while (i < sets){
            subtotal += incrementWeight
            scheme[i] = subtotal
            i++
        }
        return scheme*/
        return IntArray(0)
    }
}
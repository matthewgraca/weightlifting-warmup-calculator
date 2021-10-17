package com.example.weightliftingwarmupcalculator

import java.lang.IllegalArgumentException
import kotlin.math.roundToInt

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
    fun getWorkingWeight(): Int{
        return workingWeight
    }

    /**
     * Getter for unit
     * @return  the unit (in kilograms or pounds)
     */
    fun getUnit(): String{
        return unit
    }

    /**
     * Getter for barWeight
     * @return  the weight of the bar, determined by kilograms (20) or pounds (45)
     */
    fun getBarWeight(): Int{
        return barWeight
    }

    /**
     * Getter for scheme
     * @return  the set scheme to be used by the lifter, as an array
     */
    fun getScheme(): IntArray{
        return scheme
    }

    /**
     * Helper function that calculates the set scheme the lifter follows
     * @return  the set scheme the lifter follows, as an array
     */
    private fun calculateScheme(): IntArray{
        val tempScheme = IntArray(sets)
        val incrementWeight = roundToNearest5th((workingWeight - barWeight) / (sets * 1.0))
        var subtotal = barWeight
        var i = 0
        while (i < sets){
            subtotal += incrementWeight
            tempScheme[i] = subtotal
            i++
        }
        tempScheme[sets-1] = workingWeight  // enforce the final set to be the working weight
        return tempScheme
    }

    /**
     * Helper function that rounds a double to the nearest 5th, and converts it into an integer
     * @param   num the number being converted
     * @return  the number rounded to the nearest 5, as an integer
     */
    private fun roundToNearest5th(num: Double): Int{
        return (kotlin.math.ceil(num / 5.0) * 5).roundToInt()
    }
}
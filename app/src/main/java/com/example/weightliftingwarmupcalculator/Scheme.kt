package com.example.weightliftingwarmupcalculator

import java.lang.IllegalArgumentException
import kotlin.math.roundToInt

class Scheme(private val sets: Int, private val workingWeight: Int, private val unit: Unit) {
    private var weightScheme: IntArray
    private var plateScheme: Array<IntArray>

    /**
     * Properly initializes workingWeight, unit, and sets. Also initializes set scheme
     */
    init{
        // arg check weight
        if (unit is Kilogram && workingWeight < 20){
            throw IllegalArgumentException("Weight must be greater than or equal to 20")
        }
        if (unit is Pound && workingWeight < 45){
            throw IllegalArgumentException("Weight must be greater than or equal to 45")
        }
        // arg check sets
        if (sets < 1){
            throw IllegalArgumentException("Sets must be greater than 0")
        }

        // initialize weight and plate scheme immediately
        weightScheme = calculateWeightScheme()
        plateScheme = calculatePlateScheme()
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
        return if (unit is Kilogram) "kilogram" else "pound"
    }

    /**
     * Getter for barWeight
     * @return  the weight of the bar, determined by kilograms (20) or pounds (45)
     */
    fun getBarWeight(): Int{
        return unit.barWeight
    }

    /**
     * Getter for scheme
     * @return  the set scheme to be used by the lifter, as an array
     */
    fun getWeightScheme(): IntArray{
        return weightScheme
    }

    /**
     * Finds the global plate scheme for every set
     * @return  a two-dimensional array of plate schemes for each set
     */
    fun getPlateScheme(): Array<IntArray>{
        return plateScheme
    }

    /**
     * Helper function that calculates the plate scheme for every set
     * @return  a two-dimensional array of plate schemes for each set
     */
    private fun calculatePlateScheme(): Array<IntArray>{
        val completePlateScheme: Array<IntArray> = Array(sets){IntArray(unit.plateArray.size)}
        for (i in completePlateScheme.indices){
            completePlateScheme[i] = calculatePlateScheme(weightScheme[i])
        }
        return completePlateScheme
    }

    /**
     * Helper function that calculates the weight scheme the lifter follows
     * @return  the set scheme the lifter follows, as an array
     */
    private fun calculateWeightScheme(): IntArray{
        val tempScheme = IntArray(sets)
        val exactIncrement = (workingWeight - unit.barWeight) / (sets * 1.0)
        var subtotal = unit.barWeight.toDouble()
        for (i in tempScheme.indices){
            subtotal += exactIncrement
            tempScheme[i] = roundToNearest5th(subtotal)
        }
        tempScheme[sets-1] = workingWeight  // enforce the final set to be the working weight
        return tempScheme
    }

    /**
     * Helper function that rounds a double to the nearest 5th
     * @param   num the number being converted
     * @return  the number rounded to the nearest 5, as an integer
     */
    private fun roundToNearest5th(num: Double): Int{
        return (num / 5).roundToInt() * 5
    }

    /**
     * Calculates the set of plates needed to construct a given weight
     * @return  an array of plates that constructs the given weight
     */
    private fun calculatePlateScheme(weight: Int): IntArray{
        val tempScheme = IntArray(unit.plateArray.size)
        var currentWeight = weight - unit.barWeight
        for (i in tempScheme.indices){
            tempScheme[i] = currentWeight / unit.plateArray[i]
            currentWeight %= unit.plateArray[i]
        }
        return tempScheme
    }
}
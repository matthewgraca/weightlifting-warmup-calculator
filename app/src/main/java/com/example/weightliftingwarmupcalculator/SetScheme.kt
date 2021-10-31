package com.example.weightliftingwarmupcalculator

import java.lang.IllegalArgumentException
import kotlin.math.roundToInt

class SetScheme(private val sets: Int, private val workingWeight: Int, private val unit: Unit) {
    private var scheme: IntArray

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
    fun getScheme(): IntArray{
        return scheme
    }

    /**
     * Finds the global plate scheme for every set
     * @return  a two-dimensional array of plate schemes for each set
     */
    fun getPlateScheme(): Array<IntArray>{
        val completePlateScheme: Array<IntArray> = Array(sets){IntArray(unit.plateArray.size)}
        for (i in completePlateScheme.indices){
            completePlateScheme[i] = plateScheme(scheme[i])
        }
        return completePlateScheme
    }

    /**
     * Helper function that calculates the set scheme the lifter follows
     * @return  the set scheme the lifter follows, as an array
     */
    private fun calculateScheme(): IntArray{
        val tempScheme = IntArray(sets)
        val incrementWeight = (workingWeight - unit.barWeight) / (sets * 1.0)
        var subtotal = unit.barWeight.toDouble()
        for (i in tempScheme.indices){
            subtotal += incrementWeight
            tempScheme[i] = roundToNearest5th(subtotal)
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
        return (num/5).roundToInt() * 5
    }

    /**
     * Takes weight and gives the set of plates needed to construct that weight
     * @return  an array of plates that constructs the given weight
     */
    private fun plateScheme(weight: Int): IntArray{
        val plates = IntArray(unit.plateArray.size)
        var currentWeight = weight - unit.barWeight
        for (i in plates.indices){
            plates[i] = currentWeight / unit.plateArray[i]
            currentWeight %= unit.plateArray[i]
        }
        return plates
    }
}
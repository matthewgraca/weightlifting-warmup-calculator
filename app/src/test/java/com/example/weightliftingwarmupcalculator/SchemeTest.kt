package com.example.weightliftingwarmupcalculator

import com.example.weightliftingwarmupcalculator.data.Kilogram
import com.example.weightliftingwarmupcalculator.data.Pound
import com.example.weightliftingwarmupcalculator.data.Scheme
import org.junit.Assert.*
import org.junit.Test
import java.lang.IllegalArgumentException

class SchemeTest{
    // Tests for constructors
    @Test
    fun testConstructorPoundsNormalExample(){
        try{
            val scheme = Scheme(4, 265, Pound())
            assertTrue(scheme.getWorkingWeight() == 265 && scheme.getUnit() == "pound")
        }
        catch(exception: Exception) {
            assertTrue(false)
        }
    }

    @Test
    fun testConstructorPoundsLowerLimit(){
        try{
            val scheme = Scheme(4, 45, Pound())
            assertTrue(scheme.getWorkingWeight() == 45 && scheme.getUnit() == "pound")
        }
        catch(exception: Exception) {
            assertTrue(false)
        }
    }

    @Test
    fun testConstructorPoundsBelowLowerLimit(){
        try{
            Scheme(4, 40, Pound())
            assertTrue(false)
        }
        catch(exception: IllegalArgumentException) {
            assertTrue(true)
        }
    }

    @Test
    fun testConstructorKilogramsLowerLimit(){
        try{
            val scheme = Scheme(4, 20, Kilogram())
            assertTrue(scheme.getWorkingWeight() == 20 && scheme.getUnit() == "kilogram")
        }
        catch(exception: Exception) {
            assertTrue(false)
        }
    }

    @Test
    fun testConstructorKilogramsBelowLowerLimit(){
        try{
            Scheme(4, 10, Kilogram())
            assertTrue(false)
        }
        catch(exception: IllegalArgumentException) {
            assertTrue(true)
        }
    }

    @Test
    fun testConstructorInvalidSetCount(){
        try{
            Scheme(0, 30, Kilogram())
            assertTrue(false)
        }
        catch(exception: IllegalArgumentException) {
            assertTrue(true)
        }
    }

    // Tests for calculating scheme
    @Test
    fun testCalculateSchemePounds1(){
        val scheme = Scheme(4, 265, Pound())
        val setScheme = scheme.getWeightScheme()
        val solution = intArrayOf(100, 155, 210, 265)
        assertArrayEquals(solution, setScheme)
    }

    @Test
    fun testCalculateSchemePounds2(){
        val scheme = Scheme(4, 300, Pound())
        val setScheme = scheme.getWeightScheme()
        val solution = intArrayOf(110, 175, 235, 300)
        assertArrayEquals(solution, setScheme)
    }

    @Test
    fun testCalculateSchemePounds3(){
        val scheme = Scheme(4, 238, Pound())
        val setScheme = scheme.getWeightScheme()
        val solution = intArrayOf(95, 140, 190, 238)
        assertArrayEquals(solution, setScheme)
    }

    @Test
    fun testCalculateSchemeKilograms1(){
        val scheme = Scheme(4, 270, Kilogram())
        val setScheme = scheme.getWeightScheme()
        val solution = intArrayOf(85, 145, 210, 270)
        assertArrayEquals(solution, setScheme)
    }

    @Test
    fun testCalculateSchemeKilograms2(){
        val scheme = Scheme(4, 200, Kilogram())
        val setScheme = scheme.getWeightScheme()
        val solution = intArrayOf(65, 110, 155, 200)
        assertArrayEquals(solution, setScheme)
    }

    @Test
    fun testCalculateSchemeKilograms3(){
        val scheme = Scheme(4, 238, Kilogram())
        val setScheme = scheme.getWeightScheme()
        val solution = intArrayOf(75, 130, 185, 238)
        assertArrayEquals(solution, setScheme)
    }

    // Tests for calculating plate scheme
    @Test
    fun testPlateSchemePounds1(){
        val scheme = Scheme(4, 265, Pound())
        val plateScheme = scheme.getPlateScheme()
        val solution = arrayOf( intArrayOf(0, 0, 0, 1, 0, 0, 1),
                                intArrayOf(1, 0, 0, 0, 0, 0, 0),
                                intArrayOf(1, 0, 0, 1, 0, 0, 1),
                                intArrayOf(2, 0, 0, 0, 0, 0, 0))
        assertArrayEquals(solution, plateScheme)
    }

    @Test
    fun testPlateSchemePounds2(){
        val scheme = Scheme(4, 300, Pound())
        val plateScheme = scheme.getPlateScheme()
        val solution = arrayOf( intArrayOf(0, 0, 0, 1, 0, 1, 1),
                                intArrayOf(1, 0, 0, 0, 1, 0, 0),
                                intArrayOf(1, 0, 1, 0, 0, 1, 0),
                                intArrayOf(2, 0, 0, 0, 1, 1, 1))
        assertArrayEquals(solution, plateScheme)
    }

    @Test
    fun testPlateSchemePounds3(){
        val scheme = Scheme(4, 238, Pound())
        val plateScheme = scheme.getPlateScheme()
        val solution = arrayOf( intArrayOf(0, 0, 0, 1, 0, 0, 0),
                                intArrayOf(0, 1, 0, 0, 0, 0, 1),
                                intArrayOf(1, 0, 0, 0, 1, 1, 1),
                                intArrayOf(1, 0, 1, 0, 0, 1, 0))
        assertArrayEquals(solution, plateScheme)
    }

    @Test
    fun testPlateSchemeKilograms1(){
        val scheme = Scheme(4, 270, Kilogram())
        val plateScheme = scheme.getPlateScheme()
        val solution = arrayOf(
            intArrayOf(1, 0, 0, 0, 1, 1, 0, 0, 0, 0),
            intArrayOf(2, 0, 0, 1, 0, 1, 0, 0, 0, 0),
            intArrayOf(3, 1, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(5, 0, 0, 0, 0, 0, 0, 0, 0, 0))
        assertArrayEquals(solution, plateScheme)
    }

    @Test
    fun testPlateSchemeKilograms2(){
        val scheme = Scheme(4, 200, Kilogram())
        val plateScheme = scheme.getPlateScheme()
        val solution = arrayOf(
            intArrayOf(0, 1, 0, 0, 0, 1, 0, 0, 0, 0),
            intArrayOf(1, 1, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(2, 0, 1, 0, 0, 1, 0, 0, 0, 0),
            intArrayOf(3, 0, 1, 0, 0, 0, 0, 0, 0, 0))
        assertArrayEquals(solution, plateScheme)
    }

    @Test
    fun testPlateSchemeKilograms3(){
        val scheme = Scheme(4, 238, Kilogram())
        val plateScheme = scheme.getPlateScheme()
        val solution = arrayOf(
            intArrayOf(1, 0, 0, 0, 0, 1, 0, 0, 0, 0),
            intArrayOf(2, 0, 0, 0, 1, 0, 0, 0, 0, 0),
            intArrayOf(3, 0, 0, 0, 1, 1, 0, 0, 0, 0),
            intArrayOf(4, 0, 0, 0, 1, 1, 0, 1, 0, 0))
        assertArrayEquals(solution, plateScheme)
    }

    // test multiple sets
    @Test
    fun testMultipleSetsPounds1(){
        val scheme = Scheme(10, 175, Pound())
        val setScheme = scheme.getWeightScheme()
        val solution = intArrayOf(60, 70, 85, 95, 110, 125, 135, 150, 160, 175)
        assertArrayEquals(solution, setScheme)
    }

    @Test
    fun testMultipleSetsPounds2(){
        val scheme = Scheme(7, 335, Pound())
        val setScheme = scheme.getWeightScheme()
        val solution = intArrayOf(85, 130, 170, 210, 250, 295, 335)
        assertArrayEquals(solution, setScheme)
    }

    @Test
    fun testMultipleSetsPounds3(){
        val scheme = Scheme(1, 300, Pound())
        val setScheme = scheme.getWeightScheme()
        val solution = intArrayOf(300)
        assertArrayEquals(solution, setScheme)
    }

    @Test
    fun testMultipleSetsKilos1(){
        val scheme = Scheme(10, 270, Kilogram())
        val setScheme = scheme.getWeightScheme()
        val solution = intArrayOf(45, 70, 95, 120, 145, 170, 195, 220, 245, 270)
        assertArrayEquals(solution, setScheme)
    }

    @Test
    fun testMultipleSetsKilos2(){
        val scheme = Scheme(7, 332, Kilogram())
        val setScheme = scheme.getWeightScheme()
        val solution = intArrayOf(65, 110, 155, 200, 245, 285, 332)
        assertArrayEquals(solution, setScheme)
    }

    @Test
    fun testMultipleSetsKilos3(){
        val scheme = Scheme(1, 123, Kilogram())
        val setScheme = scheme.getWeightScheme()
        val solution = intArrayOf(123)
        assertArrayEquals(solution, setScheme)
    }
}
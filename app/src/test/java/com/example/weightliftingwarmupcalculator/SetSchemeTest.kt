package com.example.weightliftingwarmupcalculator

import org.junit.Assert.*
import org.junit.Test
import java.lang.IllegalArgumentException

class SetSchemeTest{
    // Tests for constructors
    @Test
    fun testConstructorPoundsNormalExample(){
        try{
            val scheme = SetScheme(4, 265, Pound())
            assertTrue(scheme.getWorkingWeight() == 265 && scheme.getUnit() == "pound")
        }
        catch(exception: Exception) {
            assertTrue(false)
        }
    }

    @Test
    fun testConstructorPoundsLowerLimit(){
        try{
            val scheme = SetScheme(4, 45, Pound())
            assertTrue(scheme.getWorkingWeight() == 45 && scheme.getUnit() == "pound")
        }
        catch(exception: Exception) {
            assertTrue(false)
        }
    }

    @Test
    fun testConstructorPoundsBelowLowerLimit(){
        try{
            SetScheme(4, 40, Pound())
            assertTrue(false)
        }
        catch(exception: IllegalArgumentException) {
            assertTrue(true)
        }
    }

    @Test
    fun testConstructorKilogramsLowerLimit(){
        try{
            val scheme = SetScheme(4, 20, Kilogram())
            assertTrue(scheme.getWorkingWeight() == 20 && scheme.getUnit() == "kilogram")
        }
        catch(exception: Exception) {
            assertTrue(false)
        }
    }

    @Test
    fun testConstructorKilogramsBelowLowerLimit(){
        try{
            SetScheme(4, 10, Kilogram())
            assertTrue(false)
        }
        catch(exception: IllegalArgumentException) {
            assertTrue(true)
        }
    }

    @Test
    fun testConstructorInvalidSetCount(){
        try{
            SetScheme(0, 30, Kilogram())
            assertTrue(false)
        }
        catch(exception: IllegalArgumentException) {
            assertTrue(true)
        }
    }

    // Tests for calculating scheme
    @Test
    fun testCalculateSchemePounds1(){
        val scheme = SetScheme(4, 265, Pound())
        val setScheme = scheme.getScheme()
        val solution = intArrayOf(100, 155, 210, 265)
        assertArrayEquals(solution, setScheme)
    }

    @Test
    fun testCalculateSchemePounds2(){
        val scheme = SetScheme(4, 300, Pound())
        val setScheme = scheme.getScheme()
        val solution = intArrayOf(110, 175, 240, 300)
        assertArrayEquals(solution, setScheme)
    }

    @Test
    fun testCalculateSchemePounds3(){
        val scheme = SetScheme(4, 238, Pound())
        val setScheme = scheme.getScheme()
        val solution = intArrayOf(95, 145, 195, 238)
        assertArrayEquals(solution, setScheme)
    }

    @Test
    fun testCalculateSchemeKilograms1(){
        val scheme = SetScheme(4, 270, Kilogram())
        val setScheme = scheme.getScheme()
        val solution = intArrayOf(85, 150, 215, 270)
        assertArrayEquals(solution, setScheme)
    }

    @Test
    fun testCalculateSchemeKilograms2(){
        val scheme = SetScheme(4, 200, Kilogram())
        val setScheme = scheme.getScheme()
        val solution = intArrayOf(65, 110, 155, 200)
        assertArrayEquals(solution, setScheme)
    }

    @Test
    fun testCalculateSchemeKilograms3(){
        val scheme = SetScheme(4, 238, Kilogram())
        val setScheme = scheme.getScheme()
        val solution = intArrayOf(75, 130, 185, 238)
        assertArrayEquals(solution, setScheme)
    }

    // Tests for calculating plate scheme
    @Test
    fun testPlateSchemePounds1(){
        val scheme = SetScheme(4, 265, Pound())
        val plateScheme = scheme.getPlateScheme()
        val solution = arrayOf( intArrayOf(0, 0, 0, 1, 0, 0, 1),
                                intArrayOf(1, 0, 0, 0, 0, 0, 0),
                                intArrayOf(1, 0, 0, 1, 0, 0, 1),
                                intArrayOf(2, 0, 0, 0, 0, 0, 0))
        assertArrayEquals(solution, plateScheme)
    }

    @Test
    fun testPlateSchemePounds2(){
        val scheme = SetScheme(4, 300, Pound())
        val plateScheme = scheme.getPlateScheme()
        val solution = arrayOf( intArrayOf(0, 0, 0, 1, 0, 1, 1),
                                intArrayOf(1, 0, 0, 0, 1, 0, 0),
                                intArrayOf(1, 0, 1, 0, 0, 1, 1),
                                intArrayOf(2, 0, 0, 0, 1, 1, 1))
        assertArrayEquals(solution, plateScheme)
    }

    @Test
    fun testPlateSchemePounds3(){
        val scheme = SetScheme(4, 238, Pound())
        val plateScheme = scheme.getPlateScheme()
        val solution = arrayOf( intArrayOf(0, 0, 0, 1, 0, 0, 0),
                                intArrayOf(0, 1, 0, 0, 0, 1, 0),
                                intArrayOf(1, 0, 0, 0, 2, 0, 0),
                                intArrayOf(1, 0, 1, 0, 0, 1, 0))
        assertArrayEquals(solution, plateScheme)
    }

    @Test
    fun testPlateSchemeKilograms1(){
        val scheme = SetScheme(4, 270, Kilogram())
        val plateScheme = scheme.getPlateScheme()
        val solution = arrayOf(
            intArrayOf(1, 0, 0, 0, 1, 1, 0, 0, 0, 0),
            intArrayOf(2, 0, 1, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(3, 1, 0, 0, 0, 1, 0, 0, 0, 0),
            intArrayOf(5, 0, 0, 0, 0, 0, 0, 0, 0, 0))
        assertArrayEquals(solution, plateScheme)
    }

    @Test
    fun testPlateSchemeKilograms2(){
        val scheme = SetScheme(4, 200, Kilogram())
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
        val scheme = SetScheme(4, 238, Kilogram())
        val plateScheme = scheme.getPlateScheme()
        val solution = arrayOf(
            intArrayOf(1, 0, 0, 0, 0, 1, 0, 0, 0, 0),
            intArrayOf(2, 0, 0, 0, 1, 0, 0, 0, 0, 0),
            intArrayOf(3, 0, 0, 0, 1, 1, 0, 0, 0, 0),
            intArrayOf(4, 0, 0, 0, 1, 1, 0, 1, 0, 0))
        assertArrayEquals(solution, plateScheme)
    }
}
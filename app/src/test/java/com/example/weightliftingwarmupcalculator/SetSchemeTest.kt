package com.example.weightliftingwarmupcalculator

import org.junit.Assert.*
import org.junit.Test
import java.lang.IllegalArgumentException

class SetSchemeTest{
    // Tests for constructors
    @Test
    fun testConstructorPoundsNormalExample(){
        try{
            val scheme = SetScheme(4, 265, "pounds")
            assertTrue(scheme.getWorkingWeight() == 265 && scheme.getUnit() == "pounds")
        }
        catch(exception: Exception) {
            assertTrue(false)
        }
    }

    @Test
    fun testConstructorPoundsLowerLimit(){
        try{
            val scheme = SetScheme(4, 45, "pounds")
            assertTrue(scheme.getWorkingWeight() == 45 && scheme.getUnit() == "pounds")
        }
        catch(exception: Exception) {
            assertTrue(false)
        }
    }

    @Test
    fun testConstructorPoundsBelowLowerLimit(){
        try{
            SetScheme(4, 40, "pounds")
            assertTrue(false)
        }
        catch(exception: IllegalArgumentException) {
            assertTrue(true)
        }
    }

    @Test
    fun testConstructorKilogramsLowerLimit(){
        try{
            val scheme = SetScheme(4, 20, "kilograms")
            assertTrue(scheme.getWorkingWeight() == 20 && scheme.getUnit() == "kilograms")
        }
        catch(exception: Exception) {
            assertTrue(false)
        }
    }

    @Test
    fun testConstructorKilogramsBelowLowerLimit(){
        try{
            SetScheme(4, 10, "kilograms")
            assertTrue(false)
        }
        catch(exception: IllegalArgumentException) {
            assertTrue(true)
        }
    }

    @Test
    fun testConstructorUnitMisspelling(){
        try{
            SetScheme(4, 30, "kilogams")
            assertTrue(false)
        }
        catch(exception: IllegalArgumentException) {
            assertTrue(true)
        }
    }

    @Test
    fun testConstructorInvalidSetCount(){
        try{
            SetScheme(0, 30, "kilograms")
            assertTrue(false)
        }
        catch(exception: IllegalArgumentException) {
            assertTrue(true)
        }
    }

    // Tests for calculating scheme
    @Test
    fun testCalculateScheme1(){
        val scheme = SetScheme(4, 265, "pounds")
        val setScheme = scheme.getScheme()
        val solution = intArrayOf(100, 155, 210, 265)
        assertArrayEquals(solution, setScheme)
    }

    @Test
    fun testCalculateScheme2(){
        val scheme = SetScheme(4, 300, "pounds")
        val setScheme = scheme.getScheme()
        val solution = intArrayOf(110, 175, 240, 300)
        assertArrayEquals(solution, setScheme)
    }

    @Test
    fun testCalculateScheme3(){
        val scheme = SetScheme(4, 238, "pounds")
        val setScheme = scheme.getScheme()
        val solution = intArrayOf(95, 145, 195, 238)
        assertArrayEquals(solution, setScheme)
    }

    // Tests for calculating plate scheme
    @Test
    fun testPlateScheme1(){
        val scheme = SetScheme(4, 265, "pounds")
        val plateScheme = scheme.getPlateScheme()
        for (i in plateScheme.indices){
            println(plateScheme[i].contentToString())
        }
        val solution = arrayOf( intArrayOf(0, 0, 0, 1, 0, 0, 1),
                                intArrayOf(1, 0, 0, 0, 0, 0, 0),
                                intArrayOf(1, 0, 0, 1, 0, 0, 1),
                                intArrayOf(2, 0, 0, 0, 0, 0, 0))
        assertArrayEquals(solution, plateScheme)
    }
}
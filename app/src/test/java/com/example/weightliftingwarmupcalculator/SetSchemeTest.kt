package com.example.weightliftingwarmupcalculator

import org.junit.Assert.*
import org.junit.Test
import java.lang.IllegalArgumentException

class SetSchemeTest{
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
}
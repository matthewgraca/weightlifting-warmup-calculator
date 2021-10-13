package com.example.weightliftingwarmupcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weightliftingwarmupcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener{calculateScheme()}
    }

    /**
     * This function calculates the weight scheme the user will follow
     */
    private fun calculateScheme(){
        val workingWeight = binding.workingWeight.text.toString().toIntOrNull()

        if (workingWeight == null || workingWeight == 0){
            val emptyScheme = IntArray(4)
            displayScheme(emptyScheme)
        }
        else{
            val weightedSets = 4
            val emptyBarLbs = 45
            val scheme = setScheme(emptyBarLbs, workingWeight, weightedSets)
            displayScheme(scheme)
        }
    }

    /**
     * This function calculates the set scheme the user will follow
     * @param   barWeight   the weight of the empty bar
     * @param   weight      the final weight
     * @param   sets        the amount of sets in the warmup scheme, including the working weight
     * @return  an array of the warmup scheme being used
     */
    private fun setScheme(barWeight: Int, weight: Int, sets: Int): IntArray{
        val scheme = IntArray(sets)
        val incrementWeight = (weight - barWeight) / sets
        var subtotal = barWeight
        var i = 0
        while (i < sets){
            subtotal += incrementWeight
            scheme[i] = subtotal
            i++
        }
        return scheme
    }

    /**
     * This function displays the scheme the user follows
     * @param   scheme  an array of the weight scheme the user is following
     */
    private fun displayScheme(scheme: IntArray){
        binding.set1Result.text = getString(R.string.set_1, scheme[0].toString())
        binding.set2Result.text = getString(R.string.set_2, scheme[1].toString())
        binding.set3Result.text = getString(R.string.set_3, scheme[2].toString())
        binding.set4Result.text = getString(R.string.set_4, scheme[3].toString())
    }
}
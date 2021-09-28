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

    private fun calculateScheme(){
        val workingWeight = binding.workingWeight.text.toString().toIntOrNull()

        if (workingWeight == null || workingWeight == 0){
            displayScheme(0, 0)
        }
        else{
            var i = 1
            val weightedSets = 4
            val emptyBarLbs = 45
            var incrementWeight = (workingWeight - emptyBarLbs) / weightedSets
            var subtotalWeight = emptyBarLbs
            while (i <= weightedSets){
                subtotalWeight += incrementWeight
                displayScheme(subtotalWeight, i)
                i++
            }
        }
    }

    private fun displayScheme(weight: Int, setIndex: Int){
        val formattedWeight = weight.toString()
        when (setIndex) {
            1 -> {
                binding.set1Result.text = getString(R.string.set_1, formattedWeight)
            }
            2 -> {
                binding.set2Result.text = getString(R.string.set_2, formattedWeight)
            }
            3 -> {
                binding.set3Result.text = getString(R.string.set_3, formattedWeight)
            }
            else -> {
                binding.set4Result.text = getString(R.string.set_4, formattedWeight)
            }
        }
    }
}
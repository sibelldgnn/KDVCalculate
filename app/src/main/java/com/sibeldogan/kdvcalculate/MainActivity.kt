package com.sibeldogan.kdvcalculate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sibeldogan.kdvcalculate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Calculate.setOnClickListener {
            KdvOtv()
        }
    }

    fun KdvOtv() {

        val amount = binding.amountEditText.text.toString()
        val amountChange = amount.toDoubleOrNull()
        val selectedItem = binding.CylinderVolume.checkedRadioButtonId
        val selectedKdvOtv = binding.kdvOtvCalculate.isChecked
        if (amountChange == null) {
            binding.total.text = ""
            return
        }
        if (selectedKdvOtv) {
            binding.textView8.text = "KDV + ÖTV Hesaplandı"
            var selected = when (selectedItem) {

                R.id.cylenderVolume1 -> (amountChange + amountChange * 0.45 + amountChange * 0.18)
                R.id.cylenderVolume2 -> (amountChange + amountChange * 0.50 + amountChange * 0.18)
                R.id.cylenderVolume3 -> (amountChange + amountChange * 0.80 + amountChange * 0.18)
                R.id.cylenderVolume4 -> (amountChange + amountChange * 1.3 + amountChange * 0.18)
                R.id.cylenderVolume5 -> (amountChange + amountChange * 1.5 + amountChange * 0.18)
                else
                -> (amountChange + amountChange * 2.2 + amountChange * 0.18)

            }

            binding.total.text = "$selected"

        } else {
            binding.textView8.text = "ÖTV Hesaplandı"
            var selected = when (selectedItem) {

                R.id.cylenderVolume1 -> (amountChange + amountChange * 0.45)
                R.id.cylenderVolume2 -> (amountChange + amountChange * 0.50)
                R.id.cylenderVolume3 -> (amountChange + amountChange * 0.80)
                R.id.cylenderVolume4 -> (amountChange + amountChange * 1.3)
                R.id.cylenderVolume5 -> (amountChange + amountChange * 1.5)
                else
                -> (amountChange + amountChange * 2.2)

            }

            binding.total.text = "$selected"
        }

    }
}
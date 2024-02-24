package com.example.hesapmakinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.hesapmakinesi.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            button0.appendClick("0")
            button1.appendClick("1")
            button2.appendClick("2")
            button3.appendClick("3")
            button4.appendClick("4")
            button5.appendClick("5")
            button6.appendClick("6")
            button7.appendClick("7")
            button8.appendClick("8")
            button9.appendClick("9")
            buttonTopla.appendClick("+")
            buttonCarpma.appendClick("*")
            buttonCikar.appendClick("-")
            buttonVirgul.appendClick(".")
            buttonBolme.appendClick("/")

            buttonTemizle.setOnClickListener {
                binding.editText.text = null
            }
            buttonSil.setOnClickListener {
                val degisken = editText.text.toString()
                if (degisken.isNotEmpty()){
                    editText.setText(degisken.substring(0,degisken.length-1))
                }
            }
            buttonEsittir.setOnClickListener {
                val degisken = ExpressionBuilder(binding.editText.text.toString()).build()
                val sonuc = degisken.evaluate()
                val longSonuc = sonuc.toLong()

                if (sonuc == longSonuc.toDouble()){
                    binding.editText.setText(longSonuc.toString())
                } else {
                    binding.editText.setText(sonuc.toString())
                }
            }

        }
    }
    private fun View.appendClick(string: String){
        setOnClickListener {
         binding.editText.append(string)
        }
    }
}
package br.senai.sp.jandira.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.sax.StartElementListener
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        button_calcular.setOnClickListener {
            if (validar()==true) {
                calcularImc()
            }
        }

        button_limpar.setOnClickListener {
            limpar()
        }
    }

    fun limpar(){
        edit_peso.text.clear()
        edit_altura.text.clear()
        edit_peso.requestFocus()
    }

    fun calcularImc(){

        var imc = imc()
        imc.peso = edit_peso.text.toString().toDouble()
        imc.altura = edit_altura.text.toString().toDouble()

        text_resultado.text = imc.calcularImc().toString()

        Toast.makeText(this, "Meu primeiro programa android!", Toast.LENGTH_LONG).show()
    }

    fun validar() :Boolean{
        if (edit_peso.text.isEmpty()){
            edit_peso.error = "Preencha este campo!"
            return false
        }else if (edit_altura.text.isEmpty()){
            edit_altura.error = "Preencha este campo!"
            return false
        }else{
            return true
        }
    }
}
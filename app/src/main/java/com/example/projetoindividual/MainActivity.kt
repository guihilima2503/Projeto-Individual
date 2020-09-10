package com.example.projetoindividual

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun CalcRenda(componente:View){

        val total:Double = et_salario.text.toString().toDouble()
        val inss:Double = et_inss.text.toString().toDouble()
        val irrf:Double = et_irrf.text.toString().toDouble()
        val vra:Double = et_vr.text.toString().toDouble()
        val saude:Double= et_saude.text.toString().toDouble()

        if (inss < 0 && irrf < 0 && vra < 0 && saude < 0){
             Toast.makeText(this, "Campos invalidos", Toast.LENGTH_SHORT).show()
        }
            when {
                total < 0 ->{
                    Toast.makeText(this, "A remuneraação não deve ser menor ou igual a zero", Toast.LENGTH_SHORT).show()
                }
                inss >= 100 ->{
                    Toast.makeText(this, "O campo INSS deve ser menor que 100", Toast.LENGTH_SHORT).show()
                }
                irrf >= 100 -> {
                    Toast.makeText(this, "O campo IRRF deve ser menor que 100", Toast.LENGTH_SHORT).show()
                }
                vra >= 100 -> {
                    Toast.makeText(this, "O campo VR e ou VA  deve ser menor que 100", Toast.LENGTH_SHORT).show()
                }
                saude >= 100 -> {
                    Toast.makeText(this, "O campo Convenio deve ser menor que 100", Toast.LENGTH_SHORT).show()
                }
            }


        val resultadoPorcento:Double = inss + irrf + vra + saude
        val resultadoImposto: Double = (inss + irrf + vra + saude) * total / 100
        val resultado:Double = total - resultadoImposto
        edite_resultadoPorcentagem.text = "Total de porcentagem a ser descontado é de ${resultadoPorcento}"
        edite_resultadoImposto.text = "Total descontado do salario é de ${resultadoImposto} Reais"
        edite_resultado.text = "O salario liquido a ser recebido é de ${resultado}"

    }





}
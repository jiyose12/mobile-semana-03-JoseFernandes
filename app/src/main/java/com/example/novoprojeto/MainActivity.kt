package com.example.novoprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var botao: Button
    private val setList = mutableSetOf<Int>()
    private var aleatorio = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.botao = findViewById(R.id.btnCliqueAqui)

        //this.botao.text = "Eita!"
/*
        this.botao.setOnClickListener({
            var aleatorio = Random()
            this.botao.text = aleatorio.nextInt(60).toString()
        })
 */
        this.botao.setOnClickListener({ clique(it) })
    }

    fun generateUniqueNumber(){
        var a = this.aleatorio.nextInt(60);
        if (!this.setList.contains(a)) {
            this.setList += a
        }
        else {
            Log.w("NOVOPROJETO", "Número que se repetiu: "+ a.toString())
            generateUniqueNumber()
        }
    }

    fun clique(view: View){
        this.setList.clear();
        for (i in 0..5) {
            generateUniqueNumber()
        }
        Log.i("NOVOPROJETO", this.setList.toString())
    }
}
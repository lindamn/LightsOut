package com.example.lightsout

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val lights : Array<IntArray> = Array(5){IntArray(5){0} }
    private val lightsFlag : Array<BooleanArray> = Array(5) {BooleanArray(5) {false} }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun pressLight(view: View){

        var moveCount: TextView = findViewById(R.id.no_of_views)

        for(i in 0..4){
            for(j in 0..4){
                if(view.id == lights[i][j]){
                    if(lightsFlag[i][j] == false){
                        view.setBackgroundColor(Color.RED)
                        lightsFlag[i][j] = true
                    }else{
                        view.setBackgroundColor(Color.GRAY)
                        lightsFlag[i][j] = false
                    }
                    if(i in 0..3){
                        if(lightsFlag[i+1][j] == false){
                            findViewById<TextView>(lights[i+1][j]).setBackgroundColor(Color.RED)
                            lightsFlag[i+1][j] = true
                        }else{
                            findViewById<TextView>(lights[i+1][j]).setBackgroundColor(Color.GRAY)
                            lightsFlag[i+1][j] = false
                        }
                    }
                    if(i in 1..4){
                        if(lightsFlag[i-1][j] == false){
                            findViewById<TextView>(lights[i-1][j]).setBackgroundColor(Color.RED)
                            lightsFlag[i-1][j] = true
                        }else{
                            findViewById<TextView>(lights[i-1][j]).setBackgroundColor(Color.GRAY)
                            lightsFlag[i-1][j] = false
                        }
                    }
                    if(j in 0..3){
                        if(lightsFlag[i][j+1] == false){
                            findViewById<TextView>(lights[i][j+1]).setBackgroundColor(Color.RED)
                            lightsFlag[i][j+1] = true
                        }else{
                            findViewById<TextView>(lights[i][j+1]).setBackgroundColor(Color.GRAY)
                            lightsFlag[i][j+1] = false
                        }
                    }
                    if(j in 1..4){
                        if(lightsFlag[i][j-1] == false){
                            findViewById<TextView>(lights[i][j-1]).setBackgroundColor(Color.RED)
                            lightsFlag[i][j-1] = true
                        }else{
                            findViewById<TextView>(lights[i][j-1]).setBackgroundColor(Color.GRAY)
                            lightsFlag[i][j-1] = false
                        }
                    }
                }
            }
        }

        var temp : Int = moveCount.text.toString().toInt()
        temp += 1
        moveCount.text = temp.toString()

        for(i in 0..4){
            for(j in 0..4){
                if(lightsFlag[i][j] == false){
                   return
                }
            }
        }
        Toast.makeText(this, "Congratulations " + findViewById<TextView>(R.id.enter_name).text.toString() + "! Finished after " + moveCount.text.toString() + " moves.", Toast.LENGTH_LONG).show()
    }

    private fun addName(startButton: View){
        val editNameField = findViewById<EditText>(R.id.enter_name)
        val nameTextView = findViewById<TextView>(R.id.name_view)

        val noOfViews = findViewById<TextView>(R.id.no_of_views)
        val moveCount = findViewById<TextView>(R.id.move_count)

        nameTextView.text = """Hello ${editNameField.text}!"""
        nameTextView.visibility = View.VISIBLE

        editNameField.visibility = View.GONE
        startButton.visibility = View.GONE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(startButton.windowToken, 0)

        moveCount.visibility = View.VISIBLE
        noOfViews.visibility = View.VISIBLE

        light00.visibility = View.VISIBLE
        light01.visibility = View.VISIBLE
        light02.visibility = View.VISIBLE
        light03.visibility = View.VISIBLE
        light04.visibility = View.VISIBLE
        light10.visibility = View.VISIBLE
        light11.visibility = View.VISIBLE
        light12.visibility = View.VISIBLE
        light13.visibility = View.VISIBLE
        light14.visibility = View.VISIBLE
        light20.visibility = View.VISIBLE
        light21.visibility = View.VISIBLE
        light22.visibility = View.VISIBLE
        light23.visibility = View.VISIBLE
        light24.visibility = View.VISIBLE
        light30.visibility = View.VISIBLE
        light31.visibility = View.VISIBLE
        light32.visibility = View.VISIBLE
        light33.visibility = View.VISIBLE
        light34.visibility = View.VISIBLE
        light40.visibility = View.VISIBLE
        light41.visibility = View.VISIBLE
        light42.visibility = View.VISIBLE
        light43.visibility = View.VISIBLE
        light44.visibility = View.VISIBLE

        reset.visibility = View.VISIBLE

        setLights()
    }

    private fun setLights(){
        this.lights[0][0] = (R.id.light00)
        this.lights[0][1] = (R.id.light01)
        this.lights[0][2] = (R.id.light02)
        this.lights[0][3] = (R.id.light03)
        this.lights[0][4] = (R.id.light04)
        this.lights[1][0] = (R.id.light10)
        this.lights[1][1] = (R.id.light11)
        this.lights[1][2] = (R.id.light12)
        this.lights[1][3] = (R.id.light13)
        this.lights[1][4] = (R.id.light14)
        this.lights[2][0] = (R.id.light20)
        this.lights[2][1] = (R.id.light21)
        this.lights[2][2] = (R.id.light22)
        this.lights[2][3] = (R.id.light23)
        this.lights[2][4] = (R.id.light24)
        this.lights[3][0] = (R.id.light30)
        this.lights[3][1] = (R.id.light31)
        this.lights[3][2] = (R.id.light32)
        this.lights[3][3] = (R.id.light33)
        this.lights[3][4] = (R.id.light34)
        this.lights[4][0] = (R.id.light40)
        this.lights[4][1] = (R.id.light41)
        this.lights[4][2] = (R.id.light42)
        this.lights[4][3] = (R.id.light43)
        this.lights[4][4] = (R.id.light44)
    }

    private fun resetBoard(view: View){
        for(i in 0..4){
            for(j in 0..4){
                findViewById<TextView>(lights[i][j]).setBackgroundColor(Color.GRAY)
                lightsFlag[i][j] = false
            }
        }
        val temp = 0
        findViewById<TextView>(R.id.no_of_views).text = temp.toString()
    }

    private fun setListeners(){
        val start = findViewById<Button>(R.id.start)

        start.setOnClickListener{
            addName(it)
        }

        val light1 = findViewById<TextView>(R.id.light00)
        val light2 = findViewById<TextView>(R.id.light01)
        val light3 = findViewById<TextView>(R.id.light02)
        val light4 = findViewById<TextView>(R.id.light03)
        val light5 = findViewById<TextView>(R.id.light04)
        val light6 = findViewById<TextView>(R.id.light10)
        val light7 = findViewById<TextView>(R.id.light11)
        val light8 =  findViewById<TextView>(R.id.light12)
        val light9 = findViewById<TextView>(R.id.light13)
        val light10 = findViewById<TextView>(R.id.light14)
        val light11 = findViewById<TextView>(R.id.light20)
        val light12 = findViewById<TextView>(R.id.light21)
        val light13 = findViewById<TextView>(R.id.light22)
        val light14 = findViewById<TextView>(R.id.light23)
        val light15 = findViewById<TextView>(R.id.light24)
        val light16 = findViewById<TextView>(R.id.light30)
        val light17 = findViewById<TextView>(R.id.light31)
        val light18 = findViewById<TextView>(R.id.light32)
        val light19 = findViewById<TextView>(R.id.light33)
        val light20 = findViewById<TextView>(R.id.light34)
        val light21 = findViewById<TextView>(R.id.light40)
        val light22 = findViewById<TextView>(R.id.light41)
        val light23 = findViewById<TextView>(R.id.light42)
        val light24 = findViewById<TextView>(R.id.light43)
        val light25 = findViewById<TextView>(R.id.light44)


        val clickableViews: List<TextView> =
            listOf(light1, light2, light3, light4, light5,
                light6, light7, light8, light9, light10,
                light11, light12, light13, light14, light15,
                light16, light17, light18, light19, light20,
                light21, light22, light23, light24, light25)

        for(item in clickableViews){
            item.setOnClickListener{pressLight(it)}
        }

        val reset = findViewById<Button>(R.id.reset)

        reset.setOnClickListener{
            resetBoard(it)
        }

    }
}
package com.example.myfirstandroidapp

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nameInput = findViewById<EditText>(R.id.name)
        val ageInput = findViewById<EditText>(R.id.age)

        val goButton = findViewById<Button>(R.id.go)
        goButton.setOnClickListener(View.OnClickListener {
            var ageS=ageInput.text.toString().toInt()
            var suma = 0;
            var res=0;
            if(nameInput.text.isEmpty() || ageInput.text.isEmpty())
                Toast.makeText(this,"Please type something...",Toast.LENGTH_SHORT).show()
            else if(ageS <10 ) {
                res = ageS * 7
                while(res > 0){
                    suma += res%10;
                    res /= 10;
                }
            }else if(ageS >= 10){
                while(ageS >0){
                    suma += ageS%10;
                    ageS /= 10;
                }
                ageS=suma;
                if(ageS >=10){
                    suma = 0;
                    while(ageS >0) {
                        suma +=  ageS%10;
                        ageS /= 10;
                    }
                }
            }
            Toast.makeText(this, "Hey "+ nameInput.text + " Your lucky number is: " + suma, Toast.LENGTH_SHORT).show()
        })
    }
}
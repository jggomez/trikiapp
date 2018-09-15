package co.devhack.trikiapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var numUser: Int = 1
    private var matrixPlayer = Array(3, { IntArray(3) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener(ClickButton())
        btn2.setOnClickListener(ClickButton())
        btn3.setOnClickListener(ClickButton())
        btn4.setOnClickListener(ClickButton())
        btn5.setOnClickListener(ClickButton())
        btn6.setOnClickListener(ClickButton())
        btn7.setOnClickListener(ClickButton())
        btn8.setOnClickListener(ClickButton())
        btn9.setOnClickListener(ClickButton())

    }

    protected fun fillMatrix(idButton: Int, numUsuario: Int) {

        if (idButton == btn1.id) {
            matrixPlayer[0][0] = numUsuario
        }

        if (idButton == btn2.id) {
            matrixPlayer[0][1] = numUsuario
        }

        if (idButton == btn3.id) {
            matrixPlayer[0][2] = numUsuario
        }

        if (idButton == btn4.id) {
            matrixPlayer[1][0] = numUsuario
        }

        if (idButton == btn5.id) {
            matrixPlayer[1][1] = numUsuario
        }

        if (idButton == btn6.id) {
            matrixPlayer[1][2] = numUsuario
        }

        if (idButton == btn7.id) {
            matrixPlayer[2][0] = numUsuario
        }

        if (idButton == btn8.id) {
            matrixPlayer[2][1] = numUsuario
        }

        if (idButton == btn9.id) {
            matrixPlayer[2][2] = numUsuario
        }

    }

    private fun validateRows(){

        var cont = 0

        for(colArray in matrixPlayer){
            for (rowValue in colArray){
                if(rowValue == 1){
                    cont++
                }
            }
        }

        if(cont == 3){
            // gano el jugador 1
            return
        }

        for(colArray in matrixPlayer){
            for (rowValue in colArray){
                if(rowValue == 2){
                    cont++
                }
            }
        }

        if(cont == 3){
            // gano el jugador 2
        }



    }

    inner class ClickButton : View.OnClickListener {

        override fun onClick(v: View?) {
            val button = v as Button

            if (numUser == 1) {
                button.text = "O"
                numUser = 2
            } else if (numUser == 2) {
                button.text = "X"
                numUser = 1
            }

            button.isEnabled = false

            fillMatrix(button.id, numUser)

        }

    }


}

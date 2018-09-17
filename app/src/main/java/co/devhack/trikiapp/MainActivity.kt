package co.devhack.trikiapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var numUser: Int = 1
    private var matrixGame = Array(3, { IntArray(3) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener { click(it) }
        btn2.setOnClickListener { click(it) }
        btn3.setOnClickListener { click(it) }
        btn4.setOnClickListener { click(it) }
        btn5.setOnClickListener { click(it) }
        btn6.setOnClickListener { click(it) }
        btn7.setOnClickListener { click(it) }
        btn8.setOnClickListener { click(it) }
        btn9.setOnClickListener { click(it) }
        btnResetGame.setOnClickListener { resetGame() }

        resetGame();

    }

    private val click: (View) -> Unit = {

        val button = it as Button

        fillMatrix(button.id, numUser)
        validateWinner(numUser)

        if (numUser == 1) {
            button.text = "O"
            numUser = 2
            button.setTextColor(getColor(R.color.colorWhite))
        } else if (numUser == 2) {
            button.text = "X"
            button.setTextColor(getColor(R.color.colorAccent))
            numUser = 1
        }

        button.disable()
    }

    private fun fillMatrix(idButton: Int, numUser: Int) {

        if (idButton == btn1.id) {
            matrixGame[0][0] = numUser
        }

        if (idButton == btn2.id) {
            matrixGame[0][1] = numUser
        }

        if (idButton == btn3.id) {
            matrixGame[0][2] = numUser
        }

        if (idButton == btn4.id) {
            matrixGame[1][0] = numUser
        }

        if (idButton == btn5.id) {
            matrixGame[1][1] = numUser
        }

        if (idButton == btn6.id) {
            matrixGame[1][2] = numUser
        }

        if (idButton == btn7.id) {
            matrixGame[2][0] = numUser
        }

        if (idButton == btn8.id) {
            matrixGame[2][1] = numUser
        }

        if (idButton == btn9.id) {
            matrixGame[2][2] = numUser
        }

    }

    private fun validateRows(numUser: Int): Boolean {

        var win = false

        for (col in 0 until matrixGame.size) {
            for (row in 0 until matrixGame.size) {
                if (matrixGame[col][row] != numUser) {
                    win = false
                    break
                } else {
                    win = true
                }
            }

            if (win) {
                break
            }
        }

        return win

    }

    private fun validateColumns(numUser: Int): Boolean {

        var won = false

        for (row in 0 until matrixGame.size) {
            for (col in 0 until matrixGame.size) {
                if (matrixGame[col][row] == numUser) {
                    won = true
                } else {
                    won = false
                    break
                }
            }

            if (won) {
                break
            }
        }

        return won

    }

    private fun validateDiagonals(numUser: Int): Boolean {

        var win = false

        for (row in 0 until matrixGame.size) {
            for (col in 0 until matrixGame.size) {
                if (row == col) {
                    win = matrixGame[col][row] == numUser
                    break
                }
            }

            if (win == false) {
                break
            }
        }

        return win

    }

    private fun validateDiagonalsInverse(numUser: Int): Boolean {

        var win = false
        var col = 2

        for (row in 0 until matrixGame.size) {
            win = matrixGame[col][row] == numUser
            if (win == false) {
                break
            }
            col--
        }

        return win

    }

    private fun validateWinner(numUser: Int) {

        var win: Boolean = validateRows(numUser)

        if (win) {
            lblWin.text = winMsg(numUser)
            return
        }

        win = validateColumns(numUser)

        if (win) {
            lblWin.text = winMsg(numUser)
        }

        win = validateDiagonals(numUser)

        if (win) {
            lblWin.text = winMsg(numUser)
        }

        win = validateDiagonalsInverse(numUser)

        if (win) {
            lblWin.text = winMsg(numUser)
        }

    }

    private val winMsg: (Int) -> String = { "The Player => $it  WIN !!!!" }

    private fun resetGame() {

        for (row in 0 until matrixGame.size) {
            for (col in 0 until matrixGame.size) {
                matrixGame[col][row] = 0
            }
        }

        btn1.enable()
        btn2.enable()
        btn3.enable()
        btn4.enable()
        btn5.enable()
        btn6.enable()
        btn7.enable()
        btn8.enable()
        btn9.enable()

        btn1.clearText()
        btn2.clearText()
        btn3.clearText()
        btn4.clearText()
        btn5.clearText()
        btn6.clearText()
        btn7.clearText()
        btn8.clearText()
        btn9.clearText()

        lblWin.text = ""

        numUser = 1
    }

    fun Button.disable() {
        this.isEnabled = false
    }

    fun Button.enable() {
        this.isEnabled = true
    }

    fun Button.clearText() {
        this.text = ""
    }


}

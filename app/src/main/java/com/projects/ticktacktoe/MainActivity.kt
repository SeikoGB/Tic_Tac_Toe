package com.projects.ticktacktoe


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var matrix = Array(3) { IntArray(3) { -1 } }
    var active = true
    var playerX:String="Player X"
    var playerO:String="PLayer O"
    lateinit var img9:ImageView
    lateinit var img1:ImageView
    lateinit var img2:ImageView
    lateinit var img3:ImageView
    lateinit var img4:ImageView
    lateinit var img5:ImageView
    lateinit var img6:ImageView
    lateinit var img7:ImageView
    lateinit var img8:ImageView
    lateinit var restart:Button
    lateinit var score_x:TextView
    var scoreX:Int = 0
    lateinit var score_o:TextView
    var scoreO:Int=0
    lateinit var player:TextView
    lateinit var winner:TextView
    var click:Int=0


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        UI()
        player.text = "Player X"

        img9.setOnClickListener(this)
        img1.setOnClickListener(this)
        img2.setOnClickListener(this)
        img3.setOnClickListener(this)
        img4.setOnClickListener(this)
        img5.setOnClickListener(this)
        img6.setOnClickListener(this)
        img7.setOnClickListener(this)
        img8.setOnClickListener(this)
        restart.setOnClickListener {
            restart()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(p0: View?) {
        val img = findViewById<ImageView>(p0!!.id)
        var t = img.tag.toString().toInt()
        var col: Int = t / 3
        var row: Int = t % 3
        if (matrix[col][row] == -1) {
            if (active) {
                img.setImageResource(R.drawable.x)
                active = false
                matrix[col][row] = 1
                player.text = playerO
                click++
                isWinner(1)
                tie()
            } else {
                img.setImageResource(R.drawable.o)
                active = true
                matrix[col][row] = 0
                player.text = playerX
                click++
                isWinner(0)
                tie()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun isWinner(a: Int) {
        var count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (matrix[i][j] == a) {
                    count++
                }
            }
            if (count == 3) {
                finishGame(a)
                return
            }
            count = 0
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (matrix[j][i] == a) {
                    count++
                }
            }
            if (count == 3) {
                finishGame(a)
                return
            }
            count = 0
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (i == j) {
                    if (matrix[j][i] == a) {
                        count++
                    }
                }
            }
        }
        if (count == 3) {
            finishGame(a)
            return
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (i + j == 2) {
                    if (matrix[j][i] == a) {
                        count++
                    }
                }
            }
        }
        if (count == 3) {
            finishGame(a)
            return
        }
    }

    fun finishGame(iswinner: Int) {
        var score=0f
        restart.visibility = View.VISIBLE
        if(iswinner==1){
        winner.text = "Winner is "+playerX
        }
        else{
            winner.text="Winner is "+playerO
        }
        winner.visibility=View.VISIBLE
        img9.isEnabled = false
        img1.isEnabled = false
        img2.isEnabled = false
        img3.isEnabled = false
        img4.isEnabled = false
        img5.isEnabled = false
        img6.isEnabled = false
        img7.isEnabled = false
        img8.isEnabled = false
        if (iswinner==1){
            scoreX++
            score_x.text=scoreX.toString()
        }else{
            scoreO++
            score_o.text=scoreO.toString()
        }

        for(i in 0..matrix.size-1){
            for (j in 0..matrix[i].size-1){
                if (matrix[i][j]==-1){
                    matrix[i][j]==1
                }
            }
        }
        click=0
        }
    fun tie(){
        if (click!=9){
            return
        }else{
         restart.visibility=View.VISIBLE
            winner.visibility=View.VISIBLE
            winner.text="TIE"
            click=0
        }

    }


    @SuppressLint("SetTextI18n")
    fun restart() {
        matrix = Array(3) { IntArray(3) { -1 } }
        active = true

        player.text = "Player X"
        restart.visibility = View.INVISIBLE
        winner.text = ""

        img9.setImageDrawable(null)
        img1.setImageDrawable(null)
        img2.setImageDrawable(null)
        img3.setImageDrawable(null)
        img4.setImageDrawable(null)
        img5.setImageDrawable(null)
        img6.setImageDrawable(null)
        img7.setImageDrawable(null)
        img8.setImageDrawable(null)

        img9.isEnabled = true
        img1.isEnabled = true
        img2.isEnabled = true
        img3.isEnabled = true
        img4.isEnabled = true
        img5.isEnabled = true
        img6.isEnabled = true
        img7.isEnabled = true
        img8.isEnabled = true

    }
    private fun UI(){
       img9=findViewById(R.id.img9)
       img1=findViewById(R.id.img1)
        img2=findViewById(R.id.img2)
        img3=findViewById(R.id.img3)
        img4=findViewById(R.id.img4)
        img5=findViewById(R.id.img5)
        img6=findViewById(R.id.img6)
        img7=findViewById(R.id.img7)
        img8=findViewById(R.id.img8)
        score_x=findViewById(R.id.score_x)
        score_o=findViewById(R.id.score_o)
        restart=findViewById(R.id.restart)
        player=findViewById(R.id.player)
        winner=findViewById(R.id.winner)

    }
}
package at.mad.example.taschenrechner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers Clicklistener
        tvKoma.setOnClickListener{ appendOnExp(".",true)}
        tvDoublezero.setOnClickListener{ appendOnExp("00",true)}
        tvZero.setOnClickListener{ appendOnExp("0",true)}
        tvOne.setOnClickListener{ appendOnExp("1",true)}
        tvTwo.setOnClickListener{ appendOnExp("2",true)}
        tvThree.setOnClickListener{ appendOnExp("3",true)}
        tvFour.setOnClickListener{ appendOnExp("4",true)}
        tvFive.setOnClickListener{ appendOnExp("5",true)}
        tvSix.setOnClickListener{ appendOnExp("6",true)}
        tvSeven.setOnClickListener{ appendOnExp("7",true)}
        tvEight.setOnClickListener{ appendOnExp("8",true)}
        tvNine.setOnClickListener{ appendOnExp("9",true)}


        //Operators Clicklistener

        tvPlus.setOnClickListener {appendOnExp("+", false)}
        tvMinus.setOnClickListener {appendOnExp("-", false)}
        tvDividid.setOnClickListener {appendOnExp("/", false)}
        tvMulti.setOnClickListener {appendOnExp("*", false)}
        tvPercent.setOnClickListener {appendOnExp("%", false)}

        tvClear.setOnClickListener{
            tvExp.text =""
            tvRes.text ="0"
        }

        tvBackspace.setOnClickListener{
            val string = tvExp.text.toString()
            if(string.isNotEmpty()){
                tvExp.text= string.substring(0,string.length-1)
            }
            tvRes.text=""
        }

        tvEqual.setOnClickListener{
            try{
                val expression = ExpressionBuilder(tvExp.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    tvRes.text = longResult.toString()
                else
                    tvRes.text = result.toString()




        }catch(e:Exception){
            Log.d("Exeption","mesaage : " + e.message)
            }
        }
    }




    fun appendOnExp(string: String,  canClear :Boolean) {
        if(canClear) {
            tvRes.text = ""
            tvExp.append(string)
        }else{
            tvExp.append(tvRes.text)
            tvExp.append(string)
            tvRes.text = ""
        }



    }



}

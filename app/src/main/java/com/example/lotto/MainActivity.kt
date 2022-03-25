package com.example.lotto

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val random = Random(45) // 랜덤값을 사용할 수 있도록 선언
    private val numbers = arrayListOf<Int>() // 번호를 저장할 배열 생성
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1 = findViewById<Button>(R.id.lottoNum1)
        val num2 = findViewById<Button>(R.id.lottoNum2)
        val num3 = findViewById<Button>(R.id.lottoNum3)
        val num4 = findViewById<Button>(R.id.lottoNum4)
        val num5 = findViewById<Button>(R.id.lottoNum5)
        val num6 = findViewById<Button>(R.id.lottoNum6)

        findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {
            numbers.clear() // 모든 숫자 삭제하고 시작

            setLottoNum(num1)
            setLottoNum(num2)
            setLottoNum(num3)
            setLottoNum(num4)
            setLottoNum(num5)
            setLottoNum(num6)
        }
    }
    private fun setLottoNum(lottoNum: Button) {
        var num = 0
        while (true) {
            num = random.nextInt(45) + 1 // 0~44이기 때문에 1~45로 변경
            if ( !numbers.contains(num) ) { // 만약 이전에 나온 번호와 겹치지 않는다면
                numbers.add(num) // 번호 추가
                break
            }
        }

        lottoNum.text = "${num}"

        if ( num <= 10 ) {
            lottoNum.backgroundTintList = ColorStateList.valueOf(Color.rgb(255,194,0))
        } else if (num <= 20) {
            lottoNum.backgroundTintList = ColorStateList.valueOf(Color.rgb(0,0,255))
        } else if (num <= 30) {
            lottoNum.backgroundTintList = ColorStateList.valueOf(Color.rgb(245,33,34))
        } else if (num <= 40 ) {
            lottoNum.backgroundTintList = ColorStateList.valueOf(Color.rgb(128,128,128))
        } else {
            lottoNum.backgroundTintList = ColorStateList.valueOf(Color.rgb(129,193,71))
        }
    }
}
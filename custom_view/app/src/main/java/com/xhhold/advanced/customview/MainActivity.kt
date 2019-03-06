package com.xhhold.advanced.customview

import android.animation.ObjectAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val objectAnimator = ObjectAnimator.ofFloat(textView, "translationX", 0f, 300f)
        objectAnimator.duration = 3000
        objectAnimator.start()
    }
}

package com.thomasphillips3.widgetexploration

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import kotlinx.android.synthetic.main.exploration_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exploration_layout)

        checkBoxTransparency.setOnCheckedChangeListener {
                _, isChecked ->
            if(isChecked) {
                imageView.alpha = .1f
            } else {
                imageView.alpha = 1f
            }
        }

        checkBoxTint.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                imageView.setColorFilter(Color.argb(150, 255, 0, 0))
            } else {
                imageView.setColorFilter(Color.argb(0, 0, 0, 0))
            }
        }

        checkBoxResize.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                imageView.scaleX = 2f
                imageView.scaleY = 2f
            } else {
                imageView.scaleX = 1f
                imageView.scaleY = 1f
            }
        }

        radioGroup.clearCheck()
        radioGroup.setOnCheckedChangeListener {
            group, checkedId ->
            val rb = group.findViewById<View>(checkedId) as RadioButton

            when (rb.id) {
                R.id.radioButtonBeijing -> textClock.timeZone = "CST6CDT"
                R.id.radioButtonEuropeanEmpire -> textClock.timeZone = "Europe/Brussels"
                R.id.radioButtonLondon -> textClock.timeZone = "Europe/London"
                R.id.radioButtonNewYork -> textClock.timeZone = "America/New_York"
            }
        }

        button.setOnClickListener {
            textView.text = editText.text
        }

        switch1.setOnCheckedChangeListener {
            buttonView, isChecked ->
            if (isChecked) {
                textView.visibility = View.VISIBLE
            } else {
                textView.visibility = View.INVISIBLE
            }
        }
    }
}

package br.com.deyvidfernandes.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import br.com.deyvidfernandes.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            val clickableViews: List<View> = listOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText, constraintLayout, btRed, btGreen, btYellow)

            for (item in clickableViews){
                item.setOnClickListener { makeColored(it) }
            }
        }
    }

    private fun makeColored(it: View?) {

        when(it?.id){
            //Boxes using Color class colors for background
            R.id.box_one_text -> it?.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text-> it?.setBackgroundColor(Color.GRAY)

            //Boxes using Android color resources for background
            R.id.box_three_text-> it?.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text-> it?.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text-> it?.setBackgroundResource(android.R.color.holo_blue_light)

            // Boxes using custom colors for background
            R.id.bt_red -> binding.boxThreeText.setBackgroundResource(R.color.red)
            R.id.bt_yellow -> binding.boxFourText.setBackgroundResource(R.color.yellow)
            R.id.bt_green -> binding.boxFiveText.setBackgroundResource(R.color.green)

            else -> it?.setBackgroundColor(Color.LTGRAY)
        }

    }
}
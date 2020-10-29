package com.example.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager2.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = 4

            override fun createFragment(position: Int) = when (position) {
                0 -> ScaleFragment()
                1 -> RotateFragment()
                2 -> FindFragment()
                else -> TranslateFragment()
            }
        }
        TabLayoutMediator(tablayout, viewpager2) { tab, position ->
            when (position) {
                0 -> tab.text = "缩放"
                1 -> tab.text = "旋转"
                2 -> tab.text = "查找"
                else -> tab.text = "移动"
            }
        }.attach()
    }
}
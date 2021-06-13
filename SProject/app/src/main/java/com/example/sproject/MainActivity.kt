package com.example.sproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_one.*

class MainActivity : AppCompatActivity() {
    private val fragmentOne = FragmentOne()
    private val fragmentTwo = FragmentTwo()
    private val fragmentThree = FragmentThree()
    private val fragmentFour = FragmentFour()

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_pager.adapter = MainPagerAdapter(supportFragmentManager)

        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                bottom_navigation.menu.getItem(position).isChecked = true
            }
        })

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                // itemId에 따라 viewPager 바뀜
                R.id.page_1 -> view_pager.currentItem = 0
                R.id.page_2 -> view_pager.currentItem = 1
                R.id.page_3 -> view_pager.currentItem = 2
                R.id.page_4 -> view_pager.currentItem = 3
            }
            true
        }

    }

}

// Bottom navigation 용 Adapter
class MainPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FragmentOne()
            1 -> FragmentTwo()
            2 -> FragmentThree()
            3 -> FragmentFour()
            else -> FragmentOne()
        }
    }

    override fun getCount(): Int {
        return 4
    }
}
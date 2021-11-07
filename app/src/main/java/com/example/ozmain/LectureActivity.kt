package com.example.ozmain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.ozmain.Adapter.FragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.*
import kotlinx.android.synthetic.main.activity_lecture.*
import kotlinx.android.synthetic.main.custom_tab.view.*

class LectureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecture)

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        list_viewpager.adapter = fragmentAdapter //Adapter와 연결
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("COFFEE")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("LATTE")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("ADE")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("SMOTHIE")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("TEA")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("METERIAL")))

// 상단 탭 슬라이딩 시 탭 이동
        list_viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

// 상단 탭 선택 시 fragment 나오도록하기
        
        tab_layout.addOnTabSelectedListener(object : OnTabSelectedListener { // 탭 클릭시 해당 페이지로 이동
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                if (p0 != null) {
                    list_viewpager.currentItem = p0!!.position
                }
            }

        })
    }

    //탭 레이아웃 안에 customTab을 넣기

    private fun createTabView(tabName: String): View {

        val tabView = LayoutInflater.from(baseContext).inflate(R.layout.custom_tab, null)

        tabView.txt_name.text = tabName

        return tabView
    }
}
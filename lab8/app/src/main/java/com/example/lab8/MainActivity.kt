package com.example.lab8

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class MainActivity : AppCompatActivity(),ChangeFragments {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun toWorkFragmentTransaction() {
        supportFragmentManager.commit{
            setReorderingAllowed(true)
            replace<WorkFragment>(R.id.fragmentContainerView)
        }
    }

    override fun toListFragmentTransaction() {
        supportFragmentManager.commit{
            setReorderingAllowed(true)
            replace<ListFragment>(R.id.fragmentContainerView)
        }
    }
}
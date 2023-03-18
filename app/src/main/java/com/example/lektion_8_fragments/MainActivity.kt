package com.example.lektion_8_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import com.example.lektion_8_fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Initialize
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding Setup
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ID's
        val btnCreateFragment = binding.btnCreateFragment
        val fcvSpawnFragment = binding.fcvSpawnFragment

        btnCreateFragment.setOnClickListener() {
            createFragment(fcvSpawnFragment)
        }

    }

    private fun createFragment(fragmentContainer: FragmentContainerView) {

        if (supportFragmentManager.findFragmentByTag("MyTag") == null) {
            println("Fragment does NOT exist - adding new fragment")

            supportFragmentManager.commit {
                setReorderingAllowed(true)                  // Compatibility
                add(fragmentContainer.id, FirstFragment(), "MyTag")  // Creation
            }
        } else { // This is optional - Works without it too!
            println("Fragment Exists - Preparing to remove")

            supportFragmentManager.beginTransaction().remove(
                supportFragmentManager.findFragmentByTag("MyTag")!!
            ).commit()
        }

    }

}
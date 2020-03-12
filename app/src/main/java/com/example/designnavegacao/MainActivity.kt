package com.example.designnavegacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected (item: MenuItem): Boolean {
        when (item.itemId){
            R.id.home_item ->{
                nav_fragment.findNavController().navigate(R.id.homeFragment)
            }
            R.id.info_item -> {
                Toast.makeText( this ,
                    R.string.informacao,
                    Toast.LENGTH_SHORT).show()
            }
            R.id.nav_item ->{
                nav_fragment.findNavController().navigate(R.id.dateFragment)
            }
        }
        return true
    }
}

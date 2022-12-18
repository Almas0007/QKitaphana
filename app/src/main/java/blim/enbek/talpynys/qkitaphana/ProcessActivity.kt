package blim.enbek.talpynys.qkitaphana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import blim.enbek.talpynys.qkitaphana.databinding.ActivityProcessBinding
import blim.enbek.talpynys.qkitaphana.fragment.CRUDFragment
import blim.enbek.talpynys.qkitaphana.fragment.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProcessActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProcessBinding
    private lateinit var bottomNavV:BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProcessBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFragment(HomeFragment.newInstance())
        setupClickListener()
    }

    private fun setupClickListener() {
        binding.processBottomNavigationView.setOnItemSelectedListener {

            val fragment = when (it.itemId) {
                R.id.nvPageHome -> {
                    Toast.makeText(this,"HOme",Toast.LENGTH_SHORT).show()
                    HomeFragment.newInstance()
                }
                R.id.nvPageCalendar -> {
                    HomeFragment.newInstance()
                }
                R.id.nvPageSearch -> {
                    Toast.makeText(this,"Search",Toast.LENGTH_SHORT).show()
                    CRUDFragment.newInstance()
                }
                R.id.nvPageChat -> {
                    HomeFragment.newInstance()
                }
                R.id.nvPageProfile -> {
                    HomeFragment.newInstance()
                }

                else -> {
                    HomeFragment.newInstance()
                }
            }
            loadFragment(fragment)
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.processPlaceFragment, fragment)
            .commit()
    }



}
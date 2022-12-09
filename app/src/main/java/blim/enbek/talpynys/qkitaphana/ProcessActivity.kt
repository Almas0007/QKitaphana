package blim.enbek.talpynys.qkitaphana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import blim.enbek.talpynys.qkitaphana.R
import blim.enbek.talpynys.qkitaphana.databinding.ActivityProcessBinding
import blim.enbek.talpynys.qkitaphana.fragment.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProcessActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProcessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProcessBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bottomNav = binding.processBottomNavigationView as BottomNavigationView

        startFragment()
    }

    fun startFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.processPlaceFragment, HomeFragment.newInstance())
            .addToBackStack("")
            .commit()
    }
}
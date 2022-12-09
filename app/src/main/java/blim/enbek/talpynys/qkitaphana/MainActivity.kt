package blim.enbek.talpynys.qkitaphana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.FragmentManager
import blim.enbek.talpynys.qkitaphana.databinding.ActivityMainBinding
import blim.enbek.talpynys.qkitaphana.databinding.FragmentSplashBinding
import blim.enbek.talpynys.qkitaphana.fragment.FirstWelcomeFragment
import blim.enbek.talpynys.qkitaphana.fragment.SplashFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        splash()
        nextFragment()
    }

    fun splash() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainActivity, SplashFragment.newInstance()).commit()
    }

    fun nextFragment() {
        Handler(Looper.getMainLooper()).postDelayed({
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainActivity, FirstWelcomeFragment.newInstance()).commit()
        },3000)
    }

}
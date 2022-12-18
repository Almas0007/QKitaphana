package blim.enbek.talpynys.qkitaphana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.FragmentManager
import blim.enbek.talpynys.qkitaphana.databinding.ActivityMainBinding
import blim.enbek.talpynys.qkitaphana.databinding.FragmentSplashBinding
import blim.enbek.talpynys.qkitaphana.fragment.CRUDFragment
import blim.enbek.talpynys.qkitaphana.fragment.FirstWelcomeFragment
import blim.enbek.talpynys.qkitaphana.fragment.SplashFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        splash()
        pokashto()
    }

    fun splash() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainActivity, SplashFragment.newInstance()).commit()
    }


    fun pokashto() {
        val intent = Intent(this,ProcessActivity::class.java)
        startActivity(intent)
    }

    fun nextFragment() {
        Handler(Looper.getMainLooper()).postDelayed({
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainActivity, FirstWelcomeFragment.newInstance()).commit()
        },3000)
    }

}
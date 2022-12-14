package blim.enbek.talpynys.qkitaphana.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import blim.enbek.talpynys.qkitaphana.R
import blim.enbek.talpynys.qkitaphana.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    companion object {

        @JvmStatic
        fun newInstance() =
            SplashFragment()
    }

    lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root

 }


}
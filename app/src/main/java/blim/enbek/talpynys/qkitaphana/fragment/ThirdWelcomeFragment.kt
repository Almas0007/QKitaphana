package blim.enbek.talpynys.qkitaphana.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import blim.enbek.talpynys.qkitaphana.ProcessActivity
import blim.enbek.talpynys.qkitaphana.databinding.FragmentThirdWelcomeBinding

class ThirdWelcomeFragment : Fragment() {
    companion object {

        @JvmStatic
        fun newInstance() =
            ThirdWelcomeFragment()
    }
    lateinit var binding: FragmentThirdWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdWelcomeBinding.inflate(inflater, container, false)
        return binding.root
        }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.welcomeButton3.setOnClickListener { newActivity() }
    }

    fun newActivity(){
        val intent = Intent(context, ProcessActivity::class.java)
        startActivity(intent)
    }

}
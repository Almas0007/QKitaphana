package blim.enbek.talpynys.qkitaphana.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import blim.enbek.talpynys.qkitaphana.R
import blim.enbek.talpynys.qkitaphana.databinding.FragmentSecondWelcomeBinding

class SecondWelcomeFragment : Fragment() {
    companion object {

        @JvmStatic
        fun newInstance() =
            SecondWelcomeFragment()
    }
    lateinit var binding: FragmentSecondWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondWelcomeBinding.inflate(inflater, container, false)
        return binding.root
         }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.welcomeButton2.setOnClickListener { nextWelcome() }
    }

    fun nextWelcome() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.mainActivity, ThirdWelcomeFragment.newInstance()).addToBackStack("").commit()
    }
}
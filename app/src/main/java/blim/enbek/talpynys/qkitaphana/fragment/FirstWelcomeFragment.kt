package blim.enbek.talpynys.qkitaphana.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import blim.enbek.talpynys.qkitaphana.R
import blim.enbek.talpynys.qkitaphana.databinding.FragmentFirstWelcomeBinding

class FirstWelcomeFragment : Fragment() {
    companion object {

        @JvmStatic
        fun newInstance() =
            FirstWelcomeFragment()
    }

    lateinit var binding: FragmentFirstWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.welcomeButton1.setOnClickListener { nextWelcome() }
    }

    fun nextWelcome() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.mainActivity, SecondWelcomeFragment.newInstance()).addToBackStack("").commit()
    }

}
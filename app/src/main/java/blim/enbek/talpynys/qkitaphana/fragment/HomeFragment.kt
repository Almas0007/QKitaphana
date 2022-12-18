package blim.enbek.talpynys.qkitaphana.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import blim.enbek.talpynys.qkitaphana.LibraryRCAdapter
import blim.enbek.talpynys.qkitaphana.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), LibraryRCAdapter.OnClick  {
    companion object {
        fun newInstance() = HomeFragment()
    }

    lateinit var binding: FragmentHomeBinding
    lateinit var mAdapter: LibraryRCAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }



    override fun onItemEdit(position: Int) {
    }

    override fun onItemDelete(position: Int) {
    }


}
package blim.enbek.talpynys.qkitaphana.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import blim.enbek.talpynys.qkitaphana.DataLibraryClass
import blim.enbek.talpynys.qkitaphana.LibraryRCAdapter
import blim.enbek.talpynys.qkitaphana.LibraryViewModel
import blim.enbek.talpynys.qkitaphana.R
import blim.enbek.talpynys.qkitaphana.databinding.FragmentCRUDBinding

class CRUDFragment : Fragment(), LibraryRCAdapter.OnClick {

    companion object {
        @JvmStatic
        fun newInstance() = CRUDFragment()
    }

    var dataSet = ArrayList<DataLibraryClass>()
    lateinit var binding: FragmentCRUDBinding
    lateinit var mAdapter: LibraryRCAdapter
    private val vm: LibraryViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCRUDBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        createRC()

        binding.buttonTextAddItem.setOnClickListener{
            addItemFragment(-1)

        }


    }


    private fun createRC(){

        mAdapter = LibraryRCAdapter(this)
        vm.liveDataList.observe(viewLifecycleOwner) {
            Log.d("TestLog", "CRUDFragment: createRC() - it->$it")
            dataSet = it
            mAdapter.submitList(it)
            mAdapter.notifyItemChanged(it.lastIndex)


        }
        binding.placeRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.placeRecyclerView.adapter = mAdapter



    }

    private fun addItemFragment(key:Int){
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.processPlaceFragment,ItemFragment.newInstance(key))
            .addToBackStack("")
            .commit()

        Log.d("TestLog","In Item - ($key) - ")
    }

    override fun onItemEdit(position: Int) {
        addItemFragment(position)

        Log.d("TestLog","CRUDFragment:  onItemEdit($position: Int) - ")

    }

    override fun onItemDelete(position: Int) {
        dataSet.removeAt(position)
        mAdapter.notifyItemRemoved(position)
    }



}
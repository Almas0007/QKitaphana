package blim.enbek.talpynys.qkitaphana.fragment

import android.annotation.SuppressLint
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
    lateinit var mAdapter: LibraryRCAdapter
    lateinit var binding: FragmentCRUDBinding
    private val vm: LibraryViewModel by activityViewModels()


    var isEditar = false
    var posicion = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCRUDBinding.inflate(inflater, container, false)
        return binding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

            createRc()
        binding.buttonTextAddItem.setOnClickListener{
            addItemFragment()
        }
    }

    fun observeData() {
        vm.liveItemData.observe(viewLifecycleOwner){
            Log.d("MyTest","item: $it")
            dataSet.add(it)
            Log.d("MyTest","Dataset:"+dataSet.toString())
            mAdapter.submitList(dataSet)
            mAdapter.notifyDataSetChanged()
        }

    }
    fun createRc(){

        mAdapter = LibraryRCAdapter(this)
        binding.placeRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.placeRecyclerView.adapter = mAdapter
        observeData()

    }
    fun addItemFragment(){
        parentFragmentManager.beginTransaction().add(R.id.processPlaceFragment,ItemFragment.newInstance()).commit()
    }

    override fun onItemEdit(position: Int) {
        Log.d("MyTest","Position: $position")
    }

    override fun onItemDelete(position: Int) {

    }



}
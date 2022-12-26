package blim.enbek.talpynys.qkitaphana.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import blim.enbek.talpynys.qkitaphana.DataLibraryClass
import blim.enbek.talpynys.qkitaphana.LibraryViewModel
import blim.enbek.talpynys.qkitaphana.R
import blim.enbek.talpynys.qkitaphana.databinding.FragmentItemBinding
import kotlin.collections.ArrayList

class ItemFragment(var key: Int) : Fragment() {


    companion object {
        @JvmStatic
        fun  newInstance(key: Int) = ItemFragment(key)

    }

    lateinit var binding: FragmentItemBinding
    private var libraryList = ArrayList<DataLibraryClass>()
    private val vm: LibraryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observe()

        binding.buttonDelete.setOnClickListener {
            libraryList.removeAt(key)
            vm.liveDataList.postValue(libraryList)
            parentFragmentManager.beginTransaction().replace(R.id.processPlaceFragment,CRUDFragment.newInstance()).commit()

        }
        binding.buttonEdit.setOnClickListener {
            all(key)
            vm.liveDataList.postValue(libraryList)
            parentFragmentManager.beginTransaction().replace(R.id.processPlaceFragment,CRUDFragment.newInstance()).commit()
        }

    }

    private fun observe(){

        vm.liveDataList.observe(viewLifecycleOwner){
            Log.d("TestLog","ItemFragment: observe() - Done  - it-> ($it)")
            libraryList=it
            itemPositionShowing(key,it)
        }

    }

    private fun all(key: Int){
        Log.d("TestLog","ItemFragment: Return - ($key) - ")
        if(key == -1){

            item()


        }
        else{

            itemPositionEditing(key)
        }
    }

    fun item(){
        Log.d("TestLog","ItemFragment: item()-1 - Done")
        val item = DataLibraryClass(
            1,
            binding.editTextNameLibrary.text.toString(),
            binding.editTextLibraryAddress.text.toString(),
            binding.editTextLibraryRating.text.toString()
        )

        libraryList.add(item)
        Log.d("TestLog","ItemFragment: item()-2 - $libraryList")
    }
    private fun itemPositionShowing(position: Int, arrayList: ArrayList<DataLibraryClass>){


        if (position == -1){
            Log.d("TestLog","ItemFragment: itemPositionShowing()-1 - Done")
        }
        else {
            Log.d("TestLog","ItemFragment: itemPositionShowing()-2 - $libraryList")
            binding.editTextNameLibrary.setText(arrayList[position].nameLibrary)
            binding.editTextLibraryAddress.setText(arrayList[position].addressLibrary)
            binding.editTextLibraryRating.setText(arrayList[position].ratingLibrary)
        }
    }
    private fun itemPositionEditing(position:Int){

        Log.d("TestLog","ItemFragment: itemPosition() - Done")

        val item = DataLibraryClass(
            1,
            binding.editTextNameLibrary.text.toString(),
            binding.editTextLibraryAddress.text.toString(),
            binding.editTextLibraryRating.text.toString()
        )

        libraryList[position] = item

    }


}
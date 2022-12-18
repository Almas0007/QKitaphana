package blim.enbek.talpynys.qkitaphana.fragment

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import blim.enbek.talpynys.qkitaphana.DataLibraryClass
import blim.enbek.talpynys.qkitaphana.LibraryViewModel
import blim.enbek.talpynys.qkitaphana.R
import blim.enbek.talpynys.qkitaphana.databinding.FragmentItemBinding

class ItemFragment : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance() = ItemFragment()
    }


    lateinit var binding: FragmentItemBinding
    private val vm: LibraryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        editItem()
        binding.buttonEdit.setOnClickListener {
            observeData()
            closeFragment()
        }


    }

    fun observeData() {

        val item = DataLibraryClass(
            1,
            binding.editTextNameLibrary.text.toString(),
            binding.editTextLibraryAddress.text.toString(),
            binding.editTextLibraryRating.text.toString().toFloat()
        )
        vm.liveItemData.value = item
    }

    fun editItem(){
        vm.liveItemData.observe(viewLifecycleOwner){
            binding.editTextNameLibrary.setText(it.nameLibrary)
            binding.editTextLibraryAddress.setText(it.addressLibrary)
            binding.editTextLibraryRating.setText(it.ratingLibrary.toString())
        }
    }


    fun closeFragment() {
        parentFragmentManager.beginTransaction().remove(this).commit()
    }

}
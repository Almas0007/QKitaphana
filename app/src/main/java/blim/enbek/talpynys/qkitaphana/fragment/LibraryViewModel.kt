package blim.enbek.talpynys.qkitaphana.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import blim.enbek.talpynys.qkitaphana.DataLibraryClass

class LibraryViewModel:ViewModel() {
    val viewData = MutableLiveData<List<DataLibraryClass>>()
}
package blim.enbek.talpynys.qkitaphana

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LibraryViewModel:ViewModel() {
    val liveDataList = MutableLiveData<ArrayList<DataLibraryClass>>()
}
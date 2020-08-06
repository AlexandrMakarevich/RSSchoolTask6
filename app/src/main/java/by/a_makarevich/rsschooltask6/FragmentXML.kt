package by.a_makarevich.rsschooltask6

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentXML : Fragment() {

    private var str: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MyLog", "OnCreateFragmentXML")
        arguments?.let {
            str = it.getString(ARG_PARAM1)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_xml, container, false)
        Log.d("MyLog", "OnCreateXML")


        return view
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            FragmentXML().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
        private const val ARG_PARAM1 = "param1"

    }

}
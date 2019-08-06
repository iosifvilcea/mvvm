package blankthings.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import blankthings.mvvm.R
import blankthings.mvvm.viewmodel.HomeViewModel
import blankthings.mvvm.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.view.*

class HomeFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.content_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

}

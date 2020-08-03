package blankthings.mvvm

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import blankthings.mvvm.view.HomeFragment
import blankthings.mvvm.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var loadingDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_NoActionBar)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadingDialog = AlertDialog.Builder(this)
            .setView(ProgressBar(this))
            .setCancelable(false)
            .create()

        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.loadingLiveData.observe(this, Observer {
            it?.let { show -> showLoadingDialog(show) }
        })

        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.content_view, HomeFragment())
                addToBackStack(null)
                commit()
            }
    }

    private fun showLoadingDialog(show: Boolean) {
        if (show) {
            loadingDialog.show()
        } else {
            loadingDialog.dismiss()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

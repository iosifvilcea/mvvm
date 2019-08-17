package blankthings.mvvm

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import blankthings.mvvm.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var loadingDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadingDialog = AlertDialog.Builder(this)
            .setView(ProgressBar(this))
            .setCancelable(false)
            .create()

        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.loadingLiveData.observe(this, Observer<Boolean> {showLoadingDialog(it)})

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
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

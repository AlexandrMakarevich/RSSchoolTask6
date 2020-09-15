package by.a_makarevich.rsschooltask6

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    private var currentFragment = CurrentFragment.FRAGMENT_JSON

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonJson = findViewById<Button>(R.id.buttonJson)
        val buttonXML = findViewById<Button>(R.id.buttonXML)
        val string1 = ""
        showFragmentRecycler(string1)
        Log.d("MyLog", "OnCreateActivity")

        val onClickListener = View.OnClickListener { v ->
            when (v.id) {
                R.id.buttonJson -> {
                    Log.d("MyLog", "click buttonJSON")
                    if (currentFragment == CurrentFragment.FRAGMENT_XML) {
                        title = "Все видео JSON"
                        currentFragment = CurrentFragment.FRAGMENT_JSON
                        val fragmentJSON = FragmentJSON.newInstance(title.toString())
                        val fragmentManager: FragmentManager = supportFragmentManager
                        val fragmentTransaction = fragmentManager.beginTransaction()
                        fragmentTransaction.replace(R.id.container, fragmentJSON, "Start")
                        fragmentTransaction.commit()
                        Log.d("MyLog", "showFragmentJSON")
                    }
                }
                R.id.buttonXML -> {
                    Log.d("MyLog", "click buttonXML")
                    if (currentFragment == CurrentFragment.FRAGMENT_JSON) {
                        title = "Все видео XML"
                        currentFragment = CurrentFragment.FRAGMENT_XML
                        val fragmentXml = FragmentXML.newInstance(title.toString())
                        val fragmentManager: FragmentManager = supportFragmentManager
                        val fragmentTransaction = fragmentManager.beginTransaction()
                        fragmentTransaction.replace(R.id.container, fragmentXml, "Start")
                        fragmentTransaction.commit()
                        Log.d("MyLog", "showFragmentJSON")
                    }
                }
            }
        }
        buttonJson.setOnClickListener(onClickListener)
        buttonXML.setOnClickListener(onClickListener)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val inflater: MenuInflater = menuInflater
            inflater.inflate(R.menu.menu, menu)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_dark_theme -> {
                setTheme(AppCompatDelegate.MODE_NIGHT_YES, 1)
            }
            R.id.menu_bright_theme -> {
                setTheme(AppCompatDelegate.MODE_NIGHT_NO, 0)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setTheme(themeMode: Int, prefsMode: Int) {
        AppCompatDelegate.setDefaultNightMode(themeMode)
        // saveTheme(prefsMode)
    }

    private fun showFragmentRecycler(myJSON: String) {
        title = "Все видео JSON"
        val fragmentJSON = FragmentJSON.newInstance(myJSON)
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.container, fragmentJSON, "Start")
        fragmentTransaction.commit()
        Log.d("MyLog", "showFragmentRecycler")
    }

    companion object {
        enum class CurrentFragment {
            FRAGMENT_JSON, FRAGMENT_XML
        }
    }
}
package tam.dev.baitap

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onResume() {
        super.onResume()
        Log.i("App step", "onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("App step", "onDestroy")
    }

    override fun onPause() {
        super.onPause()
        Log.i("App step", "onPause")
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.i("App step", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("App step", "onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.i("App step", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("App step", "onRestart")
    }


}
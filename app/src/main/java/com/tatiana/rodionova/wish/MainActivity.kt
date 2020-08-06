package com.tatiana.rodionova.wish

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.getkeepsafe.taptargetview.TapTarget
import com.getkeepsafe.taptargetview.TapTargetView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        TapTargetView.showFor(
            this,
            TapTarget.forView(
                findViewById<FloatingActionButton>(R.id.add),
                "Click to add first wish"
            )
                .outerCircleColor(R.color.colorPrimary)
                .outerCircleAlpha(0.9f)
                .targetCircleColor(R.color.white)
                .titleTextSize(20)
                .titleTextColor(R.color.white)
                .drawShadow(true)
                .cancelable(true)
                .tintTarget(true)
                .transparentTarget(true)
                .targetRadius(60),
            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView?) {
                    super.onTargetClick(view)
                    add.performClick()
                }
            }
        )
        findViewById<FloatingActionButton>(R.id.add).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
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
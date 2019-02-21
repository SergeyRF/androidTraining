package com.atilladroid.mngtask1

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import timber.log.Timber

abstract class MainActivity : AppCompatActivity() {

    lateinit var list: List<ActivityManager.RunningTaskInfo>
    lateinit var am: ActivityManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = resources.getString(R.string.app_name) + ";" + localClassName
        am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    }

    fun onInfoClick(v: View) {
        list = am.getRunningTasks(10)
        for (task in list) {
            if (task.baseActivity.flattenToShortString().startsWith("com.atilladroid.mngtask1")) {
                Timber.d("------------")
                Timber.d("Count: " + task.numActivities)
                Timber.d("Root: " + task.baseActivity.flattenToShortString())
                Timber.d("Top: " + task.topActivity.flattenToShortString())
            }
        }

    }
/*

    abstract fun onClickA(v:View)
    abstract fun onClickB(v: View)
    abstract fun onClickC(v:View)
    abstract fun onClickD(v: View)
*/

    fun onClickA(v: View) {
        startActivity(Intent(this, ActivityA::class.java))
    }

    fun onClickB(v: View) {
        startActivity(Intent(this, ActivityB::class.java))
    }

    fun onClickC(v: View) {
        startActivity(Intent(this, ActivityC::class.java))
    }

    fun onClickD(v: View) {
        startActivity(Intent(this, ActivityD::class.java))
    }
}

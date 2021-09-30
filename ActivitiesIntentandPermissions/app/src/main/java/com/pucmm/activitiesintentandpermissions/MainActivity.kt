package com.pucmm.activitiesintentandpermissions

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import androidx.core.app.ActivityCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var permissionList = mutableListOf<String>(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.CAMERA,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_CONTACTS
        );
        var switchs = mutableListOf<Switch>(
            findViewById<Switch>(R.id.storageSwitch),
            findViewById<Switch>(R.id.locationSwitch),
            findViewById<Switch>(R.id.cameraSwitch),
            findViewById<Switch>(R.id.phoneSwitch),
            findViewById<Switch>(R.id.contactSwitch)
        )

        for ( i in permissionList.indices) {
            if (ActivityCompat.checkSelfPermission(this, permissionList[i]) == PackageManager.PERMISSION_GRANTED) {
                switchs[i].isChecked = true;
            }
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                switchs[i].setTextColor(this.getColor(R.color.white))
            };
        }
        val continueButton = findViewById<Button>(R.id.continueButton);
    }


    private fun requestPermission() {
        val permissionList = mutableListOf<String>(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.CAMERA,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_CONTACTS
        );

        val switchs = mutableListOf<Switch>(
                findViewById<Switch>(R.id.storageSwitch),
                findViewById<Switch>(R.id.locationSwitch),
                findViewById<Switch>(R.id.cameraSwitch),
                findViewById<Switch>(R.id.phoneSwitch),
                findViewById<Switch>(R.id.contactSwitch)
        )
        val arr = mutableListOf<String>();
        for (i in switchs.indices) {
            if (switchs[i].isChecked) {
                arr.add(permissionList[i])
            }
        }
        if (arr.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, arr.toTypedArray(), 0);
        }
    }


    public fun nextPage(view: View) {
        requestPermission()
        val intent = Intent(this, TestPermission::class.java)
        startActivityForResult(intent, 0);
    }

    public fun checkPermission(view: View) {
        when(view.id) {
            R.id.storageSwitch -> {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    val mySnackbar = Snackbar.make(view, "Permission Granted!!!", Snackbar.LENGTH_SHORT)
                    mySnackbar.show()
                    val switch = findViewById<Switch>(view.id)
                    switch.isChecked = true
                }
            }
            R.id.locationSwitch -> {
                if( ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    val mySnackbar = Snackbar.make(view,"Permission Granted!!!", Snackbar.LENGTH_SHORT)
                    mySnackbar.show()
                    val switch = findViewById<Switch>(view.id)
                    switch.isChecked = true
                }

            }
            R.id.cameraSwitch -> {
                if( ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    val mySnackbar = Snackbar.make(view,"Permission Granted!!!", Snackbar.LENGTH_SHORT)
                    mySnackbar.show()
                    val switch = findViewById<Switch>(view.id)
                    switch.isChecked = true
                }

            }
            R.id.phoneSwitch -> {
                if( ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    val mySnackbar = Snackbar.make(view,"Permission Granted!!!", Snackbar.LENGTH_SHORT)
                    mySnackbar.show()
                    val switch = findViewById<Switch>(view.id)
                    switch.isChecked = true
                }

            }
            R.id.contactSwitch -> {
                if( ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
                    val mySnackbar = Snackbar.make(view,"Permission Granted!!!", Snackbar.LENGTH_SHORT)
                    mySnackbar.show()
                    val switch = findViewById<Switch>(view.id)
                    switch.isChecked = true
                }

            }
        }
    }

}
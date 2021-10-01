package com.pucmm.activitiesintentandpermissions

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.ContactsContract
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.material.snackbar.Snackbar

class TestPermission : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_permission)
    }

    public fun launchGoogleMaps(view: View) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            var mySnackbar = Snackbar.make(view, "Permission already granted.", Snackbar.LENGTH_SHORT);
            mySnackbar.setAction("Open", View.OnClickListener {
                // Create a Uri from an intent string. Use the result to create an Intent.
                val gmmIntentUri = Uri.parse("geo:37.7749,-122.4194")

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps")

                // Attempt to start an activity that can handle the Intent
                startActivity(mapIntent)
            }
            )
            mySnackbar.show()
        } else {
            var mySnackbar = Snackbar.make(view, "You need to grant location permission first", Snackbar.LENGTH_SHORT);
            mySnackbar.show()
        }
    }

    public fun launchContacts(view: View) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            var mySnackbar = Snackbar.make(view, "Permission already granted.", Snackbar.LENGTH_SHORT);
            mySnackbar.setAction("Open", View.OnClickListener {
                val intent = Intent(Intent.ACTION_PICK).apply {
                    type = ContactsContract.Contacts.CONTENT_TYPE
                }
                startActivity(intent)
            }
            )
            mySnackbar.show()
        } else {
            var mySnackbar = Snackbar.make(view, "You need to grant contacts permission first", Snackbar.LENGTH_SHORT);
            mySnackbar.show()
        }
    }


    public fun launchPhone(view: View) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            var mySnackbar = Snackbar.make(view, "Permission already granted.", Snackbar.LENGTH_SHORT);
            mySnackbar.setAction("Open", View.OnClickListener {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "829-960-2769"))
                startActivity(intent)
            }
            )
            mySnackbar.show()
        } else {
            var mySnackbar = Snackbar.make(view, "You need to grant phone permission first", Snackbar.LENGTH_SHORT);
            mySnackbar.show()
        }
    }


    public fun launchStorage(view: View) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            var mySnackbar = Snackbar.make(view, "Permission already granted.", Snackbar.LENGTH_SHORT);
            mySnackbar.setAction("Open", View.OnClickListener {
                val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                    type = "image/*"
                }
                startActivity(intent)
            }
            )
            mySnackbar.show()
        } else {
            var mySnackbar = Snackbar.make(view, "You need to grant storage permission first", Snackbar.LENGTH_SHORT);
            mySnackbar.show()
        }
    }

    public fun launchCamera(view: View) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            var mySnackbar = Snackbar.make(view, "Permission already granted.", Snackbar.LENGTH_SHORT);
            mySnackbar.setAction("Open", View.OnClickListener {
                val camera_intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                val pic_id = 123;
                startActivityForResult(camera_intent, pic_id);
            }
            )
            mySnackbar.show()
        } else {
            var mySnackbar = Snackbar.make(view, "You need to grant camera permission first", Snackbar.LENGTH_SHORT);
            mySnackbar.show()
        }
    }
}


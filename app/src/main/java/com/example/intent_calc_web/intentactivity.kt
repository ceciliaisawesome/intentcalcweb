package com.example.intent_calc_web

import android.content.Intent
import android.net.Uri
import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.content.pm.PackageManager
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class intentactivity : AppCompatActivity() {
    lateinit var Buttonsms:Button
    lateinit var Buttoncall:Button
    lateinit var Buttonmpesa:Button
    lateinit var Buttonshare:Button
    lateinit var Buttonemail:Button
    lateinit var Buttoncamera:Button
    lateinit var Buttondail:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intentactivity)
        Buttonsms = findViewById(R.id.Btn_sms)
        Buttoncall = findViewById(R.id.Btn_call)
        Buttonmpesa = findViewById(R.id.Btn_mpesa)
        Buttoncamera = findViewById(R.id.Btn_camera)
        Buttondail = findViewById(R.id.Btn_dial)
        Buttonemail = findViewById(R.id.Btn_email)
        Buttonshare = findViewById(R.id.Btn_share)

        Buttonsms.setOnClickListener {
            val uri = Uri.parse("smsto:0705880956")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("Hello", "How is today's weather")

            startActivity(intent)
        }
        Buttoncamera.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivityForResult(takePictureIntent, 1)
        }
        Buttoncall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"))

            if (ContextCompat.checkSelfPermission(
                    this@intentactivity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@intentactivity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
            Buttonshare.setOnClickListener {
                val shareIntent = Intent(Intent.ACTION_SEND)

                shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

                shareIntent.type = "text/plain"

                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

                startActivity(shareIntent)

            }
            Buttondail.setOnClickListener {
                val phone = "0705880956"

                val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

                startActivity(intent)

            }
            Buttonemail.setOnClickListener {

                val emailIntent =
                    Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))

                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

                startActivity(Intent.createChooser(emailIntent, "Send email..."))
            }
            Buttonmpesa.setOnClickListener {
                val simToolKitLaunchIntent =
                    applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")

                simToolKitLaunchIntent?.let { startActivity(it) }
            }
        }
    }
}
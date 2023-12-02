package com.example.travelmate

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.content.IntentSender
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.view.View
import android.view.View.OnClickListener
import android.view.inputmethod.InputMethodManager
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.chaos.view.PinView
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException


class MainActivity : AppCompatActivity() {

    private lateinit var oneTapClient: SignInClient
    private lateinit var signUpRequest: BeginSignInRequest
    private lateinit var btnGoogle: Button;
    private val REQ_ONE_TAP = 2  // Can be any integer unique to the Activity
    private var showOneTapUI = true



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)

        btnGoogle = findViewById(R.id.googleSignInButton)
        oneTapClient = Identity.getSignInClient(this)
        signUpRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    // Your server's client ID, not your Android client ID.
                    .setServerClientId(getString(R.string.web_client_id))
                    // Show all accounts on the device.
                    .setFilterByAuthorizedAccounts(false)
                    .build())
            .build();



        btnGoogle.setOnClickListener( View.OnClickListener() {
            oneTapClient.beginSignIn(signUpRequest)
                .addOnSuccessListener(this@MainActivity) { result ->
                    try {
  //                            startIntentSenderForResult(
   //                         result.pendingIntent.intentSender, REQ_ONE_TAP,
   //                         null, 0, 0, 0)
                    } catch (e: IntentSender.SendIntentException) {
                        Log.e(TAG, "Couldn't start One Tap UI: ${e.localizedMessage}")
                    }
                }
                .addOnFailureListener(this@MainActivity) { e ->
                    // No Google Accounts found. Just continue presenting the signed-out UI.
                    Log.d(TAG, e.localizedMessage)
                }

        }
        )




        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build();


    }
    public fun signin(view: View) {

    }

    }

class LoginActivity : Activity(), OnClickListener {
    private var username: String? = null
    private var password: String? = null
    private var ok: Button? = null
    private var editTextUsername: EditText? = null
    private var editTextPassword: EditText? = null
    private var saveLoginCheckBox: CheckBox? = null
    private lateinit var loginPreferences: SharedPreferences
    private var loginPrefsEditor: SharedPreferences.Editor? = null
    private var saveLogin: Boolean? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)
        ok = findViewById<View>(R.id.buttonLogin) as Button
        ok!!.setOnClickListener(this)
        editTextUsername = findViewById<View>(R.id.editTextUsername) as EditText
        editTextPassword = findViewById<View>(R.id.editTextPassword) as EditText
        saveLoginCheckBox = findViewById<View>(R.id.saveLoginCheckBox) as CheckBox
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE)
        loginPrefsEditor = loginPreferences.edit()
        saveLogin = loginPreferences.getBoolean("saveLogin", false)
        if (saveLogin == true) {
            editTextUsername!!.setText(loginPreferences.getString("username", ""))
            editTextPassword!!.setText(loginPreferences.getString("password", ""))
            saveLoginCheckBox!!.isChecked = true
        }
    }

    override fun onClick(view: View) {
        if (view === ok) {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(editTextUsername!!.windowToken, 0)
            username = editTextUsername!!.text.toString()
            password = editTextPassword!!.text.toString()
            if (saveLoginCheckBox!!.isChecked) {
                loginPrefsEditor!!.putBoolean("saveLogin", true)
                loginPrefsEditor!!.putString("username", username)
                loginPrefsEditor!!.putString("password", password)
                loginPrefsEditor!!.commit()
            } else {
                loginPrefsEditor!!.clear()
                loginPrefsEditor!!.commit()
            }
            doSomethingElse()
        }
    }

    fun doSomethingElse() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        finish()
    }}
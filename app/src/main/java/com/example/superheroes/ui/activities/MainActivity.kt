package com.example.superheroes.ui.activities

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroes.R
import com.example.superheroes.api.SuperheroImageRetriever
import com.example.superheroes.data.SuperheroImage
import com.example.superheroes.ui.adapter.SuperheroInfoAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.core.view.ViewCompat

import androidx.core.app.ActivityOptionsCompat
import kotlinx.android.synthetic.main.activity_display_superheros_info.*
import kotlinx.android.synthetic.main.superheroinfo.*
import java.net.URI.create
import android.transition.Fade
import androidx.appcompat.app.ActionBar


class MainActivity : AppCompatActivity() {

    private var mResultList: List<SuperheroImage> = emptyList()
    private val superRetriever = SuperheroImageRetriever()

    private val callback = object: Callback<List<SuperheroImage>> {
        override fun onFailure(call: Call<List<SuperheroImage>>, t: Throwable) {
            Log.e("MainActivity","${t.message}")
        }

        override fun onResponse(call: Call<List<SuperheroImage>>, response: Response<List<SuperheroImage>>) {
            response?.isSuccessful.let {
                Log.d("Superherocalled4" ,"${call.request().toString()}")
                mResultList = response?.body() ?: emptyList()
                Log.d("Superherocalled3","${response?.body()}")
                Log.d("mainActivity","$mResultList")
                val onItemClicked ={position: Int -> onCardItemClick(position)}
                SuperheroInfoList.adapter = SuperheroInfoAdapter(mResultList,onItemClicked)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(com.example.superheroes.R.layout.activity_main)

        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


        val actionbar: ActionBar? = supportActionBar
        actionbar?.hide()

        SuperheroInfoList.layoutManager = LinearLayoutManager(this)

        if (isNetworkConnected()) {
            Log.d("Superherocalled1","calling retriever")
            superRetriever.getSuperheroImages(callback)
        } else {
            AlertDialog.Builder(this).setTitle("No internet connection")
                .setMessage("check your connectivity")
                .setPositiveButton(android.R.string.ok) { _, _ -> }
                .setIcon(android.R.drawable.ic_dialog_alert).show()
        }
    }



    private fun onCardItemClick(position: Int) {
        if(mResultList[position].name.isNotEmpty()) {
            val intent= Intent(this,displaySuperherosInfo::class.java)
            intent.putExtra("superheroimage",mResultList[position].images.lg)
            intent.putExtra("id",mResultList[position].id)
            intent.putExtra("name",mResultList[position].name)
            intent.putExtra("slug",mResultList[position].slug)
            intent.putExtra("intelligence",mResultList[position].powerstats.intelligence)
            intent.putExtra("strength",mResultList[position].powerstats.strength)
            intent.putExtra("speed",mResultList[position].powerstats.speed)
            intent.putExtra("gender",mResultList[position].appearance.gender)
            intent.putExtra("race",mResultList[position].appearance.race)
            intent.putExtra("height",(mResultList[position].appearance.height).toString())
            intent.putExtra("weight",(mResultList[position].appearance.weight).toString())
            intent.putExtra("hair color",mResultList[position].appearance.hairColor)
            intent.putExtra("eye color",mResultList[position].appearance.eyeColor)
            intent.putExtra("full name",mResultList[position].biography.fullName)
            intent.putExtra("alter ego",mResultList[position].biography.alterEgos)
            intent.putExtra("place of birth",mResultList[position].biography.placeOfBirth)
            intent.putExtra("publisher",mResultList[position].biography.publisher)
            intent.putExtra("occupation",mResultList[position].work.occupation)
            intent.putExtra("base",mResultList[position].work.base)
            intent.putExtra("group affiliation",mResultList[position].connections.groupAffiliation)
            intent.putExtra("relatives",mResultList[position].connections.relatives)

            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this@MainActivity,
                (SuperheroImage as View?)!!, "simple_transition_activity"
            )
            startActivity(intent, options.toBundle())


           // startActivity(intent)
            //Toast.makeText(this,mResultList[position].name,Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this,"Superhero info not available", Toast.LENGTH_SHORT).show()
        }
    }

    fun isNetworkConnected() :Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork =  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            connectivityManager.activeNetwork
        } else {
            TODO("VERSION.SDK_INT < M")
        }

        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        return networkCapabilities != null && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }



}
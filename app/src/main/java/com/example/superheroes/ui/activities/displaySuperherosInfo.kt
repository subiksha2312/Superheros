package com.example.superheroes.ui.activities

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.superheroes.R
import com.squareup.picasso.Picasso
import android.transition.Fade
import android.view.View


class displaySuperherosInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(com.example.superheroes.R.layout.activity_display_superheros_info)

        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT



        val SImage=intent.getStringExtra("superheroimage")
        val SId=intent.getStringExtra("id")
        val Sname=intent.getStringExtra("name")
        val Sslug=intent.getStringExtra("slug")
        val Sintelligence=intent.getStringExtra("intelligence")
        val SStrength=intent.getStringExtra("strength")
        val Sspeed=intent.getStringExtra("speed")
        val Sgender=intent.getStringExtra("gender")
        val Srace=intent.getStringExtra("race")
        val SHeight=intent.getStringExtra("height")
        val SWeight=intent.getStringExtra("weight")
        val Shaircolor=intent.getStringExtra("hair color")
        val Seyecolor=intent.getStringExtra("eye color")
        val Sfullname=intent.getStringExtra("full name")
        val Salterego=intent.getStringExtra("alter ego")
        val SplaceOfBirth=intent.getStringExtra("place of birth")
        val Spublisher=intent.getStringExtra("publisher")
        val Soccupation=intent.getStringExtra("occupation")
        val Sbase=intent.getStringExtra("base")
        val SgroupAffiliation=intent.getStringExtra("group affiliation")
        val Srelatives=intent.getStringExtra("relatives")


        var SuperheroImage=findViewById<ImageView>(R.id.superheroImage)
        Picasso.get().load(SImage).into(SuperheroImage)

        var id=(findViewById(R.id.id) as TextView)
        id.setText(" ID: $SId")

        var name=(findViewById(R.id.name) as TextView)
        name.setText(" Name: $Sname")

        var slug=(findViewById(R.id.slug) as TextView)
        slug.setText(" Slug: $Sslug")

        var intelligence=(findViewById(R.id.intelligence) as TextView)
        intelligence.setText(" Intelligence: $Sintelligence")

        var strength=(findViewById(R.id.strength) as TextView)
        strength.setText(" Strength: $SStrength")

        var speed=(findViewById(R.id.speed) as TextView)
        speed.setText(" Speed: $Sspeed")

        var gender=(findViewById(R.id.gender) as TextView)
        gender.setText(" Gender: $Sgender")

        var race=(findViewById(R.id.race) as TextView)
        race.setText(" Race: $Srace")

        var height=(findViewById(R.id.height) as TextView)
        height.setText(" Height: $SHeight")

        var weight=(findViewById(R.id.weight) as TextView)
        weight.setText(" Weight: $SWeight")

        var hairColor=(findViewById(R.id.haircolor) as TextView)
        hairColor.setText(" Hair Color: $Shaircolor")

        var eyeColor=(findViewById(R.id.eyecolor) as TextView)
        eyeColor.setText(" Eye Color: $Seyecolor")

        var fullName=(findViewById(R.id.fullname) as TextView)
        fullName.setText(" Full Name: $Sfullname")

        var alterEgo=(findViewById(R.id.alterego) as TextView)
        alterEgo.setText(" Alter Egos: $Salterego")

        var placeOfBirth=(findViewById(R.id.placeofbirth) as TextView)
        placeOfBirth.setText(" Place of Birth: $SplaceOfBirth")

        var publisher=(findViewById(R.id.publisher) as TextView)
        publisher.setText(" Publisher: $Spublisher")

        var occupation=(findViewById(R.id.occupation) as TextView)
        occupation.setText(" Occupation: $Soccupation")

        var base=(findViewById(R.id.base) as TextView)
        base.setText(" Base: $Sbase")

        var groupAffiliation=(findViewById(R.id.groupaffiliation) as TextView)
        groupAffiliation.setText(" Group Affiliation: $SgroupAffiliation")

        var relatives=(findViewById(R.id.relatives) as TextView)
        relatives.setText(" Relatives: $Srelatives")



    }
}
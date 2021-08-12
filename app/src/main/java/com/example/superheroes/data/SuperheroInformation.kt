package com.example.superheroes.data

import com.google.gson.annotations.SerializedName

data class SuperheroImage (
    val id: Long,
    val name: String,
    val slug: String,
    val powerstats: Powerstats,
    val appearance: Appearance,
    val biography: Biography,
    val work: Work,
    val connections: Connections,
    val images: Images
)

data class Appearance (
    val gender: String,
    val race: String,
    val height: List<String>,
    val weight: List<String>,
    val eyeColor: String,
    val hairColor: String
)

data class Biography (
    val fullName: String,
    val alterEgos: String,
    val aliases: List<String>,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String,
    val alignment: String
)

data class Connections (
    val groupAffiliation: String,
    val relatives: String
)

data class Images (
    val xs: String,
    val sm: String,
    val md: String,
    val lg: String
)

data class Powerstats (
    val intelligence: Long,
    val strength: Long,
    val speed: Long,
    val durability: Long,
    val power: Long,
    val combat: Long
)

data class Work (
    val occupation: String,
    val base: String
)





/*


data class SuperheroInfo(
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats : List<Powerstats>,
    @SerializedName("appearance") val appearance : List<Appearance>,
    @SerializedName("biography") val biography : List<Biography>

)

data class Powerstats(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String,
)

data class Appearance(
    @SerializedName("gender") val gender: String,
    @SerializedName("race") val race: String,
    @SerializedName("height") val height: Height,
    @SerializedName("weight") val weight: Weight,
    @SerializedName("eyecolor") val eyeColor: String,
    @SerializedName("haircolor") val hairColor: String,
)

data class Weight(
    @SerializedName("lb") val lb : String,
    @SerializedName("kg") val kg : String
)


data class Height(
    @SerializedName("feet") val feet : String,
    @SerializedName("cm") val cm : String
)

data class Biography(
    @SerializedName("placeofbirth") val placeOfBirth : String,
    @SerializedName("firstAppearance") val firstAppearance : String,
    @SerializedName("publisher") val publisher : String,
    @SerializedName("alignment") val alignment : String,
    @SerializedName("work") val work : Work

)
data class Work(
    @SerializedName("occupation") val occupation : String,
    @SerializedName("base") val base : String
)

data class SuperheroImage(
    @SerializedName("superheroBase") val superheroBase: List<SuperheroInfo>,
    @SerializedName("id") val id : String,
    @SerializedName("url") val url : String,
    @SerializedName("width") val width : Int,
    @SerializedName("height") val height : Int
)



 */

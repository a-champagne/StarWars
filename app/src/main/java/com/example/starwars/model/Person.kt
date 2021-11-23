package com.example.starwars.model

import com.squareup.moshi.Json

data class Persons (
    val count: Int,
    val results: List<Person>,
    val next: String?
        )

data class Person (
    val name: String,
    @Json(name = "birth_year") val birthYear: String,
    @Json(name = "eye_color") val eyeColor: String,
    val gender: String,
    @Json(name = "hair_color") val hairColor: String,
    val height: String,
    val homeworld: String?,
    val films: List<String>,
    val mass: String,
    @Json(name ="skin_color") val skinColor: String,
    val species: List<String>?,
    val vehicles: List<String>?,
    val starships: List<String>?,
    val created: String,
    val edited: String,
    val url: String

    ) {
    override fun toString(): String{

        return  "${this.name} \n\n" +
                "Height \n" +
                "${this.height} cm \n\n" +
                "Mass: \n" +
                "${this.mass} kg \n\n" +
                "Hair Color: \n" +
                "${this.hairColor} \n\n"+
                "Skin Color: \n" +
                "${this.skinColor} \n\n" +
                "EyeColor: \n" +
                "${this.eyeColor} \n\n" +
                "Birth Year: \n" +
                "${this.birthYear} \n\n" +
                "Gender: \n" +
                "${this.gender} \n\n"

    }
}
package com.example.starwars.model

import android.provider.Contacts
import com.squareup.moshi.Json
import kotlinx.serialization.Serializable

@Serializable
data class Film(
    val title: String,
    @Json(name = "episode_id") val episodeId: Int,
    @Json(name = "opening_crawl") val openingCrawl: String,
    val director: String,
    val producer: String,
    @Json(name = "release_date") val releaseDate: String,
    val characters: List<String>,
    val planets: List<String>,
    val starships: List<String>,
    val vehicles: List<String>,
    val species: List<String>,
    val created: String,
    val edited: String,
    val url: String,

    ){


    private val keyToStringMap : Map<String,String> =
        mapOf(
            ::title.name to "Title:",
            ::episodeId.name to "Episode Number:",
            ::openingCrawl.name to "Opening Crawl:",
            ::director.name to "Director: ",
            ::producer.name to "Producer: ",
            ::releaseDate.name to "Release Date: ",
            ::characters.name to "Characters: ",
            ::planets.name to "Planets: ",
            ::starships.name to "Starships: ",
            ::vehicles.name to "Vehicles: ",
            ::species.name to "Species: ",
            ::created.name to "Created: ",
            ::edited.name to "Edited: ",
            ::url.name to "Url: "
        )
    override fun toString(): String {
        return  "${this.title} \n\n"+
                "Episode Number: \n" +
                " ${this.episodeId} \n\n" +
                "Opening Crawl: \n" +
                " ${this.openingCrawl} \n\n" +
                "Director: \n" +
                " ${this.director} \n\n" +
                "Producers: \n" +
                " ${this.producer} \n\n" +
                "Release Date: \n" +
                " ${this.releaseDate} "
    }



}
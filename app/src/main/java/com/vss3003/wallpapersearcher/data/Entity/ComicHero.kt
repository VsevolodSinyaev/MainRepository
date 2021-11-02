package com.vss3003.wallpapersearcher.data.Entity

import com.google.gson.annotations.SerializedName
import java.sql.Array

data class ComicHero(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("full-name")
    val full_name: String,
    @SerializedName("alter-egos")
    val alter_egos: String,
    @SerializedName("aliases")
    val aliases: Array,
    @SerializedName("place-of-birth")
    val place_of_birth: String,
    @SerializedName("first_appearance")
    val first_appearance: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("alignment")
    val alignment: String,
    @SerializedName("intelligence")
    val intelligence: Int,
    @SerializedName("strength")
    val strength: Int,
    @SerializedName("speed")
    val speed: Int,
    @SerializedName("durability")
    val durability: Int,
    @SerializedName("power")
    val power: Int,
    @SerializedName("combat")
    val combat: Int,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("race")
    val race: String,
    @SerializedName("height")
    val height: Array,
    @SerializedName("weight")
    val weight: Array,
    @SerializedName("eye-color")
    val eye_color: String,
    @SerializedName("hair-color")
    val hair_color: String,
    @SerializedName("occupation")
    val occupation: String,
    @SerializedName("base")
    val base: String,
    @SerializedName("group-affiliation")
    val group_affiliation: String,
    @SerializedName("relatives")
    val relatives: String,
    @SerializedName("image")
    val image: String
)
package com.ecervera.cocktails.data.server

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteDrink(
    @Json(name = "idDrink")
    val idDrink: String,
    @Json(name = "strDrink")
    val name: String,
    @Json(name = "dateModified")
    val dateModified: String? = null,
    @Json(name = "strAlcoholic")
    val alcoholic: String,
    @Json(name = "strCategory")
    val category: String,
    @Json(name = "strCreativeCommonsConfirmed")
    val creativeCommonsConfirmed: String,
    @Json(name = "strDrinkAlternate")
    val drinkAlternate: String?,
    @Json(name = "strDrinkThumb")
    val drinkThumb: String,
    @Json(name = "strGlass")
    val glass: String,
    @Json(name = "strIBA")
    val IBA: String? = null,
    @Json(name = "strImageAttribution")
    val imageAttribution: String? = null,
    @Json(name = "strImageSource")
    val imageSource: String,
    @Json(name = "strIngredient1")
    val ingredient1: String,
    @Json(name = "strIngredient2")
    val ingredient2: String? = null,
    @Json(name = "strIngredient3")
    val ingredient3: String? = null,
    @Json(name = "strIngredient4")
    val ingredient4: String? = null,
    @Json(name = "strIngredient5")
    val ingredient5: String? = null,
    @Json(name = "strIngredient6")
    val ingredient6: String? = null,
    @Json(name = "strIngredient7")
    val ingredient7: String? = null,
    @Json(name = "strIngredient8")
    val ingredient8: String? = null,
    @Json(name = "strIngredient9")
    val ingredient9: String? = null,
    @Json(name = "strIngredient10")
    val ingredient10: String? = null,
    @Json(name = "strIngredient11")
    val ingredient11: String? = null,
    @Json(name = "strIngredient12")
    val ingredient12: String? = null,
    @Json(name = "strIngredient13")
    val ingredient13: String? = null,
    @Json(name = "strIngredient14")
    val ingredient14: String? = null,
    @Json(name = "strIngredient15")
    val ingredient15: String? = null,
    @Json(name = "strInstructions")
    val instructions: String,
    @Json(name = "strInstructionsES")
    val instructionsES: String? = null,
    @Json(name = "strInstructionsDE")
    val instructionsDE: String? = null,
    @Json(name = "strInstructionsFR")
    val instructionsFR: String? = null,
    @Json(name = "strInstructionsIT")
    val instructionsIT: String? = null,
    @Json(name = "strInstructionsZH-HANS")
    val instructionsZH: String? = null,
    @Json(name = "strInstructionsZH-HANT")
    val instructionsZHHant: String? = null,
    @Json(name = "strMeasure1")
    val measure1: String,
    @Json(name = "strMeasure2")
    val measure2: String? = null,
    @Json(name = "strMeasure3")
    val measure3: String? = null,
    @Json(name = "strMeasure4")
    val measure4: String? = null,
    @Json(name = "strMeasure5")
    val measure5: String? = null,
    @Json(name = "strMeasure6")
    val measure6: String? = null,
    @Json(name = "strMeasure7")
    val measure7: String? = null,
    @Json(name = "strMeasure8")
    val measure8: String? = null,
    @Json(name = "strMeasure9")
    val measure9: String? = null,
    @Json(name = "strMeasure10")
    val measure10: String? = null,
    @Json(name = "strMeasure11")
    val measure11: String? = null,
    @Json(name = "strMeasure12")
    val measure12: String? = null,
    @Json(name = "strMeasure13")
    val measure13: String? = null,
    @Json(name = "strMeasure14")
    val measure14: String? = null,
    @Json(name = "strMeasure15")
    val measure15: String? = null,
    @Json(name = "strTags")
    val tags: String? = null,
    @Json(name = "strVideo")
    val video: String? = null
)
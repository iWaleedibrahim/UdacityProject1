package com.udacity.shoestore.viewmodels

import android.os.Build
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

class SharedViewModel : ViewModel() {

    val firstShoeImages: List<String> = mutableListOf(
        "https://media.gq.com/photos/5d93aa2c636d4800084025ae/16:9/pass/sneakers.jpg",
        "https://images.unsplash.com/flagged/photo-1556637640-2c80d3201be8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8c25lYWtlcnxlbnwwfHwwfHw%3D&w=1000&q=80",
        "https://us.123rf.com/450wm/alexbr1972/alexbr19722011/alexbr1972201100009/159263862-paar-nieuwe-donkerblauwe-sneakers-ge%C3%AFsoleerd-op-een-witte-achtergrond-.jpg?ver=6",
        "https://st.depositphotos.com/1155723/2097/i/600/depositphotos_20975693-stock-photo-sneakers-isolated-on-white-background.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQ39B5Aajqm_zNIoyWFkEGAl5beiZFlDNBHaqLfddQuqMue-sI1B_CCssgSQCou4g_gx8&usqp=CAU",
    )

    val secondShoeImages: List<String> = mutableListOf(
        "https://rukminim1.flixcart.com/image/832/832/ja73ki80/shoe/g/2/a/aerobounce-st-m-8-adidas-cblack-ftwwht-utiblk-original-imaezp4rerzbxb2h.jpeg?q=70",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTq4ECxkfnJ1XIQrWpBY5U_QqFISoTuSOGiWA&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgLT0KUGP-beJFnm6QxqteP7VOl6KPvRNolg&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTR50ErzDFWjb3yP1JVqTEcdjNFhU00I_tncw&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTryQzwFcY0fVowG86WpyC-wwRnbCvG2-acDMVYYG7luWCZETrwN5a244kgrqpEXOVeixQ&usqp=CAU",

        )

    val thirdShoeImages: List<String> = mutableListOf(
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM_zqbfOH5lySAiCYOsvWxX6wORvBiwZ37jOHqLcP1l7RU-vckqLdPq_OAuf6TSkJbZy4&usqp=CAU",
        "https://underarmour.scene7.com/is/image/Underarmour/3024936-001_PAIR?rp=standard-30pad|pdpMainDesktop&scl=1&fmt=jpg&qlt=85&resMode=sharp2&cache=on,on&bgc=f0f0f0&wid=566&hei=708&size=536,688",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAC8SX9h8SDA3CYrZcFue9-74N6tP9zClZOauFTeze1jH9tl3pa8Ilzs3uZ_jxiihBY98&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_pauUUBzrNqjh7cQQLB3IAHQ8N-TgnkLzwQ&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2QtIOXoeaoShkpVOxqwBKg3irg5l0yzuEbzpcCQljyB48troFp-ZbbxTGI-4x9hsiW5U&usqp=CAU",
        )

    val fourthShoeImages: List<String> = mutableListOf(
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_pauUUBzrNqjh7cQQLB3IAHQ8N-TgnkLzwQ&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM_zqbfOH5lySAiCYOsvWxX6wORvBiwZ37jOHqLcP1l7RU-vckqLdPq_OAuf6TSkJbZy4&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAC8SX9h8SDA3CYrZcFue9-74N6tP9zClZOauFTeze1jH9tl3pa8Ilzs3uZ_jxiihBY98&usqp=CAU",
        "https://us.123rf.com/450wm/alexbr1972/alexbr19722011/alexbr1972201100009/159263862-paar-nieuwe-donkerblauwe-sneakers-ge%C3%AFsoleerd-op-een-witte-achtergrond-.jpg?ver=6",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2QtIOXoeaoShkpVOxqwBKg3irg5l0yzuEbzpcCQljyB48troFp-ZbbxTGI-4x9hsiW5U&usqp=CAU",
    )

    private val _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoesList: LiveData<MutableList<Shoe>>
        get() = _shoesList

    private val _currentShoe = MutableLiveData<Shoe>()
    val currentShoe: LiveData<Shoe>
        get() = _currentShoe

    init {
        setListData()
    }

    fun onItemSelect(view: View ) {
        val current_view =  view.getTag().toString()
        when(current_view.toString()) {
            "first_image"  -> _currentShoe.value = _shoesList.value?.get(0)
            "second_image" -> _currentShoe.value = _shoesList.value?.get(1)
            "third_image"  -> _currentShoe.value = _shoesList.value?.get(2)
            "fourth_image" -> _currentShoe.value = _shoesList.value?.get(3)
        }
        view.findNavController().navigate(R.id.action_listingFragment_to_detailFragment)
    }

    private fun setListData() {
        _shoesList.value = mutableListOf(
            Shoe(
                name = "Converse",
                size = 35.3,
                company = "Converse Inc.",
                description = "Converse is a very good Shoe. ",
                images = firstShoeImages
            ),
            Shoe(
                name = "Nike Run",
                size = 39.8,
                company = "Nike Inc.",
                description = "Nike Run is a very good Shoe. ",
                images = secondShoeImages,
            ),
            Shoe(
                name = "Puma Air",
                size = 42.5,
                company = "Puma Inc.",
                description = "Puma AirPuma Air is a very Shoe. ",
                images = thirdShoeImages,
            ),
            Shoe(
                name = "Adidas Run",
                size = 44.2,
                company = "Adidas Inc.",
                description = "Adidas Run is a very good Shoe. ",
                images = fourthShoeImages,
            ),
        )
    }

}





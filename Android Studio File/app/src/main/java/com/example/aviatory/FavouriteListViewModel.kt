package com.example.aviatory

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class FavouriteListViewModel : ViewModel() {
    val favouritesList = mutableStateListOf<String>()

    fun addFavourite(item: String) {
        favouritesList.add(item)
    }

    fun removeFavourite(item: String) {
        favouritesList.remove(item)
    }

    fun updateFavourites(index: Int, newItem: String) {
        favouritesList[index] = newItem
    }

    fun isInFavourites(itemId: String): Boolean {
        return itemId in favouritesList
    }
}
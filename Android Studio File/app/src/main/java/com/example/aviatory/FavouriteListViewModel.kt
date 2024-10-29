package com.example.aviatory

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.snapshots.SnapshotStateList

class FavouritesViewModel : ViewModel() {
    private val _favourites = mutableStateListOf<String>()
    val favourites: SnapshotStateList<String> = _favourites
    // val favouritesList = mutableStateListOf<String>()

    fun addFavourite(item: String) {
        _favourites.add(item)
    }

    fun removeFavourite(item: String) {
        _favourites.remove(item)
    }

    fun updateFavourites(index: Int, newItem: String) {
        _favourites[index] = newItem
    }

    fun isInFavourites(itemId: String): Boolean {
        return itemId in _favourites
    }

    fun toggleFavourite(itemId: String) {
        if (_favourites.contains(itemId)) {
            _favourites.remove(itemId)
        } else {
            _favourites.add(itemId)
        }
    }

    fun isFavourite(itemId: String): Boolean {
        return _favourites.contains(itemId)
    }
}
package com.example.aviatory

class Plane(
    var name: String,
    var airline: String,
    var numProduced: Int/*,
    var favourite: Boolean*/
) {
    fun newPlane(name: String, airline: String, numProduced: Int) {
        this.name = name
        this.airline = airline
        this.numProduced = numProduced
    }

    fun addToFavourites(FavouriteListViewModel: FavouriteListViewModel) {
        FavouriteListViewModel.addFavourite(name)
    }

    fun removeFromFavourites(FavouriteListViewModel: FavouriteListViewModel) {
        FavouriteListViewModel.removeFavourite(name)
    }
}
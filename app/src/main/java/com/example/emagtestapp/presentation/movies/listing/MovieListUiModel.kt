package com.example.emagtestapp.presentation.movies.listing

import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import com.example.emagtestapp.BR
import com.example.emagtestapp.R
import com.example.emagtestapp.presentation.movies.listing.model.MovieItem
import me.tatarka.bindingcollectionadapter2.ItemBinding
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass

class MovieListUiModel {

    val movieAdapterItems: MutableLiveData<List<MovieItem>> = MutableLiveData()

    val diffConfig = object : DiffUtil.ItemCallback<MovieItem>() {
        override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean =
            oldItem.movieId == newItem.movieId

        override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean =
            oldItem == newItem
    }

    val itemBinding: OnItemBindClass<MovieItem> = OnItemBindClass<MovieItem>()
        .map(MovieItem::class.java, object : OnItemBindClass<MovieItem>() {
            override fun onItemBind(itemBinding: ItemBinding<*>, position: Int, item: MovieItem?) {
                itemBinding.clearExtras()
                    .set(BR.movie, R.layout.item_movie_list)
            }
        })

    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
}
package com.semi.awlem.ui.home.home

import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.semi.awlem.R
import com.semi.awlem.base.BaseViewModel
import com.semi.awlem.ui.home.home.adapter.CategoryAdapter
import com.semi.awlem.ui.home.home.adapter.SuggestProductsAdapter
import com.semi.awlem.ui.home.home.adapter.SuggestRestaurantAdapter
import com.semi.awlem.utility.ContextConverter.getActivity
import com.semi.awlem.utility.NavigationUtil.findNavigationController
import com.semi.awlem.utility.NavigationUtil.navigateTo
import com.semi.awlem.utility.SnackBar.customSnackBar
import com.semi.entity.database.categoryController.CategoryEntity
import com.semi.entity.response.home.SuggestedProducts
import com.semi.entity.response.home.SuggestedRestaurantsResponse
import kotlinx.coroutines.async

class HomeViewModel @ViewModelInject constructor(private val repository: HomeRepository) :
    BaseViewModel(), CategoryAdapter.ClickListener, SuggestRestaurantAdapter.ClickListener,
    SuggestProductsAdapter.ClickListener {
    val name = "مرحبا بك " + repository.pref.getUser()?.name
    val categoryAdapter = CategoryAdapter(this)
    val suggestRestaurantAdapter = SuggestRestaurantAdapter(this)
    val suggestProductsAdapter = SuggestProductsAdapter(this)
    val categoriesLiveData = repository.getCategoriesLiveData()
    fun onSearchClick(v: View) {
        v.findNavigationController().navigateTo(
            id = R.id.action_HomeFragment_to_SearchFragment
        )

    }

    init {
        getTypes(null)
        suggestedRestaurants(null)
        suggestedProducts(null)
    }

    fun getTypes(v: View?) {
        viewModelScope.async {
            repository.getTypesTaskRepo(onLoading = {},
                onError = { errorMessageId: Int, errorContent, icon: Int ->
                    val activity = v?.context?.getActivity()
                    activity?.customSnackBar(
                        errorMessageId,
                        errorContent,
                        icon,
                    ) {}
                })
        }
    }

    fun suggestedRestaurants(v: View?) {
        viewModelScope.async {
            repository.suggestedRestaurantsTaskRepo(onLoading = {},
                onSuccess = { list: List<SuggestedRestaurantsResponse>? ->
                    suggestRestaurantAdapter.submitList(
                        list
                    )
                },
                onError = { errorMessageId: Int, errorContent, icon: Int ->
                    val activity = v?.context?.getActivity()
                    activity?.customSnackBar(
                        errorMessageId,
                        errorContent,
                        icon,
                    ) {}
                })
        }
    }

    fun suggestedProducts(v: View?) {
        viewModelScope.async {
            repository.suggestedProductsTaskRepo(onLoading = {},
                onSuccess = { list: List<SuggestedProducts>? ->
                    suggestProductsAdapter.submitList(list)
                },
                onError = { errorMessageId: Int, errorContent, icon: Int ->
                    val activity = v?.context?.getActivity()
                    activity?.customSnackBar(
                        errorMessageId,
                        errorContent,
                        icon,
                    ) {}
                })
        }
    }

    override fun onItemClick(v: View, car: CategoryEntity) {

    }

    override fun onItemClick(v: View, car: SuggestedRestaurantsResponse) {

    }

    override fun onItemClick(v: View, car: SuggestedProducts) {

    }

}
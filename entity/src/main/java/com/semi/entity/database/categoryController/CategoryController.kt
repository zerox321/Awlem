package com.semi.entity.database.categoryController

import com.semi.entity.response.home.CategoryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryController @Inject constructor(private val dao: CategoryDao) {

    suspend fun insertCategoryList(list: List<CategoryResponse>) =
        withContext(Dispatchers.IO) {
            val products = list.map {
                CategoryEntity(
                    id = it.id,
                    name = it.name,
                    photo = it.photo
                )
            }
            dao.deleteDb()
            dao.insertList(products)
        }


    fun getDao() = dao


}
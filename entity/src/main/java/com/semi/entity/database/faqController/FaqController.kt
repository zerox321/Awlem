package com.semi.entity.database.faqController

import com.semi.entity.response.menu.FaqResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FaqController @Inject constructor(private val dao: FaqDao) {

    suspend fun insertFaqList(list: List<FaqResponse>) =
        withContext(Dispatchers.IO) {
            val products = list.map {
                FaqEntity(
                    id = it.id,
                    answer = it.answer,
                    question = it.question
                )
            }
            dao.deleteDb()
            dao.insertList(products)
        }


    fun getDao() = dao


}
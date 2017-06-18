package com.example.administrator.myapplication.View

import com.example.administrator.myapplication.Bean.User

/**
 * Created by Administrator on 2017/6/17.
 */
interface IUserView {
    fun getFirstName():String
    fun getLastName():String
    fun setFirstName(firstName:String)
    fun setLastName(lastName:String)
    fun getID():Int
    fun onSaveSuccess()

}
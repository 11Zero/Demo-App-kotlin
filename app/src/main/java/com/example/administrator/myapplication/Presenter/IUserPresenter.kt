package com.example.administrator.myapplication.Presenter

/**
 * Created by Administrator on 2017/6/18.
 */
interface IUserPresenter {
    fun saveUser(id:Int,firstName:String,lastName:String)
    fun loadUser(id:Int)
}
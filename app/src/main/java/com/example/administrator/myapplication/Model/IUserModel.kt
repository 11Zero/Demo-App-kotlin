package com.example.administrator.myapplication.Model
import com.example.administrator.myapplication.Bean.User
/**
 * Created by Administrator on 2017/6/17.
 */
interface IUserModel {
    fun setID(id:Int)
    fun setFirstName(firstName:String)
    fun setLastName(lastName:String)
    fun save()
    fun load(id:Int):User
}
package com.example.administrator.myapplication.Presenter

import android.util.Log
import com.example.administrator.myapplication.Model.UserModel
import com.example.administrator.myapplication.View.IUserView

/**
 * Created by Administrator on 2017/6/17.
 */
public class UserPresenter(val view:IUserView):IUserPresenter{
    //private var mUserView = UserView()
    private val mUserModel:UserModel = UserModel()

    override fun loadUser(id: Int) {

        Log.d("test_log","loadUser:$id")
        val user = mUserModel.load(id)
        view.setFirstName(user.firstName)
        view.setLastName(user.lastName)
    }

    override fun saveUser(id: Int, firstName: String, lastName: String) {
        Log.d("test_log","saveUser:$id,$firstName,$lastName")
        mUserModel.setID(id)
        mUserModel.setFirstName(firstName)
        mUserModel.setLastName(lastName)
        mUserModel.save()
        //Thread.sleep(4000)
        view.onSaveSuccess()
    }
}
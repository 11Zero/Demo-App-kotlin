package com.example.administrator.myapplication.Model

import android.util.SparseArray
import com.example.administrator.myapplication.Bean.User

/**
 * Created by Administrator on 2017/6/17.
 */
public class UserModel:IUserModel{

    private var mId:Int = 0
    private var mFirstName:String = ""
    private var mLastName:String = ""
    private val mUserArray = SparseArray<User>()

    override fun setID(id: Int) {
        mId = id
    }

    override fun setFirstName(firstName: String) {
        mFirstName = firstName
    }

    override fun setLastName(lastName: String) {
        mLastName = lastName
    }

    override fun save(){
        mUserArray.append(mId,User(mFirstName,mLastName))
    }

    override fun load(id: Int): User {
        mId = id
        return mUserArray.get(mId,User("null","null"))
    }

}


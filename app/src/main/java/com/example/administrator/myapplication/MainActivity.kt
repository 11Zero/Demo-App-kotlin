package com.example.administrator.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.UiThread
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.administrator.myapplication.Presenter.UserPresenter
import com.example.administrator.myapplication.View.IUserView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),IUserView, View.OnClickListener {

    private var mUserPresenter:UserPresenter?=null
    private var mythread:UiThread?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mUserPresenter = UserPresenter(this)
        //textView_fname.setText("Hello, guy!")
        progressBar_loading.max=100
        progressBar_loading.setProgress(20)

        btn_save.setOnClickListener(this)
        btn_load.setOnClickListener(this)
//        btn_save.setOnClickListener({
//            mUserPresenter?.saveUser(getID(),getFirstName(),getLastName())
//            progressBar_loading.setProgress(25)
//        })
    }

    override fun onClick(v: View) {

        when(v.id){
            R.id.btn_save->mUserPresenter?.saveUser(getID(),getFirstName(),getLastName())
            R.id.btn_load->mUserPresenter?.loadUser(getID())
            else->{}
        }
    }

    override fun getID(): Int {

        val id = editText_id.text.toString().trim()
        if (id.isNotEmpty())
            return id.toInt()
        else
            return 0
    }

    override fun onSaveSuccess() {

        editText_id.setText("")
        editText_fname.setText("")
        editText_lname.setText("")
        Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show()
    }

    override fun setLastName(lastName: String) {

        Log.d("test_log","setLastName:$lastName")
        editText_lname.setText(lastName)
    }

    override fun setFirstName(firstName: String) {

        Log.d("test_log","setLastName:$firstName")
        editText_fname.setText(firstName)
    }

    override fun getLastName(): String {

        return editText_lname.text.toString()
    }

    override fun getFirstName(): String {

        return editText_fname.text.toString()
    }
}

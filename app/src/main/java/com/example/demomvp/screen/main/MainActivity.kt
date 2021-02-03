package com.example.demomvp.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demomvp.R
import com.example.demomvp.data.model.User
import com.example.demomvp.data.source.UserRepository
import com.example.demomvp.screen.adapter.MainAdapter
import com.example.demomvp.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View, OnItemRecyclerViewClickListener<User> {

    private val mAdapter: MainAdapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initView() {
        with(recyclerViewUser) {
            setHasFixedSize(true)
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
        mAdapter.registerItemRecyclerViewClickListener(this)
    }

    private fun initData() {
        val presenter = MainPresenter(UserRepository.instance)
        presenter.setView(this)
        presenter.onStart()
    }

    override fun onGetUsersSuccess(users: MutableList<User>) {
        mAdapter.updateData(users)
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(this, exception?.message, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClickListener(item: User?) {
        Toast.makeText(this, item?.lastName, Toast.LENGTH_SHORT).show()
    }
}

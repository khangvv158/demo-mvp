@file:Suppress("DEPRECATION")

package com.example.demomvp.screen.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.demomvp.R
import com.example.demomvp.data.model.User
import com.example.demomvp.utils.Constant
import com.example.demomvp.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.item_layout_user.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder?>() {

    private val mUsers = mutableListOf<User>()
    private var onItemClickListener: OnItemRecyclerViewClickListener<User>? = null

    fun updateData(users: MutableList<User>?) {
        users?.let {
            mUsers.clear()
            mUsers.addAll(users)
            notifyDataSetChanged()
        }
    }

    fun registerItemRecyclerViewClickListener(
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<User>?
    ) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_layout_user, p0, false)
        return ViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindViewData(mUsers[p1])
    }

    override fun getItemCount(): Int = mUsers.size

    inner class ViewHolder(
        itemView: View,
        private val itemListener: OnItemRecyclerViewClickListener<User>?
    ) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var listener: OnItemRecyclerViewClickListener<User>? = null

        fun bindViewData(user: User) {
            itemView.textViewName.text = user.lastName + Constant.STRING_SPACE + user.firstName
            itemView.textViewEmail.text = user.email
            getImageCircle(user)
            itemView.setOnClickListener(this)
            listener = itemListener
        }

        private fun getImageCircle(user: User) {
            Glide.with(itemView.context)
                .load(user.avatar)
                .into(itemView.imageAvatar)
        }

        override fun onClick(p0: View?) {
            listener?.onItemClickListener(mUsers[adapterPosition])
        }
    }
}

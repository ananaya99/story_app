package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class UserAdapter(val context:Context,val userlist:ArrayList<user>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view:View = LayoutInflater.from(context).inflate(R.layout.user_layoutś,parent,false);
        return UserViewHolder(View);
    }

    override fun getItemCount(): Int {
return userlist.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
val currentuser = userlist[position]
        holder.textname.text=currentuser.name
    }

    class UserViewHolder:RecyclerView.ViewHolder(itemView){
        val textname = itemView.findViewById<TextView>(R.id.txt_name)

    }

}
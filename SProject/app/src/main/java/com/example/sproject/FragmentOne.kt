package com.example.sproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentOne() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view : View = inflater.inflate(R.layout.fragment_one, container, false)
        val containerView = view.findViewById<RecyclerView>(R.id.Home_List)
        val lm : LinearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        containerView.layoutManager = lm

        val homeList = ArrayList<SnsList>()
        for (i in 0 until 10) {
            homeList.add(SnsList("토트넘 $i 팬", "" + i + "번째 가입을 축하합니다"))
        }

        val reAdapter = RecycleAdapter(homeList, LayoutInflater.from(context))

        containerView.adapter = reAdapter

        return view
    }
}

class SnsList (val title: String, val content: String)

// Recycler View Fragment One
class RecycleAdapter(
    val itemList : ArrayList<SnsList>,
    val inflater : LayoutInflater
) : RecyclerView.Adapter<RecycleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val snsTitle : TextView
        val snsContent : TextView

        init {
            snsTitle = itemView.findViewById(R.id.sns_title)
            snsContent = itemView.findViewById(R.id.sns_content)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = inflater.inflate(R.layout.home_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.snsTitle.setText(itemList.get(position).title)
        holder.snsContent.setText(itemList.get(position).content)
    }

    override fun getItemCount(): Int = itemList.size

}
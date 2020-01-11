package com.example.RetroJSON

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_displaytxt.view.*

class NameageAdapter(val dpnameage: List<Nameage>): RecyclerView.Adapter<NameageAdapter.NameageHolder>() {

   class NameageHolder(val view:View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameageHolder {
        return NameageHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_displaytxt,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return dpnameage.size

    }

    override fun onBindViewHolder(holder: NameageHolder, position: Int) {

        val binding = dpnameage[position]

        holder.view.TVName.text = binding.Name
        holder.view.TVid.text = binding.ID.toString()
        holder.view.TVTraining.text = binding.Training
        holder.view.TVPhone.text = binding.PhoneNo
    }
}
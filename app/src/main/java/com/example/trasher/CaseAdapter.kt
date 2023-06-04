package com.example.trasher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trasher.databinding.CaseListItemBinding
import retrofit2.http.GET

class CaseAdapter(val listener: Listener): RecyclerView.Adapter<CaseAdapter.CaseHolder>() {

    private var CaseList = ArrayList<Case>()


    class CaseHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = CaseListItemBinding.bind(item)
        fun bind(case: Case, listener: Listener){
            val id = case.id.toString()
            binding.textViewCaseId.text = "Дело №$id"
            itemView.setOnClickListener{
                listener.onClick(case)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CaseHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.case_list_item, parent, false)
        return CaseHolder(view)
    }

    override fun getItemCount(): Int {
        return CaseList.size
    }

    override fun onBindViewHolder(holder: CaseHolder, position: Int) {
        holder.bind(CaseList[position], listener)
    }

    fun addCase(case: Case){
        CaseList.add(case)
        notifyDataSetChanged()
    }

    fun delCase(case: Case){
        CaseList.remove(case)
        notifyDataSetChanged()
    }

    fun clearList(){
        CaseList.removeAll(CaseList)
        notifyDataSetChanged()
    }

    fun setList(arrayList: ArrayList<Case>){
        CaseList = arrayList
        notifyDataSetChanged()
    }

    fun getList()=CaseList

    interface Listener{
        fun onClick(case: Case){
        }
    }


}
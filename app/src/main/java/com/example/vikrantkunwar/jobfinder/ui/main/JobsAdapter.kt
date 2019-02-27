package com.example.vikrantkunwar.jobfinder.ui.main

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.vikrantkunwar.jobfinder.R
import com.example.vikrantkunwar.jobfinder.data.model.Job
import kotlinx.android.synthetic.main.job_item.view.*
import java.text.SimpleDateFormat
import java.util.*


class JobsAdapter():
    RecyclerView.Adapter<JobsAdapter.ViewHolder>() {

    private lateinit var context: Context
    private lateinit var activity: Activity
    private lateinit var items:List<Job>

    private var outputOormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)
    private var inputFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.US)
    private var inputFormat2 = SimpleDateFormat("yyyy-MM-dd", Locale.US)


    constructor(context: Context, activity: Activity,items: List<Job>) : this() {
        this.context = context
        this.activity = activity
        this.items = items

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.job_item, parent, false))
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {







        holder.companyName.text = items[position].companyName
        holder.jobTitle.text = items[position].jobTitle
        if( items[position].location == null){

          if(items[position].locations!!.isNotEmpty()){

              val inputDate = inputFormat2.parse(items[position].postDate)
              val tempPostDate = outputOormat.format(inputDate)

              val nums =  items[position].locations
              nums!!.joinToString(",","","",-1,"")
              holder.location.text = nums.toString()
              holder.postDate.text = tempPostDate
          }
        }
        else if( items[position].location!=null){

            val inputDate = inputFormat.parse(items[position].postDate)
            val tempPostDate = outputOormat.format(inputDate)

            holder.location.text = items[position].location
            holder.postDate.text = tempPostDate
        }


        if(!items[position].companyLogo.isNullOrEmpty()) {

            Glide.with(context)
                .load(items[position].companyLogo)
                .into(holder.companyLogo)
        }
        else{
            holder.companyLogo.setImageResource(R.drawable.default_logo)
        }

        holder.cardView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(items[position].url))
            activity.startActivity(intent)
        }



//            Log.e("JobTitle:",items[position].toString())
//
//
//            val intent = Intent(activity, ExpandActivity::class.java)
//            intent.putExtra("c_logo",items[position].company_logo)
//            intent.putExtra("c_name",items[position].company)
//            intent.putExtra("job_title",items[position].title)
//            intent.putExtra("location",items[position].location)
//            intent.putExtra("post_date",items[position].created_at)
//            intent.putExtra("description",items[position].description)
//
//
//
//            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
//
//                Pair(holder.companyLogo,ViewCompat.getTransitionName(holder.companyLogo)),
//                Pair(holder.jobTitle,ViewCompat.getTransitionName(holder.jobTitle)),
//                Pair(holder.companyName,ViewCompat.getTransitionName(holder.companyName)),
//                Pair(holder.location,ViewCompat.getTransitionName(holder.location)),
//                Pair(holder.postDate,ViewCompat.getTransitionName(holder.postDate))
//
//                )
//
//            activity.startActivity(intent,options.toBundle())






    }



    override fun getItemCount(): Int {
        return items.size
        }





    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){



        val companyLogo = view.company_logo!!
        val jobTitle = view.job_title!!
        val companyName = view.company_name!!
        val location = view.location!!
        val postDate = view.post_date!!

        val cardView = view.job_item_cardView!!
    }
}


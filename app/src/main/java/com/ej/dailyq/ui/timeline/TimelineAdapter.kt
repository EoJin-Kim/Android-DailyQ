package com.ej.dailyq.ui.timeline

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.ej.dailyq.api.response.Question
import com.ej.dailyq.databinding.ItemTimelineCardBinding


class TimelineAdapter(val context: Context) :
    PagingDataAdapter<Question, TimelineCardViewHolder>(QuestionComparator) {

    object QuestionComparator: DiffUtil.ItemCallback<Question>() {
        override fun areItemsTheSame(
            oldItem: Question,
            newItem: Question
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Question,
            newItem: Question
        ): Boolean {
            return oldItem == newItem
        }
    }

    val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimelineCardViewHolder {
        return TimelineCardViewHolder(ItemTimelineCardBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: TimelineCardViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}

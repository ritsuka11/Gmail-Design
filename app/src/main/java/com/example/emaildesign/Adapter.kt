package com.example.emaildesign

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView

class Adapter(val items: ArrayList<Model>) : BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var itemView: View
        var viewHolder: ViewHolder
        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context).inflate(R.layout.item, parent, false)
            viewHolder = ViewHolder(itemView)
            itemView.tag = viewHolder
        } else {
            itemView = convertView
            viewHolder = itemView.tag as ViewHolder
        }

        viewHolder.mail.text = items[position].mail
        viewHolder.title.text = items[position].title
        viewHolder.avatar.text = items[position].mail.first().uppercase()
        viewHolder.time.text = items[position].time
        viewHolder.content.text = items[position].content
        viewHolder.checkBox.isChecked = items[position].selected

        viewHolder.title.ellipsize = android.text.TextUtils.TruncateAt.END
        viewHolder.content.ellipsize = android.text.TextUtils.TruncateAt.END

        if (items[position].selected) {
            viewHolder.checkBox.setButtonDrawable(android.R.drawable.btn_star_big_on)
        } else viewHolder.checkBox.setButtonDrawable(android.R.drawable.btn_star_big_off)

        viewHolder.checkBox.setOnClickListener {
            items[position].selected = !items[position].selected
            if (items[position].selected) {
                viewHolder.checkBox.setButtonDrawable(android.R.drawable.btn_star_big_on)
            } else viewHolder.checkBox.setButtonDrawable(android.R.drawable.btn_star_big_off)
            notifyDataSetChanged()
        }

        return itemView
    }

    class ViewHolder(itemView: View) {
        var mail: TextView
        var title: TextView
        var content: TextView
        var avatar: TextView
        var time: TextView
        var checkBox: CheckBox

        init {
            mail = itemView.findViewById(R.id.mail)
            title = itemView.findViewById(R.id.title)
            avatar = itemView.findViewById(R.id.textView)
            time = itemView.findViewById(R.id.time)
            content = itemView.findViewById(R.id.content)
            checkBox = itemView.findViewById(R.id.checkBox)
        }
    }
}

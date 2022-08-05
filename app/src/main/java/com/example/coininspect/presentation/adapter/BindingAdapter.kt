package com.example.coininspect.presentation

import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.Log
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlin.math.ceil

@BindingAdapter("app:spanCounts")
fun setSpanCount(v: RecyclerView, size: Int): Unit {
    v.setHasFixedSize(true)
    Log.e("TAG", "size:$size and row: ${size / 3} ");
    var span = ceil(size.toDouble().div(3)).toInt()
    if (span == 0) {
        span = 1
    }
    (v.layoutManager as StaggeredGridLayoutManager).spanCount = span
}

@BindingAdapter("app:underlineText")
fun setTextUnderline(v: TextView, text: String): Unit {
    val spannableString = SpannableString(text)
    spannableString.setSpan(UnderlineSpan(), 0, text.length, 0)
    v.text = spannableString

}
package com.yema.statisticspro.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yema.statisticspro.R

class ValueAdapter() : BaseQuickAdapter<Float, BaseViewHolder>(R.layout.item_main_list) {
    override fun convert(helper: BaseViewHolder?, item: Float?) {
        helper!!.setText(R.id.tv_name, item as String)

    }
}
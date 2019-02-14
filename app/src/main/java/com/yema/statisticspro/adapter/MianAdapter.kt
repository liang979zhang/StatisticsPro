package com.yema.statisticspro.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yema.statisticspro.MianModel
import com.yema.statisticspro.R

class MianAdapter() : BaseQuickAdapter<MianModel, BaseViewHolder>(R.layout.item_main_list)  {


    override fun convert(helper: BaseViewHolder?, item: MianModel?) {
        helper!!.setText(R.id.tv_name, item!!.name)
    }

}
package com.yema.statisticspro

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.dialog_chang_status.*

/**
 * 选择人员
 */
class ChangStatusDialog : Dialog {
    private var clickListenerInterface: ClickListenerInterface? = null

    constructor(context: Context) : super(context, R.style.dialog) {

    }

    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_chang_status)

        tv_num_add.setOnClickListener {
            if (!et_num.text.isEmpty()) {
                clickListenerInterface!!.valuedata(et_num.text.toString() as Float)
                dismiss()

            } else {
                Toast.makeText(context, "输入数据", Toast.LENGTH_SHORT).show()
            }

        }
    }


    fun setClicklistener(clickListenerInterface: ClickListenerInterface) {
        this.clickListenerInterface = clickListenerInterface
    }


    interface ClickListenerInterface {
        fun valuedata(value: Float)
    }

}

package com.yema.statisticspro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.yema.statisticspro.adapter.ValueAdapter
import kotlinx.android.synthetic.main.activity_value.*

class ValueActivity : AppCompatActivity() {

    private var countvalues = mutableListOf<Float>()

    lateinit var dialog: ChangStatusDialog
    lateinit var valueadapter: ValueAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_value)
        dialog = ChangStatusDialog(this)
        valueadapter = ValueAdapter()
        rl_value.layoutManager = LinearLayoutManager(this)
        rl_value.adapter = valueadapter


        ll_add_value.setOnClickListener {
            dialog.setClicklistener(object : ChangStatusDialog.ClickListenerInterface {
                override fun valuedata(value: Float) {

                }

            })
            dialog.show()


        }


        ll_value_1.setOnClickListener {


        }
    }
}

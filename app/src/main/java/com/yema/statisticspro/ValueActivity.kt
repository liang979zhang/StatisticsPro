package com.yema.statisticspro

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.yema.statisticspro.adapter.ValueAdapter
import kotlinx.android.synthetic.main.activity_value.*
import kotlin.concurrent.thread

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
                    countvalues.add(value)
                    valueadapter.setNewData(countvalues)

                }

            })
            dialog.show()


        }


        ll_value_1.setOnClickListener {
            dialog.setClicklistener(object : ChangStatusDialog.ClickListenerInterface {
                override fun valuedata(value: Float) {
                    tv_value_1.text = value.toString()
                }

            })
            dialog.show()

        }

        var count: Float = 0.0F
        var tempcount: Float

        ll_count.setOnClickListener {
            if (tv_value_1.text.isEmpty()) {
                Toast.makeText(this@ValueActivity, "没有设置除数", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val aas = tv_value_1.text.toString().toFloat()
            count = 0.0F
            tempcount = 0.0F
            thread {
                for (aa: Float in countvalues) {
                    tempcount = aa / aas
                    count += tempcount

                }
                runOnUiThread {
                    tv_count.text = count.toString()

                }
            }


        }
    }
}

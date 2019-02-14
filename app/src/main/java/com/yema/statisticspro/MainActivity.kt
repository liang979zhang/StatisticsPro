package com.yema.statisticspro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import com.maple.msdialog.AlertEditDialog
import com.yema.statisticspro.adapter.MianAdapter


class MainActivity : AppCompatActivity(), View.OnClickListener {

    var listvalue: MutableList<MianModel> = mutableListOf()
    lateinit var maainadap: MianAdapter
    override fun onClick(v: View?) {

        when (v!!.id) {
            R.id.fl_add -> {

                AlertEditDialog(this@MainActivity)
                        .setTitle("型号")

                        .setMessage("请输入型号")
                        .setLeftButton("取消", null)
                        .setRightButton("确定") {
                            listvalue.add(MianModel(listvalue.size + 1, it))
                            maainadap.setNewData(listvalue)
                        }
                        .show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fl_add.setOnClickListener(this)
        maainadap= MianAdapter()
        rl_mian_list.layoutManager = LinearLayoutManager(this)
        rl_mian_list.adapter = maainadap

        maainadap.setOnItemClickListener { adapter, view, position ->

            startActivity(Intent(this@MainActivity,ValueActivity::class.java))
        }


    }
}

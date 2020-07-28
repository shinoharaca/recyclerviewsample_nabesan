package com.websarva.wings.recyclerviewsample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.CollapsingToolbarLayout
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar  =findViewById<Toolbar>(R.id.toolbar)
        toolbar.setLogo(R.mipmap.ic_launcher)
        setSupportActionBar(toolbar)
        val toolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.toolbarLayout)
        toolbar.title = getString(R.string.toolbar_title)
        toolbarLayout.setExpandedTitleColor(Color.WHITE)
        toolbarLayout.setCollapsedTitleTextColor(Color.LTGRAY)


        val lvMenu = findViewById<RecyclerView>(R.id.lvMenu)
        val layout = LinearLayoutManager(applicationContext)
        lvMenu.layoutManager = layout

        val menuList = createTeishokuList()
        val adapter = RecyclerListAdapter(menuList)
        lvMenu.adapter = adapter

        val decorator = DividerItemDecoration(applicationContext, layout.orientation)
        lvMenu.addItemDecoration(decorator)

    }

    private fun createTeishokuList():MutableList<MutableMap<String,Any>> {

        val menuList: MutableList<MutableMap<String,Any>> = mutableListOf()

        var menu = mutableMapOf<String,Any>("name" to "唐揚げ定食", "price" to 800,
            "desc" to "若鳥の唐揚げにサラダ、ご飯と味噌汁がつきます")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ステーキ定食", "price" to 1000, "desc" to "国産牛のステーキにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "野菜炒め定食", "price" to 750, "desc" to "季節の野菜炒めにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "とんかつ定食", "price" to 900, "desc" to "ロースとんかつにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ミンチかつ定食", "price" to 850, "desc" to "手ごねミンチカツにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "チキンカツ定食", "price" to 900, "desc" to "ボリュームたっぷりチキンカツにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "コロッケ定食", "price" to 850, "desc" to "北海道ポテトコロッケにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "焼き魚定食", "price" to 850, "desc" to "鰆の塩焼きにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ステーキ定食", "price" to 1000, "desc" to "国産牛のステーキにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "野菜炒め定食", "price" to 750, "desc" to "季節の野菜炒めにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "とんかつ定食", "price" to 900, "desc" to "ロースとんかつにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ミンチかつ定食", "price" to 850, "desc" to "手ごねミンチカツにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "チキンカツ定食", "price" to 900, "desc" to "ボリュームたっぷりチキンカツにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "コロッケ定食", "price" to 850, "desc" to "北海道ポテトコロッケにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "焼き魚定食", "price" to 850, "desc" to "鰆の塩焼きにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "焼肉定食", "price" to 950, "desc" to "特性たれの焼肉にサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        return menuList
    }

    /**
     * RecyclerViewのビューホルダクラス。
     */
        private inner class RecyclerListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvMenuName : TextView
        var tvMenuPrice : TextView

        init {
            //引数で渡されたリスト1行分の画面部品中から表示に使われるTextViewを取得。
            tvMenuName = itemView.findViewById(R.id.tvMenuName)
            tvMenuPrice = itemView.findViewById(R.id.tvMenuPrice)
        }

    }

    /**
     * RecyclerViewのアダプタクラス。
     */
    private inner class RecyclerListAdapter(private val _listData: MutableList<MutableMap<String,Any>>)
        : RecyclerView.Adapter<RecyclerListViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerListViewHolder {
            val inflater = LayoutInflater.from(applicationContext)
            //row.xmlをインフレートし、1行分の画面部品とする。
            val view = inflater.inflate(R.layout.row, parent, false)
            //インフレートされた1行分の画面部品にリスナを設定。
            view.setOnClickListener(ItemClickListener())
            //ビューホルダオブジェクトを生成。
            val holder = RecyclerListViewHolder(view)
            //生成したビューホルダをリターン。
            return holder
        }

        override fun onBindViewHolder(holder: RecyclerListViewHolder, position: Int) {
            val item = _listData[position]
            val menuName = item["name"] as String
            val menuPrice = item["price"] as Int
            val menuPriceStr = menuPrice.toString()

            holder.tvMenuName.text = menuName
            holder.tvMenuPrice.text = menuPriceStr
        }

        override fun getItemCount():Int{
            return _listData.size
        }
    }

    private inner class ItemClickListener: View.OnClickListener {
        override fun onClick(p0: View) {
            val tvMenuName = p0.findViewById<TextView>(R.id.tvMenuName)
            val menuName = tvMenuName.text.toString()

            val msg = getString(R.string.msg_header) + menuName
            Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
        }

    }

}
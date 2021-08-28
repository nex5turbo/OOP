package won.young.oop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.remotemonster.sdk.RemonCall

class RoomActivity : AppCompatActivity() {
    var remonCall: RemonCall? = null
    var roomList = ArrayList<RoomData>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RoomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        recyclerView = findViewById(R.id.recyclerView)

        remonCall = RemonService.getInstance(applicationContext)
        remonCall!!.fetchCalls()
        remonCall!!.onFetch{rooms->
            Log.d("###", "${rooms.size}")
            for (room in rooms) {
                val roomName = room.name
                val roomData = RoomData(roomName)
                roomList.add(roomData)
            }
            adapter = RoomAdapter(roomList)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)
        }


    }
}
package won.young.oop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RoomAdapter(val roomList: ArrayList<RoomData>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.room_item, parent, false)

        return CustomHolder(view)
    }

    override fun getItemCount(): Int = roomList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val roomName = holder.itemView.findViewById<TextView>(R.id.roomName)
        roomName.text = roomList[position].roomName
    }

    inner class CustomHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
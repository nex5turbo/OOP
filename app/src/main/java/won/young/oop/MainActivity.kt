package won.young.oop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.remotemonster.sdk.RemonCall
import org.webrtc.SurfaceViewRenderer
import won.young.oop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil
            .setContentView(this, R.layout.activity_main)

        binding.randomCallButton.setOnClickListener {
            val intent = Intent(this, VideoCallActivity::class.java)
            startActivity(intent)
        }

        binding.roomCallButton.setOnClickListener {
            val intent = Intent(this, RoomActivity::class.java)
            startActivity(intent)
        }

    }


}

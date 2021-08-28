package won.young.oop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.remotemonster.sdk.RemonCall

class VideoCallActivity : AppCompatActivity() {
    var remonCall: RemonCall? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_call)
        if (remonCall == null) {
            remonCall = RemonCall.builder()
                .context(this)
                .localView(findViewById(R.id.local_video_view))
                .remoteView(findViewById(R.id.remote_video_view))
                .serviceId("37d3a76e-dc4b-4ac6-b6b3-a3b529e222bb")
                .key("e0eaa51f17d3c712361155b941724b2c0d5f1983d5793cefddb8ec53d5f4afb5")
                .build()
        }
        remonCall!!.connect("testChannel")
        findViewById<Button>(R.id.button).setOnClickListener {
            if (remonCall != null) {
                remonCall!!.switchCamera()
            }
        }
        findViewById<Button>(R.id.closeButton).setOnClickListener {
            if (remonCall != null) {
                remonCall!!.close()
                remonCall = null
            }
        }
    }

    override fun onPause() {
        if (remonCall != null) {
            remonCall!!.close()
            remonCall = null
        }
        super.onPause()
    }
}
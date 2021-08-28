package won.young.oop

import android.content.Context
import com.remotemonster.sdk.RemonCall

object RemonService {
    var remonCall: RemonCall? = null

    fun getInstance(context: Context): RemonCall? {
        if (remonCall == null) {
            remonCall = RemonCall.builder()
                .context(context)
                .serviceId("37d3a76e-dc4b-4ac6-b6b3-a3b529e222bb")
                .key("e0eaa51f17d3c712361155b941724b2c0d5f1983d5793cefddb8ec53d5f4afb5")
                .build()
        }
        return remonCall
    }
}
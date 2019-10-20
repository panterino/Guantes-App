package panterino.guantes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnEntrar.setOnClickListener{
            val pantalla2 = Intent(this, Inicio::class.java)
            startActivity(pantalla2)
        }
    }
}

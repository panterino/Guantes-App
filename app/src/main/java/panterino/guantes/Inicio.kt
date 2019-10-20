package panterino.guantes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_inicio.*
import android.R.attr.fragment
import android.text.TextUtils.replace
import androidx.core.view.OneShotPreDrawListener.add
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


class Inicio : AppCompatActivity() {

    val inicioF = InicioFragmento()
    val juegosF = JuegosFragmento();
    val calendarioF = CalendarioFragmento();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        addFragmentToActivity(getSupportFragmentManager(), inicioF, R.id.contenedor_principal)
        nav_principal.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.nav_inicio -> {
                    replaceFragment(inicioF,R.id.contenedor_principal)
                }
                R.id.nav_juegos -> {
                    replaceFragment(juegosF,R.id.contenedor_principal)
                }
                R.id.nav_calendario -> {
                    replaceFragment(calendarioF,R.id.contenedor_principal)
                }

            }
            return@setOnNavigationItemSelectedListener true
        }
    }
    fun addFragmentToActivity(manager: FragmentManager, fragment: Fragment, frameId: Int) {
        val transaction = manager.beginTransaction()
        transaction.add(frameId, fragment)
        transaction.commit()

    }

    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.commit()
    }

    fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.inTransaction{replace(frameId, fragment)}
    }
}

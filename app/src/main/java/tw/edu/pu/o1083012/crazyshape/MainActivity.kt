package tw.edu.pu.o1083012.crazyshape

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.disklrucache.DiskLruCache
import com.bumptech.glide.module.AppGlideModule
import kotlinx.android.synthetic.main.activity_main.*

@GlideModule
public final class MyAppGlideModule : AppGlideModule()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shape = intArrayOf(R.drawable.circle, R.drawable.square,R.drawable.triangle, R.drawable.star)
        val i:Int = (0..3).random()
        imgNext.setImageResource(shape[i])

        val img: ImageView = findViewById(R.id.imgTitle)
        GlideApp.with(this)
            .load(R.drawable.cover)
            .override(800,600)
            .into(img)


        imgNext.setOnLongClickListener(object: View.OnLongClickListener {
            override fun onLongClick(p0: View): Boolean {
                intent = Intent(this@MainActivity, GameActivity::class.java).apply {
                    if (shape[i] == 0) {
                        putExtra("circle", "Please draw a circle,star,triangle")
                    }
                }

                Toast.makeText(baseContext, "作者：韓婉晶", Toast.LENGTH_LONG).show()
                imgNext.setOnLongClickListener(object : View.OnLongClickListener {
                    override fun onLongClick(p0: View): Boolean {
                        intent = Intent(this@MainActivity,GameActivity::class.java).apply{
                            if (shape[i]==0){
                                putExtra("shapenumber",0)
                            }

                            else if (shape[i]==1){
                                putExtra("shapenumber",1)
                            }

                            else if (shape[i]==2){
                                putExtra("shapenumber",2)
                            }

                            else if (shape[i]==3){
                                putExtra("shapenumber",3)
                            }
                        }
                        startActivity(intent)
                        recreate()


                        return true
                    }
                })
                return true
            }
        })
    }
}
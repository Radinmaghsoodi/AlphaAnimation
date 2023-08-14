package ir.radindev.alphaanimation

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import ir.radindev.alphaanimation.databinding.ActivityMain2Binding
import ir.radindev.alphaanimation.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAnim.setOnClickListener {
            binding.jsonAnim.playAnimation()
            //binding.jsonAnim.progress=0.5f

            //binding.jsonAnim.playAnimation()

        }
        binding.jsonAnim.addAnimatorListener(object :Animator.AnimatorListener{
            override fun onAnimationStart(p0: Animator) {

            }

            override fun onAnimationEnd(p0: Animator) {

            }

            override fun onAnimationCancel(p0: Animator) {

            }

            override fun onAnimationRepeat(p0: Animator) {

            }
        })

    }
}
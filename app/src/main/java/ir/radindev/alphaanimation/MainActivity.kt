package ir.radindev.alphaanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import ir.radindev.alphaanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Alpha Animation =>
        binding.btnAnim.setOnClickListener {
//            alphaAnimation()
//            scaleAnimation()
//            translateAnimation()
//              rotateAnimation()
            useMultipleAnimation()
//               useAnimFromXml()
        }
    }

    private fun alphaAnimation() {
        val anim= AlphaAnimation(1f,0f)

        // for all animations =>
        anim.duration = 2000
        anim.fillAfter = true
        anim.repeatCount = 3
        anim.repeatMode = Animation.REVERSE
        anim.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                Log.v("testAnimation", "anim start")
            }

            override fun onAnimationEnd(p0: Animation?) {
                Log.v("testAnimation", "anim ended")
            }

            override fun onAnimationRepeat(p0: Animation?) {
                Log.v("testAnimation", "anim repeated")
            }

        })
        // ----------------------------------------------------------------

        binding.imgAnim.startAnimation(anim)
    }

    private fun translateAnimation(){

        val anim = TranslateAnimation(
            0f,0f,
            0f,1400f
        )
        anim.duration=2000
        anim.fillAfter=true
        anim.interpolator = AccelerateDecelerateInterpolator()
//            AccelerateInterpolator()
//            DecelerateInterpolator()



        binding.imgAnim.startAnimation(anim)

    }
//----------------------------------------------------------

    private fun scaleAnimation():ScaleAnimation {
        val anim1= ScaleAnimation(
            1f,2f,1f,2f
        )
        anim1.duration=2000
        anim1.fillAfter=true
        //------------------------------
        val anim2=ScaleAnimation(
            1f,2f,1f,2f,
            Animation.RELATIVE_TO_SELF,0.5f,
            Animation.RELATIVE_TO_SELF,0.5f
        )
        anim2.duration=3000
        anim2.fillAfter=true

        return anim2
    }

    private fun rotateAnimation():RotateAnimation{

        val anim1= RotateAnimation(0f,360f)
        anim1.duration=2000
        anim1.fillAfter=true
        anim1.repeatCount=10
        //-----------------------------------------

        val anim2=RotateAnimation(0f,360f,
             Animation.RELATIVE_TO_SELF,0.5f
            ,Animation.RELATIVE_TO_SELF,0.5f)
        anim1.duration=2000
        anim1.fillAfter=true
        anim1.repeatCount=10
        return anim2
    }

    private fun useMultipleAnimation(){

        val animSet=AnimationSet(true)
        animSet.addAnimation(rotateAnimation())
        animSet.addAnimation(scaleAnimation())

        animSet.duration=4000
        animSet.fillAfter=true
        animSet.repeatCount=5

        binding.imgAnim.startAnimation(animSet)

    }


    private fun useAnimFromXml(){
        val anim= AnimationUtils.loadAnimation(this,R.anim.anim_alpha)
        anim.fillAfter=true
        binding.imgAnim.startAnimation(anim)
    }

}
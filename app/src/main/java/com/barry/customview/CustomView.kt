package com.barry.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlin.random.Random

class CustomView : View {
    private  val TOUCH_SCALE_FACTOR: Float = 180.0f / 320f
    constructor(context: Context):this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs){
        init()
    }
    lateinit var mCircle :MagicCirle
    private var mPaint = Paint()

    //private var circles : List(6){MagicCirle(Random.nextInt(0, 10),Random.nextInt(0, 10) )}
    //var circles: Array(6, { i: Int -> MagicCircle(i, i) })
    var circles = Array(6, { i: Int -> MagicCirle(Random.nextInt(60,70 ), Random.nextInt(60, 70) ) })
    private fun init(){
        mPaint = Paint().apply {
            style = Paint.Style.STROKE
            strokeWidth = 10F


        }
        /*
        mCircle = MagicCirle(50 ,50)
        mPaint = Paint()
        mPaint.color = mCircle.mColor*/
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bot: Int) {
        super.onLayout(changed, left, top, right, bot)
        //mCircle = MagicCirle(width, height)
        circles.forEach { item-> run { mCircle = MagicCirle(width, height) } }
        circles.forEach { item-> Log.i(CustomView::class.simpleName, item.toString()) }
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //canvas?.drawCircle(50F, 50F, 40F, Paint())
        //mCircle.move()
        //canvas?.drawCircle(mCircle.cx, mCircle.cy, mCircle.rad, Paint())
        //canvas?.drawCircle(mCircle.cx, mCircle.cy, mCircle.rad, mPaint)
        //with(mCircle){
            //move()
            circles.forEach { item->
                item.move()
                    mPaint.color = item.mColor
                    canvas?.drawCircle(item.cx, item.cy, item.rad, mPaint)
            }
           // mPaint.color = mColor
           // canvas?.drawCircle(cx, cy, rad, mPaint)
        //}

        invalidate()
    }
/*
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
        when (event.action) {
            MotionEvent.ACTION_MOVE -> {



                // reverse direction of rotation above the mid-line
                if (y > height / 2) {
                    dx *= -1
                }

                // reverse direction of rotation to left of the mid-line
                if (x < width / 2) {
                    dy *= -1
                }

                renderer.angle += (dx + dy) * TOUCH_SCALE_FACTOR
                requestRender()
            }
        }
    }*/


}
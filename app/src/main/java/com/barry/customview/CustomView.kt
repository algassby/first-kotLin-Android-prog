package com.barry.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomView : View {

    constructor(context: Context):this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs){
        init()
    }
    lateinit var mCircle :MagicCirle
    private var mPaint = Paint()

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
        mCircle = MagicCirle(width, height)
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //canvas?.drawCircle(50F, 50F, 40F, Paint())
        //mCircle.move()
        //canvas?.drawCircle(mCircle.cx, mCircle.cy, mCircle.rad, Paint())
        //canvas?.drawCircle(mCircle.cx, mCircle.cy, mCircle.rad, mPaint)
        with(mCircle){
            move()
            mPaint.color = mColor;
            canvas?.drawCircle(cx, cy, rad, mPaint)
        }

        invalidate()
    }


}
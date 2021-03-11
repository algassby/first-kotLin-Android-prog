package com.barry.customview

import kotlin.math.roundToInt

data class MagicCirle(val maxX: Int, val maxY: Int){

    var dx = DELTA
    var dy = DELTA
    var cx = 50F
    var cy = 50F
    val rad = 40F
    val mColor = App.sColors[App.sColors.indices.random()]
    companion object{
        val DELTA = 9;
    }
    fun move(){
        when{
            cx.roundToInt()!in 0..maxX->dx =-dx
            cy.roundToInt()!in 0..maxY->dy =-dy
        }
        cx+= dx
        cy+= dy
    }

}


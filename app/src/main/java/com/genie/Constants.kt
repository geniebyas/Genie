package com.genie

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.io.ByteArrayOutputStream

class Constants {
    fun encodeImage(bitmap: Bitmap):String{
        var pwidth = bitmap.width
        var pheight = bitmap.height
        var pbitmap = Bitmap.createScaledBitmap(bitmap,pwidth,pheight,false)
        var byteArrayOutputStream = ByteArrayOutputStream()
        pbitmap.compress(Bitmap.CompressFormat.JPEG,80,byteArrayOutputStream)
        var bytes=byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(bytes, Base64.DEFAULT)
    }
    fun decodeImage(postimg:String): Bitmap {
        var bytes = Base64.decode(postimg, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(bytes,0,bytes.size)
    }
}
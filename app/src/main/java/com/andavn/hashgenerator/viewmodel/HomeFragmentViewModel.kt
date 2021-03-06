package com.andavn.hashgenerator.viewmodel

import androidx.lifecycle.ViewModel
import java.security.MessageDigest

class HomeFragmentViewModel :ViewModel() {

   fun getHashCode(plainText : String , algorithm : String): String {

      val byteArray = MessageDigest.getInstance(algorithm).digest(plainText.toByteArray())
      return toHex(byteArray)
  }
    private fun toHex(byteArray: ByteArray): String{

        return byteArray.joinToString("") { "%x".format(it) }
    }
}
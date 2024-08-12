object CaesarCipher {

  def caesarEncrypt(plaintext: String, shift: Int): String = {
    plaintext.map { char =>
      if (char.isLetter) {
        val shiftBase = if (char.isUpper) 'A' else 'a'
        ((char - shiftBase + shift) % 26 + shiftBase).toChar
      } else {
        char
      }
    }
  }


  def caesarDecrypt(ciphertext: String, shift: Int): String = {
    caesarEncrypt(ciphertext, -shift)
  }


  def cipher(func: (String, Int) => String, text: String, shift: Int): String = {
    func(text, shift)
  }


  def main(args: Array[String]): Unit = {
    
    val plaintext = "Hello, World!"
    val shift = 3


    val encryptedText = cipher(caesarEncrypt, plaintext, shift)
    println(s"Encrypted Text: $encryptedText")


    val decryptedText = cipher(caesarDecrypt, encryptedText, shift)
    println(s"Decrypted Text: $decryptedText")
  }
}

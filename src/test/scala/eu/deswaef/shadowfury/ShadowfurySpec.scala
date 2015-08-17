package eu.deswaef.shadowfury

import org.scalatest._

/**
 * Created by QuintenDes on 15/08/15.
 */
abstract class ShadowfurySpec extends FlatSpec with Matchers with OptionValues with Inside with Inspectors{

  val defaultTextEncoding : String = "UTF-8"

  implicit def strToUTF8ByteArray(toByteArray: String) : Array[Byte] = {
    toByteArray.getBytes(defaultTextEncoding)
  }
}

package hackerRank.common.util

import com.fasterxml.jackson.databind.{DeserializationFeature, MapperFeature, ObjectMapper, SerializationFeature}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

object JsonUtil {
  val mapper = new ObjectMapper() with ScalaObjectMapper
  mapper.registerModule(DefaultScalaModule)
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
      //.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false)
      .configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true)
      .configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)

  def toJson(value: Map[Symbol, Any]): String = {
    toJson(value map { case (k,v) => k.name -> v})
  }

  def toJson(value: Any): String = {
    mapper.writeValueAsString(value)
  }

  def toJson(value: Any, pretty: Boolean): String = {
    if (pretty) {
      mapper.writerWithDefaultPrettyPrinter.writeValueAsString(value)
    } else {
      mapper.writeValueAsString(value)
    }
  }

  def toMap[V](json:String)(implicit m: Manifest[V]) = fromJson[Map[String,V]](json)

  def fromJson[T](json: String)(implicit m : Manifest[T]): T = {
    mapper.readValue[T](json)
  }

  // for test
  def main(args: Array[String]): Unit = {
    val text = """{"view_mode":"app","useHeader":"AG,MN,CO","launch_path":"none","permanent":"9c8eb8ba-f9cc-4be1-9638-80a3b7ea784d","version":"5.1.8","buyType":"NORMAL","_arg2":"2511945762","session":"c19db8f7-403d-4e93-aaab-5b96ab1ce711","ad_id":"7c97876e-5ad8-422f-8446-4db199d02638","selectedId":"a976416c-570b-4374-82b0-ead75fe1c72c","platform":"ad","_arg1":"checkout","app_os":"ad"}"""
    println(JsonUtil.toJson(JsonUtil.toMap[Object](text), true))
  }
}
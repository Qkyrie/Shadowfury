package eu.deswaef.shadowfury

import akka.actor.ActorSystem
import eu.deswaef.shadowfury.request.GetRequest
import eu.deswaef.shadowfury.response.HttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder

import scala.async.Async.async
import scala.concurrent.ExecutionContext.Implicits._
import scala.concurrent.Future
class ShadowfuryHttpClient extends HttpClient {

  override def get(url: String): GetRequest = GetRequest(url){
      getRestContent(url)
  }

  def getRestContent(url:String):  Future[HttpResponse] = {
    async {
      val httpClient = HttpClientBuilder.create build
      val httpResponse = httpClient.execute(new HttpGet(url))
      val entity = httpResponse.getEntity

      println(entity.getContentLength)
      println(entity.getContentType)
      println(httpResponse.getStatusLine.getStatusCode)
      var content = ""
      if (entity != null) {
        val inputStream = entity.getContent
        content = io.Source.fromInputStream(inputStream).getLines.mkString
        inputStream.close()
      }
      httpClient.getConnectionManager().shutdown()
      new HttpResponse(content)
    }
  }

}

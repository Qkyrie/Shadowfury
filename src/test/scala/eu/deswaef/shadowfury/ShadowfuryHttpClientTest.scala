package eu.deswaef.shadowfury

import eu.deswaef.shadowfury.request.GetRequest
import eu.deswaef.shadowfury.response.HttpResponse

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success, Try}

class ShadowfuryHttpClientTest extends ShadowfurySpec {


  "getRequest" should "return a result" in {

    val client: ShadowfuryHttpClient = new ShadowfuryHttpClient

    val request: GetRequest = client.get("https://facebook.com")

    val triedResponse1: Try[HttpResponse] = Await.ready(request.apply, Duration.Inf).value.get

    triedResponse1 match {
      case Success(t) => println(t.content)
      case Failure(e) => e.printStackTrace
      case default => println(default)
    }
  }

}

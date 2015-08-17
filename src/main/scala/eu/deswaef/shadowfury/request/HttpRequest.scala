package eu.deswaef.shadowfury.request

import eu.deswaef.shadowfury.response.HttpResponse

import scala.concurrent.Future

trait HttpRequest {

  def url: String

  def apply: Future[HttpResponse]

}

trait GetRequest extends HttpRequest

object GetRequest {
  def apply(u: String)
           (async: => Future[HttpResponse]) : GetRequest = new GetRequest {
    override def url: String = u
    override def apply: Future[HttpResponse] = async
  }
}

package eu.deswaef.shadowfury

import eu.deswaef.shadowfury.request.GetRequest

trait HttpClient {
  def get(url: String) : GetRequest
}

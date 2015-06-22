import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._
import play.mvc.Results

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends Specification {

  "Application" should {

    "send 404 on a bad request" in new WithApplication{
      route(FakeRequest(GET, "/boum")) must beNone
    }

    "redirects to list page" in new WithApplication{
      val home = route(FakeRequest(GET, "/")).get

      status(home) must equalTo(303)
//      contentType(home) must beSome.which(_ == "text/html")
//      contentAsString(home) must contain ("Paperclips Giant")
    }


  }
}

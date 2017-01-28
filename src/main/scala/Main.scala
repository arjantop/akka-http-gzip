import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import akka.http.scaladsl.server.Directives._

object Main extends App {
  implicit val system = ActorSystem()
  implicit val executor = system.dispatcher
  implicit val materializer = ActorMaterializer()

  private val textLarge =
    """
      |Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam odio sem, fermentum sed laoreet vel, placerat ac augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Pellentesque in volutpat lorem. Phasellus eu sodales erat. Proin auctor leo ac eros elementum, sed feugiat nunc finibus. Pellentesque quis nulla luctus, ultricies velit id, aliquam neque. Mauris sem tellus, feugiat id dolor a, eleifend ultrices risus. Etiam nisl nisi, pellentesque vel nulla et, maximus interdum ligula. Quisque sit amet pretium risus, a rutrum arcu. Ut fermentum velit ut finibus commodo. Etiam tincidunt cursus pretium.
      |Duis tortor elit, pretium fringilla porta et, finibus eu risus. Fusce felis dolor, maximus nec enim quis, convallis dapibus ante. Fusce congue, eros molestie aliquam faucibus, turpis dolor maximus dolor, sit amet posuere elit odio ac quam. Vivamus semper aliquam diam in auctor. Suspendisse non velit luctus massa vulputate maximus. Morbi egestas sagittis neque vitae pharetra. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vestibulum quis pellentesque ligula. Maecenas nec fringilla lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel metus magna. Maecenas velit orci, commodo viverra risus in, iaculis blandit nulla.
      |Aliquam pellentesque augue nulla, nec luctus elit pretium vitae. Phasellus vehicula leo tempus lectus iaculis ultrices. Phasellus elementum ornare rutrum. Donec eleifend porta magna, eu porta mi lacinia vel. Fusce vulputate elit quis dictum gravida. Praesent ullamcorper lectus libero, laoreet fermentum nisl iaculis vitae. Aliquam a luctus enim.
      |Nullam non turpis fermentum, pellentesque lectus vel, molestie risus. Ut id quam fermentum, lobortis lacus a, mollis leo. Donec cursus quam eu congue interdum. Ut in vestibulum mi. Mauris magna velit, aliquet sed ante eget, condimentum mollis dui. Nullam quis elit mattis, luctus felis nec, accumsan lorem. Nulla porttitor purus a nisl interdum mattis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse potenti. Vestibulum dignissim nibh arcu, a rutrum risus ultrices non.
      |Phasellus maximus rhoncus porttitor. Donec rutrum magna a ante vestibulum, sit amet accumsan felis gravida. Vestibulum mattis sapien nibh, in suscipit justo dignissim a. Pellentesque venenatis sit amet turpis sed hendrerit. Maecenas gravida velit mi, pharetra tincidunt quam varius eu. Vivamus ullamcorper porttitor sapien quis tincidunt. In condimentum, leo sed facilisis tincidunt, nisi nulla cursus nisl, et tempor nisi tortor at augue. Suspendisse id semper turpis.
      |Praesent sed efficitur tellus. Praesent consectetur pretium lectus a convallis. Nullam non diam vitae neque facilisis venenatis. Phasellus id bibendum enim. Duis fermentum feugiat aliquet. Quisque ac odio fermentum, viverra ipsum sed, feugiat felis. In vestibulum posuere eros, id mollis lorem tempus non. Vestibulum sem orci, cursus et tellus non, convallis cursus magna.
      |Integer porttitor fringilla sapien at dignissim. Nulla ac pulvinar dui. Nullam maximus purus quis mauris porta ullamcorper. Curabitur mattis mauris vel tristique porta. Nulla facilisi. Ut rutrum ornare lectus sit amet bibendum. Aenean condimentum lacinia nisl, in porttitor erat rutrum eget. Ut sed turpis varius, aliquet mi quis, placerat ligula. Curabitur imperdiet lacinia est, vel imperdiet est aliquet vitae. Proin et ipsum non urna elementum fermentum quis sit amet justo. Praesent varius massa sed velit vulputate, eget malesuada libero euismod. Proin rhoncus est vel urna fringilla, eget vehicula velit accumsan. Sed urna neque, molestie nec ex in, dignissim accumsan turpis. Nam porttitor lorem dui, nec tristique est facilisis ac. Etiam commodo dolor nec accumsan lacinia.
      |Donec eu lacus ac urna eleifend luctus id at lacus. Integer nec convallis ipsum. Pellentesque et bibendum nunc. Praesent consectetur felis lorem, sit amet tincidunt dolor blandit sit amet. Vestibulum non blandit magna, imperdiet interdum nisi. Curabitur eget lacinia tellus, id lobortis odio. In hac habitasse platea dictumst. Etiam hendrerit risus dolor, consequat condimentum magna finibus sed. Fusce nec arcu in massa auctor luctus sit amet id sapien. Morbi hendrerit cursus ullamcorper. Cras at porta nibh. Mauris pharetra ac est a sodales. Ut sed nulla at velit placerat tempor. Sed id nisi mi. Sed ac urna quis ligula maximus rhoncus.
      |Phasellus sit amet lectus ut ex posuere sodales. Donec ac est ac massa mattis mattis non nec libero. Duis malesuada porttitor nulla, vel ornare eros scelerisque nec. Donec porta, orci ac cursus aliquam, lectus nulla ullamcorper nibh, eget fermentum lacus tortor nec ex. Maecenas leo lorem, commodo at justo ut, placerat molestie mauris. In vel cursus mi. Etiam in lacinia enim. Proin at congue ligula. Curabitur elementum, turpis venenatis vulputate fringilla, nisi ipsum malesuada felis, in posuere elit lectus nec ligula. Nulla gravida lacus ut tellus varius, vitae accumsan massa aenean suscipit.
    """.stripMargin

  private val textSmall = "Hello world"

  val root = path("large") {
    get {
      encodeResponse {
        complete(textLarge)
      }
    }
  } ~ path("small") {
    get {
      encodeResponse {
        complete(textSmall)
      }
    }
  }

  Http().bindAndHandle(root, "localhost", 8888)
}

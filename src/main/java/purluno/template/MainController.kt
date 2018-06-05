package purluno.template

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import java.time.ZonedDateTime

@Controller
open class MainController {

    @RequestMapping("/")
    open fun root(model: Model): String {
        model.addAttribute("now", ZonedDateTime.now())
        return "root"
    }
}

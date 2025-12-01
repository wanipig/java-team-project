package kr.ac.ewha.java2.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	@GetMapping
    public String showIndex() {
        return "index_form"; // templates/index_form.html 파일을 찾아 반환합니다.
    }
}

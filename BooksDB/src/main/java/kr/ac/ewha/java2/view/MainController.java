package kr.ac.ewha.java2.view;

import kr.ac.ewha.java2.create.dto.BookCreateRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/books/create")
    public String showCreateForm(Model model) {
        // 이미 RedirectAttributes 등으로 값이 들어온 경우를 방지
        if (!model.containsAttribute("bookCreateRequest")) {
            model.addAttribute("bookCreateRequest", new BookCreateRequest());
        }
        return "create";
    }

    @GetMapping("/books")
    public String showBookListPage() {
        return "list";
    }

    @GetMapping("/books/search")
    public String showSearchPage(Model model) {
        if (!model.containsAttribute("keyword")) {
            model.addAttribute("keyword", "");
        }
        return "search";
    }

    @GetMapping("/books/delete")
    public String showDeletePage(Model model) {
        if (!model.containsAttribute("targetIsbn")) {
            model.addAttribute("targetIsbn", "");
        }
        return "delete";
    }
}

package kr.ac.ewha.java2.read.controller;

import kr.ac.ewha.java2.read.service.BookReadService;
import kr.ac.ewha.java2.read.dto.BookResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookReadController {

    private final BookReadService bookReadService;

    public BookReadController(BookReadService bookReadService) {
        this.bookReadService = bookReadService;
    }

    // 전체 조회
    @GetMapping
    public String getAllBooks(Model model) {
        List<BookResponse> books = bookReadService.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("DEBUG: 조회된 책 데이터가 비어 있습니다.");
        }
        model.addAttribute("books", books);
        return "list"; // templates/list.html
    }

    // 검색 조회
    @GetMapping("/search")
    public String searchBooks(@RequestParam("keyword") String keyword, Model model) {
        List<BookResponse> books = bookReadService.searchBooks(keyword);
        model.addAttribute("books", books);
        model.addAttribute("keyword", keyword);
        return "search"; // templates/search.html
    }

}

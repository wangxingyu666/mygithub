package top.wangxingyu.springboot.quick.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wangxingyu.springboot.quick.dto.BookDTO;
import top.wangxingyu.springboot.quick.service.BookService;


import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Resource
    private BookService bookService;

    @GetMapping()
    public List<BookDTO> getbooks(){
        return bookService.getAllBooks();
    }
}

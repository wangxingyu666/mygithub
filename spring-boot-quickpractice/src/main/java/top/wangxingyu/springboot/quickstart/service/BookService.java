package top.wangxingyu.springboot.quickstart.service;

import org.springframework.stereotype.Service;
import top.wangxingyu.springboot.quickstart.dto.BookDTO;

import java.util.List;

@Service
public class BookService {
    public List<BookDTO> getAllBooks(){
        return List.of(
                new BookDTO(1L,"Java Programming","Alice",29.99),
                new BookDTO(2L,"Spring Boot Action","Bob",39.99)
        );
    }
}

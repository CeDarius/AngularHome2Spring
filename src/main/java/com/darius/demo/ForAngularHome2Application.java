package com.darius.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ForAngularHome2Application {

    public static void main(String[] args) {
        SpringApplication.run(ForAngularHome2Application.class, args);
    }
}

@RestController
@RequestMapping("/api/v1/home")
//@CrossOrigin(origins = "http://localhost:8081")
@CrossOrigin(origins = "*", maxAge = 3600)
class BookController {

    private List<Book> books = new ArrayList<>() {{
        add(new Book(1, "Orson Scott", "Enders game", 15.0));
        add(new Book(2, "Orson Scott2", "Enders game2", 15.2));
    }};

    @GetMapping("")
    public List<Book> getAllBooks() {
        return books;
    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Book {
    private Integer id;
    private String author;
    private String title;
    private Double price;
}



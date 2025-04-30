package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Libros", description = "Operaciones para gestionar la biblioteca")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Operation(summary = "Obtener todos los libros", description = "Regresa todos los libros")
    @ApiResponse(responseCode = "200", description = "Libros obtenidos correctamente")
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Operation(summary = "Obtener un libro por ID", description = "Busca un libro con su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Libro encontrado"),
        @ApiResponse(responseCode = "404", description = "Libro no encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(
            @Parameter(description = "ID del libro a buscar", required = true)
            @PathVariable Long id) {
        return bookRepository.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un libro", description = "Crea un nuevo libro")
    @ApiResponse(responseCode = "200", description = "Libro creado")
    @SecurityRequirement(name = "bearerAuth")
    @PostMapping
    public Book createBook(
            @Parameter(description = "Objeto libro que se quiere guardar", required = true)
            @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @Operation(summary = "Actualizar un libro", description = "Actualiza la informacion de un libro con su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Libro actualizado"),
        @ApiResponse(responseCode = "404", description = "Libro no encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(
            @Parameter(description = "ID del libro a actualizar", required = true)
            @PathVariable Long id,
            @Parameter(description = "Nuevos datos del libro", required = true)
            @RequestBody Book bookDetails) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(bookDetails.getTitle());
                    book.setAuthor(bookDetails.getAuthor());
                    book.setIsbn(bookDetails.getIsbn());
                    book.setPublicationYear(bookDetails.getPublicationYear());
                    book.setGenre(bookDetails.getGenre());
                    book.setPages(bookDetails.getPages());
                    Book updatedBook = bookRepository.save(book);
                    return ResponseEntity.ok(updatedBook);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar un libro", description = "Elimina un libro por su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Libro eliminado"),
        @ApiResponse(responseCode = "404", description = "Libro no encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(
            @Parameter(description = "ID del libro a eliminar", required = true)
            @PathVariable Long id) {
        return bookRepository.findById(id)
                .map(book -> {
                    bookRepository.delete(book);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

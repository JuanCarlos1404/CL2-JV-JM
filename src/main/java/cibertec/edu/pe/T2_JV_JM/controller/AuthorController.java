package cibertec.edu.pe.T2_JV_JM.controller;

import cibertec.edu.pe.T2_JV_JM.dto.AuthorDto;
import cibertec.edu.pe.T2_JV_JM.dto.GenericResponseDto;
import cibertec.edu.pe.T2_JV_JM.model.Author;
import cibertec.edu.pe.T2_JV_JM.service.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final IAuthorService authorService;

    @PostMapping
    public ResponseEntity<GenericResponseDto<String>> seveAuthor(@RequestBody Author authorDto) {
        try {
            authorService.saveAuthor(authorDto);
            return new ResponseEntity<>(GenericResponseDto.<String>builder()
                    .correcto(true)
                    .mensaje("Autor registrado correctamente")
                    .build(), HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(GenericResponseDto.<String>builder()
                    .correcto(false)
                    .mensaje("Error al registrar el autor")
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<GenericResponseDto<AuthorDto>> getAuthorById(@PathVariable Integer authorId) {
        AuthorDto authorDto = authorService.findAuthorById(authorId);
        if (authorDto != null) {
            return new ResponseEntity<>(GenericResponseDto.<AuthorDto>builder()
                    .correcto(true)
                    .mensaje("Autor encontrado")
                    .respuesta(authorDto)
                    .build(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(GenericResponseDto.<AuthorDto>builder()
                    .correcto(false)
                    .mensaje("Autor no encontrado")
                    .build(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/first-name/{firstName}")
    public ResponseEntity<GenericResponseDto<List<AuthorDto>>> getAuthorsByFirstName(@PathVariable String firstName) {
        List<AuthorDto> authors = authorService.findByFirstName(firstName);
        if (authors.isEmpty()) {
            return new ResponseEntity<>(GenericResponseDto.<List<AuthorDto>>builder()
                    .correcto(false)
                    .mensaje("No se encontraron autores con ese nombre")
                    .build(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(GenericResponseDto.<List<AuthorDto>>builder()
                    .correcto(true)
                    .mensaje("Listado de autores encontrados")
                    .respuesta(authors)
                    .build(), HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<GenericResponseDto<List<AuthorDto>>> getAllAuthors() {
        List<AuthorDto> authors = authorService.findAllAuthors();
        return new ResponseEntity<>(GenericResponseDto.<List<AuthorDto>>builder()
                .correcto(true)
                .mensaje("Listado de todos los autores")
                .respuesta(authors)
                .build(), HttpStatus.OK);
    }
}

package com.example.aula08;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ClientHttpResponseDecorator;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping

public class MensagemController {

    private List<Message> mensagens = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Message>> listar(){
        if (mensagens.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(mensagens);
    }

    @PostMapping
    public ResponseEntity<Message> adicionar(@RequestBody Message mensagem) {
        mensagens.add(mensagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
    }

    @DeleteMapping("/{index}")
    public String remover(@PathVariable int index) {
        if (index >= 0 && index < mensagens.size()) {
            mensagens.remove(index);
            return "Mensagem removida!";
        }

        return "Índice inválido ou array vazio!";
    }

    @PutMapping("/{index}")
    public String update(@PathVariable int index, @RequestBody Message mensagem) {
        if (index >= 0 && index < mensagens.size()) {
            mensagens.set(index, mensagem);
            return "Mensagem removida!";
        }
        return "AAAAAAAAAA";
    }
}

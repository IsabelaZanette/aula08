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

    @GetMapping("/{ID}")
    public ResponseEntity<Message> listarID(@PathVariable int ID){
        if (ID < 0 || ID >= mensagens.size()){
            return ResponseEntity.badRequest().build();
        }
        Message msg = mensagens.get(ID);
        return ResponseEntity.ok(msg);
    }

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
    public ResponseEntity<Message> deleteMessage(@PathVariable int index) {
        if (index >= 0 && index < mensagens.size()) {
            Message msg = mensagens.get(index);
            mensagens.remove(index);
            return ResponseEntity.ok(msg);
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{index}")
    public ResponseEntity<Message> updateMessage(@PathVariable int index, @RequestBody Message mensagem) {
        if (index >= 0 && index < mensagens.size()) {
            mensagens.set(index, mensagem);
            Message msg = mensagens.get(index);
            return ResponseEntity.ok(msg);
        }
        return ResponseEntity.badRequest().build();
    }
}

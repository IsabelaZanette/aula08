package com.example.aula08;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class MensagemService {
    private List<Message> mensagens = new ArrayList<>();

    public Message listarID(int ID){
        if (ID < 0 || ID >= mensagens.size()){
            return null;
        }
        Message msg = mensagens.get(ID);
        return msg;
    }

    public List <Message> listar(){
        return mensagens;
        }

    public Message adicionar(Message mensagem) {
        mensagens.add(mensagem);
        return mensagem;
    }

    public Message deleteMessage(int index) {
        if (index >= 0 && index < mensagens.size()) {
            Message msg = mensagens.get(index);
            mensagens.remove(index);
            return msg;
        }

        return null;
    }

    public Message updateMessage(int index, Message mensagem) {
        if (index >= 0 && index < mensagens.size()) {
            mensagens.set(index, mensagem);
            Message msg = mensagens.get(index);
            return msg;
        }
        return null;
    }
}


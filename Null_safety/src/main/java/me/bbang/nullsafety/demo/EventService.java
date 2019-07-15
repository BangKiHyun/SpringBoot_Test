package me.bbang.nullsafety.demo;

import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @NonNull
    public String createEvent(@NonNull String name){
        return "hello" + name;
    }
}

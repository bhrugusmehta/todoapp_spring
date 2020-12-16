package com.livesoft.todoapp.model;

import lombok.*;
//import org.springframework.data.annotation.Id;
import javax.persistence.Id; 
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Entity
@Component
@Data
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NonNull
    private String task;
    private Boolean status = false;
}

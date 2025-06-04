package org.aston.homework5US.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private int age;

    @Column(name = "created_date") //Это JPA-аннотация: говорит Hibernate, что это поле будет связано с колонкой в таблице с именно таким именем. Если название поля совпадает с названием колонки — можно не писать @Column. Если хочешь переименовать колонку или задать свойства (уникальность, nullable и др.) — используешь @Column(...).
    private LocalDateTime createdDate = LocalDateTime.now();
}

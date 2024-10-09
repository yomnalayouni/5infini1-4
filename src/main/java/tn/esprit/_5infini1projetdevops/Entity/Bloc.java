package tn.esprit._5infini1projetdevops.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @ToString
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Table(name = "bloc")
    public class Bloc {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long idBloc;
        String nomBloc;
        Long capaciteBloc;



























































































    }


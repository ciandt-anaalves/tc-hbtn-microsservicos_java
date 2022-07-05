package com.song.demo;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Song implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String artista;
    private String album;
    private String anoLancamento;

    @Override
    public String toString() {
        return "Song {" +
                "id:" + id +
                ", nome: '" + nome + '\'' +
                ", artista: '" + artista + '\'' +
                ", album: '" + album + '\'' +
                ", ano lancamento: '" + anoLancamento + '\'' +
                '}';
    }

}

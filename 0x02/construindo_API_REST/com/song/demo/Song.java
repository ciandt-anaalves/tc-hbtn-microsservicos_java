package com.song.demo;

import java.io.Serializable;
import java.util.Objects;

public class Song implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String artista;
    private String album;
    private String anoLancamento;

    public Song() {
    }

    public Song(Integer id, String nome, String artista, String album, String anoLancamento) {
        setId(id);
        setNome(nome);
        setArtista(artista);
        setAlbum(album);
        setAnoLancamento(anoLancamento);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) && Objects.equals(nome, song.nome) && Objects.equals(artista, song.artista) && Objects.equals(album, song.album) && Objects.equals(anoLancamento, song.anoLancamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, artista, album, anoLancamento);
    }

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

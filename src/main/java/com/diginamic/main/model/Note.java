package com.diginamic.main.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "NOTE")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "corps_note")
    private String corps;
    @Column(name = "date_note")
    private LocalDateTime date;

    public Note(Integer id, String corps, LocalDateTime date) {
        this.id = id;
        this.corps = corps;
        this.date = date;
    }

    public Note() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id.equals(note.id) &&
                Objects.equals(corps, note.corps) &&
                Objects.equals(date, note.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, corps, date);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", corps='" + corps + '\'' +
                ", date=" + date +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

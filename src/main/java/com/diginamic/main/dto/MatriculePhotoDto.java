package com.diginamic.main.dto;

import java.util.Objects;

public class MatriculePhotoDto {

    private String matricule;
    private String photo;

    public MatriculePhotoDto(String matricule, String photo) {
        this.matricule = matricule;
        this.photo = photo;
    }

    public MatriculePhotoDto() {
    }

    @Override
    public String toString() {
        return "MatriculePhotoDto{" +
                "matricule='" + matricule + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatriculePhotoDto that = (MatriculePhotoDto) o;
        return Objects.equals(matricule, that.matricule) &&
                Objects.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule, photo);
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

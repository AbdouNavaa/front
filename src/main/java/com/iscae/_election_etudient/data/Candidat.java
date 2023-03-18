package com.iscae._election_etudient.data;

import com.iscae._election_etudient.SyndMangement.dtos.CandidatDto;
import com.iscae._election_etudient.data.Etudient;
import com.iscae._election_etudient.data.Syndicat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

/**
 * @author Abderrahmane
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Entity
@Table(name = "candidat", schema = "iscae_sb_db", catalog = "")
public class Candidat {
    private Integer id;
    private String poste;
    private Integer idSyndicat;
    private Integer idEtudient;
    private Syndicat syndicatByIdSynd;
    private Etudient etudiantsByIdEtudient;

    public Candidat() {

    }


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_etudient")
    public Integer getIdEtudient() {
        return idEtudient;
    }

    public void setIdEtudient(Integer idEtudient) {
        this.idEtudient = idEtudient;
    }

    @Basic
    @Column(name = "id_synd")
    public Integer getIdSyndicat() {
        return idSyndicat;
    }

    public void setIdSyndicat(Integer idSyndicat) {
        this.idSyndicat = idSyndicat;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }


    @ManyToOne
    @JoinColumn(name = "id_synd", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Syndicat getSyndicatByIdSynd() {
        return syndicatByIdSynd;
    }

    public void setSyndicatByIdSynd(Syndicat syndicatByIdSynd) {
        this.syndicatByIdSynd = syndicatByIdSynd;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidat that = (Candidat) o;
        return Objects.equals(id, that.id) && Objects.equals(poste, that.poste) && Objects.equals(idSyndicat, that.idSyndicat)
                && Objects.equals(idEtudient, that.idEtudient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, poste, idSyndicat, idEtudient);
    }



    @OneToOne
    @JoinColumn(name = "id_etudient", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Etudient getEtudiantsByIdEtudient() {
        return etudiantsByIdEtudient;
    }



    public void setEtudiantsByIdEtudient(Etudient etudient) {
        this.etudiantsByIdEtudient = etudient;
    }

    public CandidatDto toCandidatDto(Candidat candidat) {
        return CandidatDto.builder()
                .id(candidat.getId())
                .idSyndicat(candidat.getIdSyndicat())
                .poste(candidat.getPoste())
                .idEtudiant(candidat.getEtudiantsByIdEtudient().getId())
                .nomEtud(candidat.getEtudiantsByIdEtudient().getNom())
                .build();
    }

}

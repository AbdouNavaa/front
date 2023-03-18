package com.iscae._election_etudient.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iscae._election_etudient.SyndMangement.dtos.Syndicat_Dto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Entity
public class Syndicat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "syndicat_nom", nullable = true, length = 100)
    private String syndicatNom;
    @Basic
    @Column(name = "nombre_vote", nullable = false)
    private int nombreVote;
    @Basic
    @Column(name = "FK_Election", nullable = false)
    private int fkElection;
    @Basic
    @Column(name = "logo", nullable = true, length = 100)
    private String logo;
    @OneToMany(mappedBy = "syndicatByIdSynd")
    private Collection<Candidat> candidatsById;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "FK_Election", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Election electionByFkElection;

    public Syndicat() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSyndicatNom() {
        return syndicatNom;
    }

    public void setSyndicatNom(String syndicatNom) {
        this.syndicatNom = syndicatNom;
    }

    public int getNombreVote() {
        return nombreVote;
    }

    public void setNombreVote(int nombreVote) {
        this.nombreVote = nombreVote;
    }

    public int getFkElection() {
        return fkElection;
    }

    public void setFkElection(int fkElection) {
        this.fkElection = fkElection;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Collection<Candidat> getCandidatsById() {
        return candidatsById;
    }

    public void setCandidatsById(Collection<Candidat> candidatsById) {
        this.candidatsById = candidatsById;
    }

    public Election getElectionByFkElection() {
        return electionByFkElection;
    }

    public void setElectionByFkElection(Election electionByFkElection) {
        this.electionByFkElection = electionByFkElection;
    }

    public Syndicat_Dto toSyndicatDto(Syndicat syndicat) {
        return Syndicat_Dto.builder()
                .id(syndicat.getId())
                .syndicat_nom(syndicat.getSyndicatNom())
                .nombreVote(syndicat.getNombreVote())
                .fkElection(syndicat.getFkElection())
                .logo(syndicat.getLogo())
                .build();
    }
}

package com.iscae._election_etudient.SyndMangement.dtos;

import com.iscae._election_etudient.data.Candidat;
import lombok.Builder;
import lombok.Data;

/**
 * @author Abderrahmane
 */
@Data
@Builder
public class CandidatDto {
    private Integer id;
    private Integer idSyndicat;
    private String poste;
    private Integer idEtudiant;
    private String nomEtud;

    public Candidat toCandidatEntity(CandidatDto candidatDto) {
        return toCandidatEntity_(candidatDto, new Candidat());
    }

    public Candidat toCandidatEntity(CandidatDto candidatDto, Candidat candidat) {
        return toCandidatEntity_(candidatDto, candidat);
    }

    private static Candidat toCandidatEntity_(CandidatDto candidatDto, Candidat candidat) {
        return candidat.toBuilder()
                .idEtudient(candidatDto.getIdEtudiant())
                .idSyndicat(candidatDto.getIdSyndicat())
                .poste(candidatDto.getPoste())
                .build();
    }
}

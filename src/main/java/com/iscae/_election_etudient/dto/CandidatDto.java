package com.iscae._election_etudient.dto;

import com.iscae._election_etudient.data.Candidat;

import java.util.List;

public interface CandidatDto {
    Candidat saveCandidat(Candidat candidat);

    void deleleCandidat(Integer id);

    Candidat updateCandidat(Candidat candidat);

    Candidat getCandidat(int id);

    List<Candidat> getCandidats();
}

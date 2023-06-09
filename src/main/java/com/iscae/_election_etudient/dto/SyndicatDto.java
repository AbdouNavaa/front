package com.iscae._election_etudient.dto;



import com.iscae._election_etudient.data.Syndicat;

import java.util.List;

public interface SyndicatDto {
    Syndicat saveSyndicat(Syndicat etudientinscription);
    Syndicat updateSyndicat(Syndicat etudientinscription);
    Syndicat getSyndicat(String email);

    void deleteSyndicat(Integer id);

    List< Syndicat> getSyndicats();
}

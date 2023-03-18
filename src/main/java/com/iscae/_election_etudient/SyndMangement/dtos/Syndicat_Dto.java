package com.iscae._election_etudient.SyndMangement.dtos;

import com.iscae._election_etudient.data.Syndicat;
import lombok.Builder;
import lombok.Data;

/**
 * @author Abderrahmane
 */
@Data
@Builder
public class Syndicat_Dto {
    private Integer id;
    private String syndicat_nom;
    private int nombreVote;
    private int fkElection;
    private String logo;


     public Syndicat_Dto() {
    }
//
    public Syndicat_Dto(int id,  String syndicat_nom,int nombreVote, int fkElection, String logo) {
        this.id = id;
        this.syndicat_nom = syndicat_nom;
        this.nombreVote = nombreVote;
        this.fkElection = fkElection;
        this.logo = logo;
    }
//
    private static Syndicat toSyndicatDto_(Syndicat_Dto syndicatDto, Syndicat syndicat) {
        return syndicat.toBuilder()
                .syndicatNom(syndicatDto.getSyndicat_nom())
                .nombreVote(syndicatDto.getNombreVote())
                .fkElection(syndicatDto.getFkElection())
                .logo(syndicatDto.getLogo())
                .build();
    }
    public Syndicat toSyndicatDto(Syndicat_Dto syndicatDto) {

        return toSyndicatDto_(syndicatDto, new Syndicat());
    }
//
    public Syndicat toSyndicatDto(Syndicat_Dto syndicatDto, Syndicat syndicat) {
        return toSyndicatDto_(syndicatDto, syndicat);
    }
}

package com.iscae._election_etudient.services;

import com.iscae._election_etudient.data.Candidat;
import com.iscae._election_etudient.data.Syndicat;
import com.iscae._election_etudient.dto.SyndicatDto;
import com.iscae._election_etudient.repository.SyndicatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SyndicatServices implements SyndicatDto {
    private  final SyndicatRepository syndicatRepo;
    @Override
    public Syndicat saveSyndicat(Syndicat syndicat) {
        return syndicatRepo.save(syndicat);
    }


    @Override
    public void deleteSyndicat(Integer id) {
        Syndicat e=syndicatRepo.findSyndicatyById(id);
        if(e==null){
            throw new RuntimeException("Syndicat introvable");
        }else {
            syndicatRepo.deleteById(id);
        }

    }

    @Override
    public Syndicat updateSyndicat(Syndicat syndicat) {
        return syndicatRepo.save(syndicat);
    }

    @Override
    public Syndicat getSyndicat(String name) {
        Syndicat c=syndicatRepo.findSyndicatBySyndicatNom(name);
        if(c==null){
           throw new RuntimeException("Syndicat n`exist pas") ;
        }else {
            return  c;
        }

    }

    @Override
    public List<Syndicat> getSyndicats() {
        return syndicatRepo.findAll();
    }
}

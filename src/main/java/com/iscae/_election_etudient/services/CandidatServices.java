package com.iscae._election_etudient.services;

import com.iscae._election_etudient.data.Candidat;
import com.iscae._election_etudient.dto.CandidatDto;
import com.iscae._election_etudient.repository.CandidatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CandidatServices implements CandidatDto {
    private  final CandidatRepository candidatRepo;
    @Override
    public Candidat saveCandidat(Candidat candidat) {
        return candidatRepo.save(candidat);
    }

    @Override
    public void deleleCandidat(Integer id) {
        Candidat e=candidatRepo.findCandidatById(id);
        if(e==null){
            throw new RuntimeException("Candidat introvable");
        }else {
            candidatRepo.deleteById(id);
        }

    }

    @Override
    public Candidat updateCandidat(Candidat candidat) {
        return candidatRepo.save(candidat);
    }

    @Override
    public Candidat getCandidat(int id) {
        Candidat c=candidatRepo.findCandidatById(id);
        if(c==null){
           throw new RuntimeException("Candidat n`exist pas") ;
        }else {
            return  c;
        }

    }

    @Override
    public List<Candidat> getCandidats() {
        return candidatRepo.findAll();
    }
}

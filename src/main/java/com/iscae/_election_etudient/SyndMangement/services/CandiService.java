package com.iscae._election_etudient.SyndMangement.services;

import com.iscae._election_etudient.SyndMangement.dtos.CandidatDto;
import com.iscae._election_etudient.data.Candidat;
import com.iscae._election_etudient.repository.CandidatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Abderrahmane
 */
@Service
public class CandiService {
    private final CandidatRepository candidatRepo;

    public CandiService(CandidatRepository candidatRepo) {

        this.candidatRepo = candidatRepo;
    }

    public List<CandidatDto> getCandidats(Integer FK_Syndicat) {
        return candidatRepo.findAllByIdSyndicat(FK_Syndicat).stream()
                .map(m -> m.toCandidatDto(m))
                .collect(Collectors.toList());
    }


    public void add(CandidatDto candidatDto) {

        candidatRepo.save(candidatDto.toCandidatEntity(candidatDto));
    }

    public void update(CandidatDto candidatDto, Integer id) {
        Candidat candidat = candidatRepo.findById(id).orElseThrow();
        candidatRepo.save(candidatDto.toCandidatEntity(candidatDto, candidat));
    }

    public void delete(Integer id) {
        candidatRepo.deleteById(id);
    }
}

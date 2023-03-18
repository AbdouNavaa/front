package com.iscae._election_etudient.SyndMangement.services;

import com.iscae._election_etudient.SyndMangement.dtos.Syndicat_Dto;
import com.iscae._election_etudient.data.Syndicat;
import com.iscae._election_etudient.repository.SyndicatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Abderrahmane
 */
@Service
public class SyndicatService {
    private final SyndicatRepository syndRepo;

    public SyndicatService(SyndicatRepository syndRepo) {
        this.syndRepo = syndRepo;
    }

    public List<Syndicat_Dto> getSynds() {
        return syndRepo.findAll().stream()
                .map(m -> m.toSyndicatDto(m))
                .collect(Collectors.toList());
    }

//    @Override
    public List<Syndicat> getSyndicats() {
        return syndRepo.findAll();
    }



    public void add(Syndicat_Dto syndicatDto) {

        syndRepo.save(syndicatDto.toSyndicatDto(syndicatDto));
    }

    public void update(Syndicat_Dto syndicatDto, Integer id) {
        Syndicat syndicat = syndRepo.findById(id).orElseThrow();
        syndRepo.save(syndicatDto.toSyndicatDto(syndicatDto, syndicat));
    }

    public void delete(Integer id) {
        syndRepo.deleteById(id);
    }


}

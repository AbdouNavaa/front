package com.iscae._election_etudient.controller;

import com.iscae._election_etudient.data.Candidat;
import com.iscae._election_etudient.data.Election;
import com.iscae._election_etudient.services.CandidatServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/election/")

public class CandidatController {
    final CandidatServices candidatServices;
///----vote/vefification
    public CandidatController(CandidatServices CandidatServices) {
        this.candidatServices = CandidatServices;
    }
    @GetMapping("public/candidat/all")
    public ResponseEntity<List<Candidat>> getAllcandidats (){
        List<Candidat> candidats = candidatServices.getCandidats();
        return new ResponseEntity<>(candidats, HttpStatus.OK);
    }

    @PostMapping("public/candidat/add")
    public ResponseEntity<Candidat> addElection(@RequestBody Candidat candidat){
        Candidat newCandidat= candidatServices.saveCandidat(candidat);
        return new ResponseEntity<>(newCandidat, HttpStatus.CREATED);
    }


    @PutMapping("admin/candidat/update/")
    public ResponseEntity<Candidat> updateElection(@RequestBody Candidat candidat){
        Candidat upCandidat= candidatServices.updateCandidat(candidat);
        return new ResponseEntity<>(upCandidat, HttpStatus.OK);
    }

    @DeleteMapping("admin/candidat/delete/{id}")
    public ResponseEntity<?> deleteElection(@PathVariable("id") int id){
        candidatServices.deleleCandidat(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

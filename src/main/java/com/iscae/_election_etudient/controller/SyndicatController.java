package com.iscae._election_etudient.controller;


import com.iscae._election_etudient.controller.request_response.verificationRequest;
import com.iscae._election_etudient.data.Etudient;
import com.iscae._election_etudient.data.Syndicat;
import com.iscae._election_etudient.services.EtudientServices;
import com.iscae._election_etudient.services.SyndicatServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/syndicat/")
public class SyndicatController {

    final SyndicatServices syndicatServices;

    public SyndicatController(SyndicatServices syndicatServices) {
        this.syndicatServices = syndicatServices;
    }

    @GetMapping("public/syndicat/get/{nom}")
    public Syndicat getSyndicatByName(@PathVariable("nom") String nom){
        return syndicatServices.getSyndicat(nom);
    }
    @GetMapping("admin/syndicat/all")
    public ResponseEntity<List<Syndicat>> getAllSyndicats (){
        List<Syndicat> syndicats = syndicatServices.getSyndicats();
        return new ResponseEntity<>(syndicats, HttpStatus.OK);
    }

    @PostMapping("admin/syndicat/add")
    public ResponseEntity<Syndicat> addSyndicat(@RequestBody Syndicat syndicat){
        Syndicat newSyndicat = syndicatServices.saveSyndicat(syndicat);
        return new ResponseEntity<>(newSyndicat, HttpStatus.CREATED);
    }

//    @GetMapping("public/vote/verification")
//    public ResponseEntity<Etudient> verificationVote(@RequestBody verificationRequest et){
//        Etudient newEtudient = syndicatServices.get(et.getEmail(), et.getINE());
//        return new ResponseEntity<>(newEtudient, HttpStatus.CREATED);
//    }



    @PutMapping("admin/syndicat/update/")
    public ResponseEntity<Syndicat> updateEtudient(@RequestBody Syndicat syndicat){
        Syndicat upSyndicat = syndicatServices.updateSyndicat(syndicat);
        return new ResponseEntity<>(upSyndicat, HttpStatus.OK);
    }

    @DeleteMapping("admin/syndicat/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        syndicatServices.deleteSyndicat(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

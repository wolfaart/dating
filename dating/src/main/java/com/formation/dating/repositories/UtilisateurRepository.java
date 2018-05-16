package com.formation.dating.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.formation.dating.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur,Integer>{

}

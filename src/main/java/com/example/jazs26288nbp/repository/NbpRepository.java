package com.example.jazs26288nbp.repository;

import com.example.jazs26288nbp.model.NbpRepoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NbpRepository extends JpaRepository<NbpRepoModel, Long> {

}

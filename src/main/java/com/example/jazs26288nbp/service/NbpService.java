package com.example.jazs26288nbp.service;

import com.example.jazs26288nbp.model.NbpModel;
//import com.example.jazs26288nbp.repository.NbpRepository;
import com.example.jazs26288nbp.model.NbpRepoModel;
import com.example.jazs26288nbp.model.Rate;
import com.example.jazs26288nbp.repository.NbpRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import static org.aspectj.runtime.internal.Conversions.intValue;

@Service
public class NbpService {
    private final NbpRepository nbpRepository;
    RestTemplate restTemplate;

    public NbpService(RestTemplate restTemplate, NbpRepository nbpRepository) {
        this.restTemplate = restTemplate;
        this.nbpRepository = nbpRepository;
    }

    public NbpRepoModel getCurrency(String currency, LocalDate start_date, LocalDate end_date) {
        String nbp_url = "http://api.nbp.pl/api/exchangerates/rates/a/"+currency+"/"+start_date+"/"+end_date;
        NbpModel nbpModel = restTemplate.getForObject(nbp_url, NbpModel.class, currency);
        NbpRepoModel nbpRepoModel = new NbpRepoModel();
        nbpRepoModel.setCurrency(nbpModel.getCode());
        nbpRepoModel.setStart_date(Arrays.stream(nbpModel.getRates()).findFirst().get().getEffectiveDate());
        nbpRepoModel.setEnd_date(Arrays.stream(nbpModel.getRates()).toList().get(intValue(Arrays.stream(nbpModel.getRates()).toList().stream().count())-1).getEffectiveDate());
        double mid = 0.0;
        int days = 0;
        for (int i = 0; i < Arrays.stream(nbpModel.getRates()).toList().stream().count(); i++) {
            mid += Arrays.stream(nbpModel.getRates()).toList().get(i).getMid();
            days++;
        }
        nbpRepoModel.setResult(mid/days);
        nbpRepoModel.setDate(java.time.LocalDateTime.now().toLocalDate());
        nbpRepository.save(nbpRepoModel);
        return nbpRepoModel;
    }
}

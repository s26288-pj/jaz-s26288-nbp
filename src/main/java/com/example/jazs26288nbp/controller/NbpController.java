package com.example.jazs26288nbp.controller;

import com.example.jazs26288nbp.exception.CurrencyNotFoundException;
import com.example.jazs26288nbp.model.NbpModel;
import com.example.jazs26288nbp.model.NbpRepoModel;
import com.example.jazs26288nbp.service.NbpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;

@RestController
@RequestMapping("/nbp")
public class NbpController {
    private final NbpService nbpService;

    public NbpController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @GetMapping("/{currency}/{start_date}/{end_date}")
    @Operation(summary = "Get currency rates from start date to end date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found currency status",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = NbpRepoModel.class))}),
            @ApiResponse(responseCode = "404", description = "Cuurency not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Unknown Exception",
                    content = @Content)})
    public ResponseEntity<NbpRepoModel> getRate(@PathVariable("currency") String currency,
                                                @PathVariable("start_date") LocalDate start_date,
                                                @PathVariable("end_date") LocalDate end_date) throws CurrencyNotFoundException {
        return ResponseEntity.ok(nbpService.getCurrency(currency, start_date, end_date));
    }
}

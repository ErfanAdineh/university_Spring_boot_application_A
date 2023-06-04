package com.university.universityapplication_erfanadine.controller;

import com.university.universityapplication_erfanadine.dto.WalletDto;
import com.university.universityapplication_erfanadine.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {


    @Autowired
    private WalletService walletService;

    @PostMapping
    public void save(WalletDto walletDto){
        walletService.save(walletDto);
    }
    @GetMapping
    public void findById(Long id){
        walletService.findById(id);
    }
    @PutMapping
    public void update(WalletDto walletDto){

        walletService.save(walletDto);
    }
}

package com.university.universityapplication_erfanadine.service;

import com.university.universityapplication_erfanadine.dto.WalletDto;
import com.university.universityapplication_erfanadine.entity.Wallet;
import com.university.universityapplication_erfanadine.repository.StudentRepo;
import com.university.universityapplication_erfanadine.repository.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    private WalletRepo walletRepo;

    @Autowired
    private StudentRepo studentRepo;


    public WalletDto save(WalletDto walletDto) {
        return convertWalletModelToWalletDto(walletRepo.save(convertWalletDtoToWalletModel(walletDto)));
    }

    public WalletDto update(WalletDto walletDto) {
        return convertWalletModelToWalletDto(walletRepo.save(convertWalletDtoToWalletModel(walletDto)));
    }

    public WalletDto findById(Long id) {
        return convertWalletModelToWalletDto(walletRepo.findById(id).orElseThrow(() ->
                new RuntimeException("not found lesson by this id : " + id)));
    }


    public WalletDto convertWalletModelToWalletDto(Wallet wallet) {
        if (wallet == null) {
            return null;
        }

        WalletDto walletDto = new WalletDto();

        walletDto.setId(wallet.getId());
        walletDto.setCash(wallet.getCash());
        walletDto.setStudentId(wallet.getStudent().getId());

        return walletDto;
    }

    public Wallet convertWalletDtoToWalletModel(WalletDto walletDto) {
        if (walletDto == null) {
            return null;
        }

        Wallet wallet = new Wallet();

        wallet.setId(walletDto.getId());
        wallet.setCash(walletDto.getCash());
        wallet.setStudent(studentRepo.findById(walletDto.getStudentId()).get());

        return wallet;
    }

}

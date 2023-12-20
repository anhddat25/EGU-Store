package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.AddVoucherDTO;
import com.egustore.eshop.dto.VoucherDTO;
import com.egustore.eshop.enums.VoucherStatus;
import com.egustore.eshop.model.Voucher;
import com.egustore.eshop.repository.VoucherRepository;
import com.egustore.eshop.service.VoucherService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@EnableScheduling
public class VoucherServiceImpl implements VoucherService {

    private final VoucherRepository voucherRepository;

    public VoucherServiceImpl(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    @Override
    public Voucher createVoucher(VoucherDTO voucherDTO) {
        String randomVoucherCode = generateRandomVoucherCode(6);
        Voucher voucher = new Voucher();
        voucher.setCodeVoucher(voucherDTO.getCodeVoucher()+randomVoucherCode);
        voucher.setValue(voucherDTO.getValue());
        voucher.setExpiredDate(voucherDTO.getExpiredDate());
        voucher.setStatus(VoucherStatus.ACTIVE);
        return voucherRepository.save(voucher);
    }

    private String generateRandomVoucherCode(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder randomCode = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            randomCode.append(characters.charAt(index));
        }
        return randomCode.toString();
    }
    @Override
    public List<Voucher> getActiveVouchersForCustomer(int customerId) {
        return voucherRepository.findByCustomerId( customerId);
    }

    @Override
    public void addMyVoucher(AddVoucherDTO addVoucherDTO) throws Exception {
        Voucher voucher = voucherRepository.findByCodeVoucher(addVoucherDTO.getCodeVoucher()).orElseThrow(() -> new IllegalArgumentException("Voucher code does not exist"));
        if ( voucher != null && voucher.isActive() && voucher.getCustomerId()==0) {
            voucher.setCustomerId(addVoucherDTO.getCustomerId());
            voucherRepository.save(voucher);
        } else {
            throw new Exception("Voucher code does not exist");
        }
    }

    public Optional<Voucher> findByCodeVoucher(String codeVoucher,int customerId) throws Exception {
        Optional<Voucher> voucherOptional = voucherRepository.findByCodeVoucher(codeVoucher);
        if (voucherOptional.isPresent()) {
            Voucher voucher = voucherOptional.get();
            if (voucher.isActive() && (voucher.getCustomerId() == customerId||voucher.getCustomerId() ==0)) {
                return voucherOptional;
            } else {
                throw new Exception("Voucher code does not meet conditions");
            }
        } else {
            throw new Exception("Voucher code does not exist");
        }
    }

    @Override
    public void useMyVoucher(String codeVoucher) throws Exception {
        Optional<Voucher> optionalVoucher = voucherRepository.findByCodeVoucher(codeVoucher);
        Voucher voucher = optionalVoucher.orElseThrow(() -> new IllegalArgumentException("Voucher code does not exist"));
        voucher.setStatus(VoucherStatus.USED);
        voucherRepository.save(voucher);
    }

    @Override
    @Transactional
    @Scheduled(cron = "0 0 0 * * ?") // Chạy vào mỗi ngày lúc 00:00:00
    public void updateVoucherStatus() {
        List<Voucher> vouchers = voucherRepository.findAllByExpiredDateBeforeAndStatusNot(new Date(), VoucherStatus.EXPIRED);
        for (Voucher voucher : vouchers) {
            voucher.setStatus(VoucherStatus.EXPIRED);
            voucherRepository.save(voucher);
        }
    }
    @Override
    public List<Voucher> getAllVoucher() {
        return voucherRepository.findAll();
    }

    @Override
    public Optional<Voucher> findVoucherById(int id) {
        return voucherRepository.findById(id);
    }

    @Override
    public void deleteVoucher(int id) {
        voucherRepository.deleteById(id);
    }
}

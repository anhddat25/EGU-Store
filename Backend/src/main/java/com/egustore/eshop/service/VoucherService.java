package com.egustore.eshop.service;

import com.egustore.eshop.dto.AddVoucherDTO;
import com.egustore.eshop.dto.VoucherDTO;
import com.egustore.eshop.model.Voucher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface VoucherService {
    Voucher createVoucher(VoucherDTO voucherDTO);

    Optional<Voucher> findByCodeVoucher(String codeVoucher,int customerId) throws Exception;
    List<Voucher> getActiveVouchersForCustomer(int customerId);

    void addMyVoucher(AddVoucherDTO addVoucherDTO) throws Exception;

    void useMyVoucher(String codeVoucher) throws Exception;

    void updateVoucherStatus();
    List<Voucher> getAllVoucher();
    Optional<Voucher> findVoucherById(int id);
    void deleteVoucher(int id);
}

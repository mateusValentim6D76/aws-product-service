package br.com.mv.cloud.aws.service;

import br.com.mv.cloud.aws.model.Invoice;
import br.com.mv.cloud.aws.model.UrlResponse;

import java.util.List;

public interface InvoiceService {

    UrlResponse createInvoiceUrl();

    List<Invoice> findAllByCustomerName(String customerName);

    List<Invoice> findAll();
}

package br.com.mv.cloud.aws.service;

import br.com.mv.cloud.aws.model.Invoice;
import br.com.mv.cloud.aws.model.UrlResponse;

public interface InvoiceService {

    UrlResponse createInvoiceUrl();

    Iterable<Invoice> findAllByCustomerName(String customerName);

    Iterable<Invoice> findAll();
}

package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product pencilProduct = new Product("Pencil");
        Product penProduct = new Product("Pen");
        Item item1 = new Item(new BigDecimal(5), 10);
        Item item2 = new Item(new BigDecimal(17), 1);
        Item item3 = new Item(new BigDecimal(9), 2);
        Invoice invoice = new Invoice("FV/456/03/18");
        item1.setProduct(pencilProduct);
        item1.setInvoice(invoice);
        item2.setProduct(penProduct);
        item2.setInvoice(invoice);
        item3.setProduct(pencilProduct);
        item3.setInvoice(invoice);
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();
        Invoice invoiceResult = invoiceDao.findById(id);
        String numberResult = invoiceResult.getNumber();
        //Then
        Assert.assertNotEquals(0, id);
        Assert.assertEquals(id, invoiceResult.getId());
        Assert.assertEquals("FV/456/03/18", numberResult);
        //CleanUp
        invoiceDao.delete(id);
    }
}

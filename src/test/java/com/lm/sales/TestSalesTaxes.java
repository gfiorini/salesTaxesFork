package com.lm.sales;

import com.lm.sales.controller.SalesTaxesController;
import com.lm.sales.factory.IReceiptManagerFactory;
import com.lm.sales.formatter.IReceiptFormatter;
import com.lm.sales.helper.ITaxRounder;
import com.lm.sales.manager.receipt.IReceiptManager;
import com.lm.sales.model.*;

import com.lm.sales.processor.ImportedSaleProcessor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SalesTaxesController.class})
public class TestSalesTaxes {

    @Autowired
    private IReceiptManagerFactory receiptManagerFactory;

    @Autowired
    private IReceiptFormatter receiptFormatter;

    @Autowired
    private ImportedSaleProcessor importedSaleProcessor;

    @Autowired
    private ITaxRounder rounder;
    @Test
    public void testInput1() throws IOException {

        /*
            1 book at 12.49
            1 music CD at 14.99
            1 chocolate bar at 0.85
         */

        System.out.println("\n ********* TEST INPUT 1 ******** ");

        BufferedReader br = getBufferedReader("input/input_1.txt");
        Cart cart = getCart1();

        List<String> stringItems = cart.toList();
        Iterator<String> stringIterator = stringItems.iterator();

        Assert.assertEquals(3, stringItems.size());
        checkEqualsLines(br, stringIterator);

        System.out.println(" ************************** ");
    }

    @Test
    public void testInput2() throws IOException {

        /*
            1 imported box of chocolates at 10.00
            1 imported bottle of perfume at 47.50
         */

        System.out.println(" ********* TEST INPUT 2 ******** ");

        BufferedReader br = getBufferedReader("input/input_2.txt");
        Cart cart = getCart2();

        List<String> stringItems = cart.toList();
        Iterator<String> stringIterator = stringItems.iterator();

        Assert.assertEquals(2, stringItems.size());
        checkEqualsLines(br, stringIterator);

        System.out.println(" ************************** ");
    }

    @Test
    public void testInput3() throws IOException {

        /*
            1 imported bottle of perfume at 27.99
            1 bottle of perfume at 18.99
            1 packet of headache pills at 9.75
            1 box of imported chocolates at 11.25
         */

        System.out.println(" ********* TEST INPUT 3 ******** ");

        BufferedReader br = getBufferedReader("input/input_3.txt");

        Cart cart = getCart3();

        List<String> stringItems = cart.toList();
        Iterator<String> stringIterator = stringItems.iterator();

        Assert.assertEquals(4, stringItems.size());
        checkEqualsLines(br, stringIterator);

        System.out.println(" ************************** ");
    }

    @Test
    public void testInput4() throws IOException {

        /*
            1 imported bottle of perfume at 27.99
            2 bottle of perfume at 37.98
            1 packet of headache pills at 9.75
            2 imported box of chocolates at 22.50
         */

        System.out.println(" ********* TEST INPUT 4 ******** ");

        BufferedReader br = getBufferedReader("input/input_4.txt");

        Cart cart = getCart4();

        List<String> stringItems = cart.toList();
        Iterator<String> stringIterator = stringItems.iterator();

        Assert.assertEquals(4, stringItems.size());
        checkEqualsLines(br, stringIterator);

        System.out.println(" ************************** ");
    }

    @Test
    public void testRounding(){

        Amount value1 = new Amount(new BigDecimal("4.7321"));
        Amount rounded1 = rounder.round(value1);
        Assert.assertEquals("4.75", rounded1.getValue().toString());

        Amount value2 = new Amount(new BigDecimal("4.75"));
        Amount rounded2 = rounder.round(value2);
        Assert.assertEquals("4.75", rounded2.getValue().toString());

        Amount value3 = new Amount(new BigDecimal("0.5625"));
        Amount rounded3 = rounder.round(value3);
        Assert.assertEquals("0.60", rounded3.getValue().toString());

        Amount value4 = new Amount(new BigDecimal("2.375"));
        Amount rounded4 = rounder.round(value4);
        Assert.assertEquals("2.40", rounded4.getValue().toString());

    }



    @Test
    public void testReceipt1() throws IOException {

        System.out.println(" ********* TEST RECEIPT 1 ******** ");

        Cart cart = getCart1();
        IReceiptManager receiptManager = receiptManagerFactory.build("IT");
        Receipt receipt = receiptManager.calculateReceipt(cart);
        List<String> receiptLines = receiptFormatter.print(receipt);
        Assert.assertEquals(5, receiptLines.size());

        BufferedReader br = getBufferedReader("output/output_1.txt");
        Iterator<String> stringIterator = receiptLines.iterator();
        checkEqualsLines(br, stringIterator);

        System.out.println(" ************************** ");
    }

    @Test
    public void testReceipt2() throws IOException {

        System.out.println(" ********* TEST RECEIPT 2 ******** ");

        Cart cart = getCart2();
        IReceiptManager receiptManager = receiptManagerFactory.build("IT");
        Receipt receipt = receiptManager.calculateReceipt(cart);
        List<String> receiptLines = receiptFormatter.print(receipt);
        Assert.assertEquals(4, receiptLines.size());

        BufferedReader br = getBufferedReader("output/output_2.txt");
        Iterator<String> stringIterator = receiptLines.iterator();
        checkEqualsLines(br, stringIterator);

        System.out.println(" ************************** ");
    }

    @Test
    public void testReceipt3() throws IOException {

        System.out.println(" ********* TEST RECEIPT 3 ******** ");

        Cart cart = getCart3();
        IReceiptManager receiptManager = receiptManagerFactory.build("IT");
        Receipt receipt = receiptManager.calculateReceipt(cart);
        List<String> receiptLines = receiptFormatter.print(receipt);
        Assert.assertEquals(6, receiptLines.size());

        BufferedReader br = getBufferedReader("output/output_3.txt");
        Iterator<String> stringIterator = receiptLines.iterator();
        checkEqualsLines(br, stringIterator);

        System.out.println(" ************************** ");
    }

    @Test
    public void testReceipt4() throws IOException {

        System.out.println(" ********* TEST RECEIPT 4 ******** ");

        Cart cart = getCart4();
        IReceiptManager receiptManager = receiptManagerFactory.build("IT");
        Receipt receipt = receiptManager.calculateReceipt(cart);
        List<String> receiptLines = receiptFormatter.print(receipt);
        Assert.assertEquals(6, receiptLines.size());

        BufferedReader br = getBufferedReader("output/output_4.txt");
        Iterator<String> stringIterator = receiptLines.iterator();
        checkEqualsLines(br, stringIterator);

        System.out.println(" ************************** ");
    }



    private BufferedReader getBufferedReader(String resourceName) throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(resourceName).getFile());
        return new BufferedReader(new FileReader(file));
    }

    private void checkEqualsLines(BufferedReader br, Iterator<String> stringIterator) throws IOException {
        String st;
        while (stringIterator.hasNext()) {
            st = br.readLine();
            Assert.assertNotNull(st);
            String item = stringIterator.next();
            Assert.assertNotNull(item);
            Assert.assertEquals(st, item);
            System.out.println(st);
        }
    }

    private Cart getCart1() {
        Cart cart = new Cart();

        Item book = new Item(1l, "BOO01", "book", new Category("BOOK"));
        cart.addItem(book, new Amount(new BigDecimal("12.49")), false);

        Item cd = new Item(2l, "CD01", "music CD", new Category("MUSIC"));
        cart.addItem(cd, new Amount(new BigDecimal("14.99")), false);

        Item chocolate = new Item(3l, "CH01", "chocolate bar", new Category("FOOD"));
        cart.addItem(chocolate, new Amount(new BigDecimal("0.85")), false);

        return cart;
    }

    private Cart getCart2() {
        Cart cart = new Cart();

        Item book = new Item(1l, "CH001", "imported box of chocolates", new Category("FOOD"));
        cart.addItem(book, new Amount(new BigDecimal("10.00")), true);

        Item cd = new Item(2l, "PRF01", "imported bottle of perfume", new Category("COSMETICS"));
        cart.addItem(cd, new Amount(new BigDecimal("47.50")), true);

        return cart;
    }


    private Cart getCart3() {
        Cart cart = new Cart();

        Item importedPerfume = new Item(1l, "PRF01", "imported bottle of perfume", new Category("COSMETICS"));
        cart.addItem(importedPerfume, new Amount(new BigDecimal("27.99")), true);

        Item perfume = new Item(2l, "PRF02", "bottle of perfume", new Category("COSMETICS"));
        cart.addItem(perfume, new Amount(new BigDecimal("18.99")), false);

        Item pills = new Item(3l, "PIL01", "packet of headache pills", new Category("MEDICAL"));
        cart.addItem(pills, new Amount(new BigDecimal("9.75")), false);

        Item importedChocolate = new Item(4l, "CHO01", "imported box of chocolates", new Category("FOOD"));
        cart.addItem(importedChocolate, new Amount(new BigDecimal("11.25")), true);
        return cart;
    }

    private Cart getCart4() {
        Cart cart = new Cart();

        Item importedPerfume = new Item(1l, "PRF01", "imported bottle of perfume", new Category("COSMETICS"));
        cart.addItem(importedPerfume, new Amount(new BigDecimal("27.99")), true);

        Item perfume = new Item(2l, "PRF02", "bottle of perfume", new Category("COSMETICS"));
        cart.addItems(perfume, new Amount(new BigDecimal("18.99")), false, 2);

        Item pills = new Item(3l, "PIL01", "packet of headache pills", new Category("MEDICAL"));
        cart.addItem(pills, new Amount(new BigDecimal("9.75")), false);

        Item importedChocolate = new Item(4l, "CHO01", "imported box of chocolates", new Category("FOOD"));
        cart.addItems(importedChocolate, new Amount(new BigDecimal("11.25")), true, 2);
        return cart;
    }
}
